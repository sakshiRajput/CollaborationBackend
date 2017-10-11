package com.collab.CollaborationBack.Service;

import java.util.List;

import com.collab.CollaborationBack.model.BlogComment;

public interface BlogCommentService {

	public boolean createBlogcomment(BlogComment blogcomment);
	public List<BlogComment> getBlogcomments(int blogId);
}
