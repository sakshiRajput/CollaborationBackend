package com.collab.CollaborationBack.Dao;

import java.util.List;

import com.collab.CollaborationBack.model.User;

public interface UserDao {
	
	public boolean addUser(User user);
	public boolean updateUser(User user);
	public boolean deleteUser(int userId);
	List<User> getUser();
	User getUserById(int userId);

}
