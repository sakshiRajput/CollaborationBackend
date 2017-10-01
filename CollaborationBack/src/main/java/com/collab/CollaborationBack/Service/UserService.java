package com.collab.CollaborationBack.Service;


import com.collab.CollaborationBack.model.User;

public interface UserService {
	
boolean registeruser(User user);
boolean isvalidemail(String emailId);
boolean isvalidusername(String username);
User login(User user);
void update(User user);
	
	
}
