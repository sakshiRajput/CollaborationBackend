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
import org.springframework.web.bind.annotation.RestController;

import com.collab.CollaborationBack.Dao.BlogDao;
import com.collab.CollaborationBack.model.Blog;
@RestController
public class BlogController {
	
	@Autowired
	BlogDao blogDao;
	
	
	@GetMapping(value="/getallblogs")
	public ResponseEntity<ArrayList<Blog>> getallblogs()
	{
		ArrayList<Blog> listblogs=new ArrayList<Blog>();
		listblogs=(ArrayList<Blog>)blogDao.getAllBlogs();
		return new ResponseEntity<ArrayList<Blog>>(listblogs,HttpStatus.OK);
		
	}
	
	@PostMapping(value="/createblog")
	public ResponseEntity <String> createblog(@RequestBody Blog blog)
	{
		blog.setCreateDate(new java.util.Date());
		blog.setStatus("NA");
		blog.setLikes(0);
		
		if(blogDao.createBlog(blog))
		{  return new ResponseEntity <String> ("Blog created",HttpStatus.OK);}
		else
		{ return new ResponseEntity <String> ("problem in creating",HttpStatus.NOT_ACCEPTABLE);}
	
	}
	@PutMapping(value="/approveblog/{blogId}")
	public ResponseEntity <String> approveblog(@PathVariable("blogId") int blogId)
	{   Blog blog=blogDao.getBlog(blogId);
		if(blogDao.approveBlog(blog))
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
		if(blogDao.deleteBlog(blogId))
		{return new ResponseEntity<String> ("Blog Deleted",HttpStatus.OK);}
		 else
		 {return new ResponseEntity <String> ("problem in deleting",HttpStatus.NOT_ACCEPTABLE); }
		

	}
	@PutMapping(value="/editBlog/{blogId}")
	public ResponseEntity<String> editBlog (@PathVariable("blogId")Integer blogId,@RequestBody Blog blog)
	{
		Blog editedblog=blogDao.getBlog(blogId);
		editedblog.setBlogName(blog.getBlogName());
		editedblog.setBlogContent(blog.getBlogContent());
		editedblog.setCreateDate(new java.util.Date()); 
		if(blogDao.editBlog(editedblog))
		 {return new ResponseEntity <String> ("blog edited",HttpStatus.OK);}
		 else
		 {return new ResponseEntity <String> ("problem in editing",HttpStatus.NOT_ACCEPTABLE); }
	}
	
	
	
	@GetMapping(value="/test")
	public ResponseEntity <String> testmethod()
	{
		return new ResponseEntity <String> ("Test controller",HttpStatus.OK);
		
	}

}
