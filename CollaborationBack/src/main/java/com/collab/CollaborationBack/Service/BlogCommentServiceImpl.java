package com.collab.CollaborationBack.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.collab.CollaborationBack.Dao.BlogcommentDao;
import com.collab.CollaborationBack.model.BlogComment;

public class BlogCommentServiceImpl implements BlogCommentService {
	@Autowired 
	BlogcommentDao blogcommentDao;

	public boolean createBlogcomment(BlogComment blogcomment) {


		return blogcommentDao.createBlogcomment(blogcomment);
	}

	public List<BlogComment> getBlogcomments(int blogId) {
		
		return blogcommentDao.getBlogcomments(blogId);
	}
	

}
