package com.collab.CollaborationBack.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collab.CollaborationBack.Dao.FriendDao;
import com.collab.CollaborationBack.model.Friend;
import com.collab.CollaborationBack.model.User;

@Service("friendService")
public class FriendServiceImpl implements FriendService {

	@Autowired
	FriendDao friendDao;
	public List<User> listofsuggestedusers(String userName) {
		
		return friendDao.listofsuggestedusers(userName);
	}

	public void createfriend(Friend friend) {
		friendDao.createfriend(friend);
		
	}

	public List<Friend> pendingrequest(String toId) {
		
		return friendDao.pendingrequest(toId);
	}

	public List<String> listOfFriends(String userName) {
		
		return friendDao.listoffriends(userName);
	}

	public void updatePendingRequests(Friend friend) {
		
		friendDao.updatePendingRequest(friend);
	}

}
