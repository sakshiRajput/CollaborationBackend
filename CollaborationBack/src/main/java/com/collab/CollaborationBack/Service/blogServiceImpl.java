package com.collab.CollaborationBack.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collab.CollaborationBack.Dao.BlogDao;
import com.collab.CollaborationBack.model.Blog;

@Service
public class blogServiceImpl implements BlogService{

	@Autowired
	public BlogDao blogDao;
	
	public boolean createBlog(Blog blog) {
	
		return blogDao.createBlog(blog);
	}

	public boolean editBlog(Blog blog) {
	
		return blogDao.editBlog(blog);
	}

	public boolean deleteBlog(Integer blogId) {
		
		return blogDao.deleteBlog(blogId);
	}

	public Blog getBlogById(Integer blogId) {
		
		return blogDao.getBlogById(blogId);
	}

	public List<Blog> getAllBlogs() {
		
		return blogDao.getAllBlogs();
	}

	public boolean approveBlog(Blog blog) {
		
		return blogDao.approveBlog(blog);
	}
	public List<Blog> getBlogs(String status )
	{
		return blogDao.getBlogs(status);
	}

}
