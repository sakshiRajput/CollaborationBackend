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

import com.collab.CollaborationBack.Dao.BlogcommentDao;
import com.collab.CollaborationBack.model.BlogComment;

@RestController
public class BlogCommentController {

	@Autowired
	BlogcommentDao blogcommentDao;
	
	

	@PostMapping(value="/createblogcomment")
	public ResponseEntity <String> createblogcomment(@RequestBody BlogComment blogcomment)
	{
		blogcomment.setCommentDate(new java.util.Date());
		
		
		if(blogcommentDao.createBlogcomment(blogcomment))
		{  return new ResponseEntity <String> ("Blogcomment created",HttpStatus.OK);}
		else
		{ return new ResponseEntity <String> ("problem in creating",HttpStatus.NOT_ACCEPTABLE);}
	
	}
	
	
	
	@DeleteMapping("/deleteBlogcomment/{blogcommentId}")
	public ResponseEntity<String> deleteBlogcomment (@PathVariable("blogcommentId")Integer blogcommentId)
	{
		if(blogcommentDao.deleteBlogcomment(blogcommentId))
		{return new ResponseEntity<String> ("Blogcomment Deleted",HttpStatus.OK);}
		 else
		 {return new ResponseEntity <String> ("problem in deleting",HttpStatus.NOT_ACCEPTABLE); }
		

	}
	@GetMapping(value="/getallblogcomments")
	public ResponseEntity<ArrayList<BlogComment>> getallblogcomments()
	{
		ArrayList<BlogComment> listblogs=new ArrayList<BlogComment>();
		listblogs=(ArrayList<BlogComment>)blogcommentDao.getAllBlogcomments();
		return new ResponseEntity<ArrayList<BlogComment>>(listblogs,HttpStatus.OK);
		
	}
	
	@PutMapping(value="/editBlogcomment/{Id}")
	public ResponseEntity<String> editBlog (@PathVariable("Id")Integer blogcommentId,@RequestBody BlogComment blogcomment)
	{
		BlogComment newblogcomment=blogcommentDao.getBlogcomment(blogcommentId);
		newblogcomment.setBlogComment(blogcomment.getBlogComment());
		newblogcomment.setCommentDate(new java.util.Date());
		newblogcomment.setUserName(blogcomment.getUserName());
		if(blogcommentDao.editBlogcomment(newblogcomment))
		 {return new ResponseEntity <String> ("blogcomment edited",HttpStatus.OK);}
		 else
		 {return new ResponseEntity <String> ("problem in editing",HttpStatus.NOT_ACCEPTABLE); }
	}
	
}
