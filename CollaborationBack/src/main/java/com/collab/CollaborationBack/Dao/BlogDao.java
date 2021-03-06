package com.collab.CollaborationBack.Dao;

import java.util.List;

import com.collab.CollaborationBack.model.Blog;

public interface BlogDao {

	
	public boolean createBlog(Blog blog);
	public boolean editBlog(Blog blog);
	public boolean deleteBlog(Integer blogId);
	public Blog getBlogById(Integer blogId);
	public List<Blog> getAllBlogs();
	public boolean approveBlog(Blog blog);
	public List<Blog> getBlogs(String status);
}
