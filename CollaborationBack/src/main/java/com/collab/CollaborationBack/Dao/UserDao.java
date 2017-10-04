package com.collab.CollaborationBack.Dao;

import java.util.List;


import com.collab.CollaborationBack.model.User;

public interface UserDao {
	
	boolean registeruser(User user);
	boolean isvalidemail(String emailId);
	boolean isvalidusername(String username);
	User login(User user);
	void update(User user);
	public User getuser(String username);
	public List<User> getallusers();
	public boolean isupdatdemailvalid(String username,String emailId);
}
