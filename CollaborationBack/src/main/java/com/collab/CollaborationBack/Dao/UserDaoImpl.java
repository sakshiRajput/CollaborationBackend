package com.collab.CollaborationBack.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.collab.CollaborationBack.model.Blog;
import com.collab.CollaborationBack.model.User;
@Transactional
@Repository("userDao")
public class UserDaoImpl implements UserDao {
   
	@Autowired
	private SessionFactory sessionFactory;

	public UserDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
		System.out.println("session created");
	}
	
	public boolean registeruser(User user) {
		try 
		{
			//System.out.println("RUN 3");
			user.setStatus("NA");
		sessionFactory.getCurrentSession().save(user);
		//System.out.println("RUN 4");
		System.out.println("user table is created");
		
		return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception is "+e);
			return false;
		}
	}

	public boolean isvalidemail(String emailId) {
		
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from User where emailId=?");
		query.setString(0, emailId);
		User user=(User)query.uniqueResult();
		if(user==null)
		    return true;
		else
			return false;
	}

	public boolean isvalidusername(String userName) {
		
		Session session=sessionFactory.getCurrentSession();
		//System.out.println("RUN 1");
		User user=(User)session.get(User.class, userName);
	//	System.out.println("RUN 2");
		if(user==null)
		    return true;
		else
			return false;

		
		
	}

	public User login(User user) {
		
		Session session=sessionFactory.getCurrentSession();
		System.out.println("LOGIN 1");
		Query query=session.createQuery("from User where userName=? and password=?");
        query.setString(0, user.getUserName());
		query.setString(1, user.getPassword());
		user=(User)query.uniqueResult();
		return user;
	}

	public void update(User user) {
	
		Session session = sessionFactory.getCurrentSession();
		session.update(user);
	}

	public User getuser(String userName) {
	
			Session session=sessionFactory.getCurrentSession();
			User user=(User)session.get(User.class, userName);
			return user;
			
			
	}

	public List<User> getallusers() {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from User ");
		List<User> userlist=query.list();
		return userlist;
	}

	public boolean isupdatdemailvalid(String username, String emailId) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from User where  userName!=? and emailId=? ");
		query.setParameter(0, username);
		query.setParameter(1, emailId);
		User user=(User)query.uniqueResult();
		if(user==null)
		    return true;
		else 
			return false;	
	}

	
	
	
	
}
