package com.collab.CollaborationBack.Dao;

import java.util.List;

import com.collab.CollaborationBack.model.Friend;

public interface FriendDao {

	
	
	public boolean createfriend(Friend friend);
	public boolean editfriend(Friend friend);
	public boolean deletefriend(int friendId);
	public Friend getfriend(int friendId);
	public List<Friend> getAllfriends();
}
