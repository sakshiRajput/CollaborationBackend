package com.collab.restcontroller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.collab.CollaborationBack.Dao.FriendDao;
import com.collab.CollaborationBack.Service.FriendService;
import com.collab.CollaborationBack.model.User;
import com.collab.CollaborationBack.model.Friend;
import com.collab.CollaborationBack.model.Error;

@RestController
public class FriendController {
	
	
	@Autowired
    private FriendService friendService;
	
  
	@GetMapping(value="/getsuggestedusers")
	public ResponseEntity<?> getsuggestedUsers(HttpSession session){
	String userName = (String)session.getAttribute("userName");
	if(userName==null)
	{
		Error error = new Error(5,"Unauthorized Access");
		return new ResponseEntity<Error>(error,HttpStatus.NOT_ACCEPTABLE);
	}
		
	  //  String userName="sakshi";
		List<User> suggestedusers=friendService.listofsuggestedusers(userName);
		return new  ResponseEntity<List<User>>(suggestedusers,HttpStatus.OK) ;
		
	}
	@GetMapping(value="/pendingRequests")
	public ResponseEntity<?> pendingRequests(HttpSession session)
	{
		String userName = (String)session.getAttribute("userName");
		if(userName==null)
		{
			Error error = new Error(5,"Unauthorized Access");
			return new ResponseEntity<Error>(error,HttpStatus.NOT_ACCEPTABLE);
		}
	
		List<Friend> pendingRequest=friendService.pendingrequest(userName);
		return new ResponseEntity<List<Friend>>(pendingRequest,HttpStatus.OK);
	}
	
	@GetMapping(value="/friendRequest/{toId}")
	public ResponseEntity<?> friendRequest(@PathVariable String toId,HttpSession session) 
	{
		String userName = (String)session.getAttribute("userName");
		if(userName==null)
		{
			Error error = new Error(5,"Unauthorized Access");
			return new ResponseEntity<Error>(error,HttpStatus.NOT_ACCEPTABLE);
		}
		Friend friend = new Friend();
		friend.setFromId(userName);;
		friend.setToId(toId);;
		friend.setStatus('P');
		friendService.createfriend(friend);;
		return new ResponseEntity<Friend>(friend,HttpStatus.OK);
	}
	@PutMapping(value="/updatePendingRequests")
	public ResponseEntity<?> updatePendingRequests(@RequestBody Friend friend,HttpSession session)
	{
		String userName = (String)session.getAttribute("userName");
		if(userName==null)
		{
			Error error = new Error(5,"Unauthorized Access");
			return new ResponseEntity<Error>(error,HttpStatus.NOT_ACCEPTABLE);
		}
	
		friendService.updatePendingRequests(friend);
		return new ResponseEntity<Friend>(friend,HttpStatus.OK);
	}
	@GetMapping(value="/listOfFriends")
	public ResponseEntity<?> listOfFriends(HttpSession session) 
	{
		String userName = (String)session.getAttribute("userName");
		if(userName==null)
		{
			Error error = new Error(5,"Unauthorized Access");
			return new ResponseEntity<Error>(error,HttpStatus.NOT_ACCEPTABLE);
		}
		List<String> list = friendService.listOfFriends(userName);
		return new ResponseEntity<List<String>>(list,HttpStatus.OK);
	}
}
