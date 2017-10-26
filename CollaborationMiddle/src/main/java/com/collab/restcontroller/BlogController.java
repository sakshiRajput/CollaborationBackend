package com.collab.restcontroller;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
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

import com.collab.CollaborationBack.Dao.BlogDao;
import com.collab.CollaborationBack.Service.BlogService;
import com.collab.CollaborationBack.Service.UserService;
import com.collab.CollaborationBack.model.Blog;
import com.collab.CollaborationBack.model.Error;
import com.collab.CollaborationBack.model.User;

@RestController
public class BlogController {
	
	
	
	@Autowired
	private UserService userService;

	@Autowired
	private BlogService blogService;
	
	@Autowired
	 HttpSession session;
	
	
	@GetMapping(value="/getallblogs")
	public ResponseEntity<ArrayList<Blog>> getallblogs()
	{
		ArrayList<Blog> listblogs=new ArrayList<Blog>();
		listblogs=(ArrayList<Blog>)blogService.getAllBlogs();
		return new ResponseEntity<ArrayList<Blog>>(listblogs,HttpStatus.OK);
		
	}
	@GetMapping(value="/getblogs/{status}")
	public ResponseEntity<?> getBlogs(@PathVariable String status,HttpSession session)
	{
		String username=(String)session.getAttribute("userName");
		if(username==null)
		{
			Error error=new Error(6,"unauthorised access");
			return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
		}
		
     	List<Blog> blog=blogService.getBlogs(status);
     	return new ResponseEntity<List<Blog>>(blog,HttpStatus.OK);
	
	}
	@PostMapping(value="/createblog")
	public ResponseEntity <?> createblog(@RequestBody Blog blog)
	{
 
		String userName=(String) session.getAttribute("userName");
	    System.out.println("user:-"+userName);
		if(userName==null)
		{
			Error error=new Error(6,"unauthorised access");
			return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
		}
     
		blog.setCreateDate(new java.util.Date());
		User postedby=userService.getuser(userName);
	    blog.setPostedBy(postedby);
		try
		{ blogService.createBlog(blog);
		  return new ResponseEntity<Blog>(blog,HttpStatus.OK); 
		}
		catch(Exception e)
		{  Error error=new Error(9,"unable to add blog");
		   return new ResponseEntity<Error>(error,HttpStatus.INTERNAL_SERVER_ERROR);
		   }
	
	}
	@GetMapping(value="/getblogbyid/{id}")
	public ResponseEntity<?> grtBlogById(@PathVariable int id,HttpSession session)
	{
		String userName=(String) session.getAttribute("userName");
	    if(userName==null)
		{
			Error error=new Error(6,"unauthorised access");
			return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
		}
	    Blog blog=blogService.getBlogById(id);
	    return new ResponseEntity<Blog>(blog,HttpStatus.OK);
		
	}
	@PutMapping(value="/approveblog/{blogId}")
	public ResponseEntity <String> approveblog(@PathVariable("blogId") int blogId)
	{   Blog blog=blogService.getBlogById(blogId);
		if(blogService.approveBlog(blog))
		{
		return new ResponseEntity <String> ("blog approved",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity <String> ("problem in approved",HttpStatus.NOT_ACCEPTABLE);
		}
		
	}

	@DeleteMapping("/deleteBlog/{blogId}")
	public ResponseEntity<String> deleteBlog (@PathVariable("blogId")Integer blogId)
	{
		if(blogService.deleteBlog(blogId))
		{return new ResponseEntity<String> ("Blog Deleted",HttpStatus.OK);}
		 else
		 {return new ResponseEntity <String> ("problem in deleting",HttpStatus.NOT_ACCEPTABLE); }
		

	}
	@PutMapping(value="/update")
	public ResponseEntity<?> editBlog (@RequestBody Blog blog)
	{  String userName=(String) session.getAttribute("userName");
       System.out.println("user:-"+userName);
    	if(userName==null)
	    {
		Error error=new Error(6,"unauthorised access");
		return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
	    }
    	if(blog.getStatus()=="NA" && blog.getRejection_reason()==null)
    	{ blog.setRejection_reason("Not Mentioned");  }
	    blogService.editBlog(blog);
	    return new ResponseEntity <Blog> (blog,HttpStatus.OK); 
	}
	
	
	
	
	

	
}
