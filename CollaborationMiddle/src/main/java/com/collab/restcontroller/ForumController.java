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

import com.collab.CollaborationBack.Dao.ForumDao;
import com.collab.CollaborationBack.model.Forum;

@RestController
public class ForumController {
	
	@Autowired
	ForumDao forumDao;
	
	@PostMapping(value="/createforum")
	public ResponseEntity <String> createforum(@RequestBody Forum forum)
	{
		forum.setCreateDate(new java.util.Date());
		forum.setStatus("NA");
		
		if(forumDao.createForum(forum))
		{  return new ResponseEntity <String> ("forum created",HttpStatus.OK);}
		else
		{ return new ResponseEntity <String> ("problem in creating",HttpStatus.NOT_ACCEPTABLE);}
	
	}
	
	@GetMapping(value="/getallforums")
	public ResponseEntity<ArrayList<Forum>> getallforums()
	{
		ArrayList<Forum> listforums=new ArrayList<Forum>();
		listforums=(ArrayList<Forum>)forumDao.getAllForums();
		return new ResponseEntity<ArrayList<Forum>>(listforums,HttpStatus.OK);
		
	}
	@PutMapping(value="/approveforum/{Id}")
	public ResponseEntity <String> approveblog(@PathVariable("Id") int forumId)
	{   Forum forum=forumDao.getForum(forumId);
		if(forumDao.approveforum(forum))
		{
		return new ResponseEntity <String> ("forum approved",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity <String> ("problem in approving",HttpStatus.NOT_ACCEPTABLE);
		}
		
	}
	@DeleteMapping("/deleteforum/{Id}")
	public ResponseEntity<String> deleteforum (@PathVariable("Id")Integer forumId)
	{
		if(forumDao.deleteForum(forumId))
		{return new ResponseEntity<String> ("Forum Deleted",HttpStatus.OK);}
		 else
		 {return new ResponseEntity <String> ("problem in deleting",HttpStatus.NOT_ACCEPTABLE); }
		

	}

}
