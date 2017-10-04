package com.collab.CollaborationBack.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collab.CollaborationBack.Dao.UserDao;
import com.collab.CollaborationBack.model.User;
@Service
public class userServiceImpl implements UserService{

	
	@Autowired
	public UserDao userDao;
	
	public boolean registeruser(User user) {
		
		return userDao.registeruser(user);
	}

	public boolean isvalidemail(String emailId) {
		
		return userDao.isvalidemail(emailId);
	}

	public boolean isvalidusername(String userName) {
	
		return userDao.isvalidusername(userName);
	}

	public User login(User user) {
		
		return userDao.login(user);
	}

	public void update(User user) {
		
	      userDao.update(user);
		
	}

	public User getuser(String username) {
		
		return userDao.getuser(username);
	}

	public List<User> getallusers() {
		
		return userDao.getallusers();
	}

	public boolean isupdatdemailvalid(String username, String emailId) {
		
		return userDao.isupdatdemailvalid(username, emailId);
	}

}
