package com.collab.CollaborationBack.Dao;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.collab.CollaborationBack.model.ProfilePicture;
@Repository
@Transactional
public class ProfilePictureDaoImpl implements ProfilePictureDao {

	
	@Autowired
	SessionFactory sessionfactory;
	
	public void uploadpic(ProfilePicture profilepic) {
		try{
		Session session=sessionfactory.getCurrentSession();
		System.out.println("saving profile pic");
		session.saveOrUpdate(profilepic);
		}
		catch(Exception e)
		{
			System.out.println("Exception is "+e);
			System.out.println("error in saving ");
		}
	}

	public ProfilePicture getProfilePic(String username) {
		Session session=sessionfactory.getCurrentSession();
		Query query = session.createQuery("from ProfilePicture where userName = ?");
		query.setParameter(0, username);
		System.out.println("get image of - "+username);
		ProfilePicture profilePicture=(ProfilePicture)query.setMaxResults(1).uniqueResult();
//		ProfilePicture profilePicture=(ProfilePicture)query.uniqueResult();
	//	System.out.println("profilepicture filename-"+profilePicture.getFileName());
		return profilePicture;
	}

}
