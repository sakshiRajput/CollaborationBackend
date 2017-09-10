package com.collab.CollaborationBack.Dao;

import java.util.List;

import com.collab.CollaborationBack.model.Forum;

public interface ForumDao {

	public boolean createForum(Forum forum);
	public boolean editForum(Forum forum);
	public boolean deleteForum(int forumId);
	public Forum getForum(int forumId);
	public List<Forum> getAllForums();
	
	
}
