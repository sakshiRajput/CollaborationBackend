package com.collab.CollaborationBack.Dao;

import java.util.List;

import com.collab.CollaborationBack.model.BlogComment;

public interface BlogcommentDao {


	public boolean createBlogcomment(BlogComment blogcomment);
	public boolean editBlogcomment(BlogComment blogcomment);
	public boolean deleteBlogcomment(int blogcommentId);
	public BlogComment getBlogcomment(int blogcommentId);
	public List<BlogComment> getBlogcomments(int blogId);
	
	
}
