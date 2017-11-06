package com.collab.CollaborationBack.Dao;

import java.util.List;

import com.collab.CollaborationBack.model.Friend;
import com.collab.CollaborationBack.model.User;

public interface FriendDao {

	
	 List<User> listofsuggestedusers(String userName);
	 void createfriend(Friend friend);
	 List<Friend> pendingrequest(String toId);
	 void updatePendingRequest(Friend friend);
	
	 boolean deletefriend(int friendId);
	

	 List<String> listoffriends(String userName);
	
}
