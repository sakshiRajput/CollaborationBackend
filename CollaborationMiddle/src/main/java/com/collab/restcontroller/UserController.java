package com.collab.restcontroller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.collab.CollaborationBack.Dao.UserDao;
import com.collab.CollaborationBack.model.User;

@RestController
public class UserController {
	
	@Autowired
	UserDao userDao;
	
	@GetMapping(value="/getallusers")
	public ResponseEntity<ArrayList<User>> getallusers()
	{
		ArrayList<User> listusers=new ArrayList<User>();
		listusers=(ArrayList<User>)userDao.getUser();
		return new ResponseEntity<ArrayList<User>>(listusers,HttpStatus.OK);
		
	}
	
	@PostMapping(value="/adduser")
	public ResponseEntity <String> createuser(@RequestBody User user)
	{
	
		user.setRole("User");
		user.setStatus("NA");
		
		if(userDao.addUser(user))
		{  return new ResponseEntity <String> ("user added",HttpStatus.OK);}
		else
		{ return new ResponseEntity <String> ("problem in adding",HttpStatus.NOT_ACCEPTABLE);}
	
	}


	@DeleteMapping("/deleteuser/{userId}")
	public ResponseEntity<String> deleteBlog (@PathVariable("userId")Integer userId)
	{
		if(userDao.deleteUser(userId))
		{return new ResponseEntity<String> ("user Deleted",HttpStatus.OK);}
		 else
		 {return new ResponseEntity <String> ("problem in deleting",HttpStatus.NOT_ACCEPTABLE); }
		

	}
	
	@PutMapping(value="/edituser/{userId}")
	public ResponseEntity<String> editBlog (@PathVariable("userId")Integer userId,@RequestBody User user)
	{
		User newuser=userDao.getUserById(userId);
	
		newuser.setEmailId(user.getEmailId());
		newuser.setFirstName(user.getFirstName());
		newuser.setLastName(user.getLastName());
		newuser.setPassword(user.getPassword());
		
		if(userDao.updateUser(newuser))
		 {return new ResponseEntity <String> ("user updates",HttpStatus.OK);}
		 else
		 {return new ResponseEntity <String> ("problem in updating",HttpStatus.NOT_ACCEPTABLE); }
	}
	
	@GetMapping("/getuser/{Id}")
	public ResponseEntity<User> getforumcomment(@PathVariable("Id")Integer userId)
		{
		    User listusers=(User)userDao.getUserById(userId);
			return new ResponseEntity<User>(listusers,HttpStatus.OK);
			
	}
}
