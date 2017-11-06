package com.collab.CollaborationBack.Dao;

import com.collab.CollaborationBack.model.ProfilePicture;

public interface ProfilePictureDao {

	void uploadpic(ProfilePicture profilepic);
	ProfilePicture getProfilePic(String username);
}
