package com.collab.restcontroller;


import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



import com.collab.CollaborationBack.Service.UserService;
import com.collab.CollaborationBack.model.Error;
import com.collab.CollaborationBack.model.User;

@Controller
public class UserController {
	
	
	@Autowired
	private UserService userService;

	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ResponseEntity<?> login(@RequestBody User user,HttpSession session)
	{  
	   //user.setStatus("NA");
	   User validuser=userService.login(user);
		
	if(validuser==null)
	{
		
		Error error=new Error(4,"Invalid username/password");
		return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
	}
	System.out.println("online status before update"+ validuser.isOnline());
	validuser.setOnline(true);
	try{
		userService.update(validuser);
	}catch(Exception e)
	{
		Error error=new Error(6,"unable to update online status");
		return new ResponseEntity<Error>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	session.setAttribute("userName", user.getUserName());
	System.out.println("online status after update"+ validuser.isOnline());
	return new ResponseEntity<User>(validuser,HttpStatus.OK);
		
		
	}
	
	@RequestMapping(value="/registeruser",method=RequestMethod.POST)
	public ResponseEntity<?> registerUser(@RequestBody User user)
	{
		if(!userService.isvalidusername(user.getUserName()))
		{
			Error error=new Error(2,"username already exists");
			return new ResponseEntity<Error>(error,HttpStatus.NOT_ACCEPTABLE);
		
		}
		if(!userService.isvalidemail(user.getEmailId()))
		{
			Error error=new Error(3,"emailId already exists");
			return new ResponseEntity<Error>(error,HttpStatus.NOT_ACCEPTABLE);
		
		}
		boolean result=userService.registeruser(user);
		if(result)
		{
			return new ResponseEntity<User>(user,HttpStatus.OK);
		}
		else{
			Error error=new Error(1,"unable to register user");
			System.out.println("error"+error);
			return new ResponseEntity<Error>(error,HttpStatus.INTERNAL_SERVER_ERROR);
		
		}
	}

	@RequestMapping(value="/logout",method=RequestMethod.PUT)
	public ResponseEntity<?> logout(HttpSession session)
	{
        String username=(String)session.getAttribute("userName");
		System.out.println("name of the logout user:-"+username);
		if(username==null)
		{
			Error error=new Error(5,"unauthorised access");
			return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
		}
		String userName="sakshi";
		User user=userService.getuser(userName);
		user.setOnline(false);
		userService.update(user);
		session.removeAttribute("userName");
		session.invalidate();
		return new ResponseEntity<String>("logout",HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(value="/getuser",method=RequestMethod.GET)
	public ResponseEntity<?> getuser(HttpSession session)
	{
		String userName=(String)session.getAttribute("userName");
		System.out.println("getuser userName"+userName);
		if(userName==null)
		{
			Error error=new Error(6,"unauthorised access");
			return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
		}
	
		User user=userService.getuser(userName);
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	@RequestMapping(value="/updateuser",method=RequestMethod.PUT)
	public ResponseEntity<?> updateuser(@RequestBody User user,HttpSession session)
	{
		String userName=(String)session.getAttribute("userName");
		System.out.println("update userName"+userName);
		if(userName==null)
		{
			Error error=new Error(6,"unauthorised access");
			return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
		}
		
		if(!userService.isupdatdemailvalid(user.getUserName(),user.getEmailId()))
		{
			Error error=new Error(3,"emailId already exists");
			return new ResponseEntity<Error>(error,HttpStatus.NOT_ACCEPTABLE);
		
		}
		try
		{
			userService.update(user);
			return new ResponseEntity<User>(user,HttpStatus.OK);
		}
		catch(Exception e)
		{
			Error error=new Error(1,"unable to update user");
			return new ResponseEntity<Error>(error,HttpStatus.INTERNAL_SERVER_ERROR);
		
		}
			
	}
	
}
