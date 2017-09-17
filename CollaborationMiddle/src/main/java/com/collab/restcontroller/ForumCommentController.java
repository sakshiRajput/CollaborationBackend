package com.collab.restcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.collab.CollaborationBack.Dao.ForumCommentDao;
import com.collab.CollaborationBack.model.ForumComment;

@RestController
public class ForumCommentController {


	@Autowired
	ForumCommentDao forumcommentDao;
	

	@PostMapping(value="/createforumcomment")
	public ResponseEntity <String> createblogcomment(@RequestBody ForumComment forumcomment)
	{
		forumcomment.setCommentDate(new java.util.Date());
		
		
		if(forumcommentDao.createforumcomment(forumcomment))
		{  return new ResponseEntity <String> ("forumcomment created",HttpStatus.OK);}
		else
		{ return new ResponseEntity <String> ("problem in creating",HttpStatus.NOT_ACCEPTABLE);}
	
	}
	
	@DeleteMapping("/deleteforumcomment/{Id}")
	public ResponseEntity<String> deleteforumcomment (@PathVariable("Id")Integer forumcommentId)
	{
		if(forumcommentDao.deleteforumcomment(forumcommentId))
		{return new ResponseEntity<String> ("forumcomment Deleted",HttpStatus.OK);}
		 else
		 {return new ResponseEntity <String> ("problem in deleting",HttpStatus.NOT_ACCEPTABLE); }
		

	}

	@GetMapping("/getforumcomment/{forumcommentId}")
	public ResponseEntity<ForumComment> getforumcomment(@PathVariable("forumcommentId")Integer forumcommentId)
		{
			ForumComment listforums=(ForumComment)forumcommentDao.getforumcomment(forumcommentId);
			return new ResponseEntity<ForumComment>(listforums,HttpStatus.OK);
			
	}
	
	@GetMapping(value="/getallforumcomments")
	public ResponseEntity<ArrayList<ForumComment>> getallforumcomments()
	{
		ArrayList<ForumComment> listforums=new ArrayList<ForumComment>();
		listforums=(ArrayList<ForumComment>)forumcommentDao.getAllforumcomments();
		return new ResponseEntity<ArrayList<ForumComment>>(listforums,HttpStatus.OK);
		
	}
	
	@PutMapping(value="/editforumcomment/{forumcommentId}")
	public ResponseEntity<String> editforumcomment (@PathVariable("forumcommentId")Integer forumcommentId,@RequestBody ForumComment forumcomment)
	{
		//ForumComment forumcomment=new ForumComment();
		
		forumcomment.setForumComment(forumcomment.getForumComment());
	
		if(forumcommentDao.editforumcomment(forumcomment))
		 {return new ResponseEntity <String> ("forumcomment edited",HttpStatus.OK);}
		 else
		 {return new ResponseEntity <String> ("problem in editing",HttpStatus.NOT_ACCEPTABLE); }
	}
	
}
