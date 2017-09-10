package com.collab.CollaborationBack.Dao;

import java.util.List;

import com.collab.CollaborationBack.model.ForumComment;

public interface ForumCommentDao {

	public boolean createforumcomment(ForumComment forumcomment);
	public boolean editforumcomment(ForumComment forumcomment);
	public boolean deleteforumcomment(int forumcommentId);
	public ForumComment getforumcomment(int forumcommentId);
	public List<ForumComment> getAllforumcomments();
	
}
