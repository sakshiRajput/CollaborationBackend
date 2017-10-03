package com.collab.CollaborationBack.Service;

import java.util.List;

import com.collab.CollaborationBack.model.Blog;

public interface BlogService {

	public boolean createBlog(Blog blog);
	public boolean editBlog(Blog blog);
	public boolean deleteBlog(Integer blogId);
	public Blog getBlog(Integer blogId);
	public List<Blog> getAllBlogs();
	public boolean approveBlog(Blog blog);
	
}
