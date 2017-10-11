package com.collab.restcontroller;



import java.util.List;
import java.util.Date;

import javax.servlet.http.HttpSession;

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
import com.collab.CollaborationBack.Service.UserService;
import com.collab.CollaborationBack.model.BlogComment;
import com.collab.CollaborationBack.model.Error;
import com.collab.CollaborationBack.model.User;

@RestController
public class BlogCommentController {

	@Autowired
	BlogcommentDao blogcommentDao;
	

	@Autowired
	private UserService userService;

	@PostMapping(value="/addcomment")
	public ResponseEntity <?> createblogcomment(@RequestBody BlogComment blogComment,HttpSession session)
	{
		 String userName=(String) session.getAttribute("userName");
	   	if(userName==null)
		    {
			Error error=new Error(6,"unauthorised access");
			return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
		    }
	   	User user=userService.getuser(userName);
	   	blogComment.setCommentedBy(user);
		blogComment.setCommentDate(new Date());
		try
		{ blogcommentDao.createBlogcomment(blogComment);
		   return new ResponseEntity<BlogComment>(blogComment,HttpStatus.OK);
		}
		catch(Exception e)
		{ Error error=new Error(7,"unable to post");
		  return new ResponseEntity <Error> (error,HttpStatus.NOT_ACCEPTABLE);
		}
	
	}
	
	
	
	@DeleteMapping("/deleteBlogcomment/{blogcommentId}")
	public ResponseEntity<String> deleteBlogcomment (@PathVariable("blogcommentId")Integer blogcommentId)
	{
		if(blogcommentDao.deleteBlogcomment(blogcommentId))
		{return new ResponseEntity<String> ("Blogcomment Deleted",HttpStatus.OK);}
		 else
		 {return new ResponseEntity <String> ("problem in deleting",HttpStatus.NOT_ACCEPTABLE); }
		

	}
	@GetMapping(value="/getcomments/{blogId}")
	public ResponseEntity<?> getcomments(@PathVariable("blogId")Integer blogId,HttpSession session)
	{    String userName=(String) session.getAttribute("userName");
        	if(userName==null)
        	{
        		Error error=new Error(6,"unauthorised access");
        		return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
        	}
		List<BlogComment> blogcomments=blogcommentDao.getBlogcomments(blogId);
		return new ResponseEntity<List<BlogComment>>(blogcomments,HttpStatus.OK);
		
	}
	
	@PutMapping(value="/editBlogcomment/{Id}")
	public ResponseEntity<String> editBlog (@PathVariable("Id")Integer blogcommentId,@RequestBody BlogComment blogcomment)
	{
		BlogComment newblogcomment=blogcommentDao.getBlogcomment(blogcommentId);
		newblogcomment.setBlogComment(blogcomment.getBlogComment());
		newblogcomment.setCommentDate(new java.util.Date());
		//newblogcomment.setUserName(blogcomment.getUserName());
		if(blogcommentDao.editBlogcomment(newblogcomment))
		 {return new ResponseEntity <String> ("blogcomment edited",HttpStatus.OK);}
		 else
		 {return new ResponseEntity <String> ("problem in editing",HttpStatus.NOT_ACCEPTABLE); }
	}
	
}
