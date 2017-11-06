package com.collab.CollaborationBack.Service;

import java.util.List;

import com.collab.CollaborationBack.model.Friend;
import com.collab.CollaborationBack.model.User;

public interface FriendService {
	 List<User> listofsuggestedusers(String userName);
	 void createfriend(Friend friend);
	 List<Friend> pendingrequest(String toId);
	 List<String> listOfFriends(String userName);
	void updatePendingRequests(Friend friend);
	
	
}
