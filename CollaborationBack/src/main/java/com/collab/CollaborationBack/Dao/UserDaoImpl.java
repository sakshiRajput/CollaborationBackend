package com.collab.CollaborationBack.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.collab.CollaborationBack.model.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
   
	@Autowired
	SessionFactory sessionFactory;

	public UserDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
		System.out.println("session created");
	}
	@Transactional
	public boolean addUser(User user) {
		try 
		{
		sessionFactory.getCurrentSession().saveOrUpdate(user);
		System.out.println("user table is created");
		return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception is "+e);
			return false;
		}
	}
	@Transactional
	public boolean updateUser(User user) {

		try{
		sessionFactory.getCurrentSession().update(user);
		System.out.println("table is updated");
		return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception is "+e);
			return false;
		}
		
	}
	@Transactional
	public boolean deleteUser(int userId) {
		try{
			Session session= sessionFactory.getCurrentSession();
			User user=(User)session.load(User.class, userId);
			session.delete(user);
			return true;
			}
			catch(Exception e)
			{
				System.out.println("Exception is "+e);
				return false;
			}
	}
	@Transactional
	public List<User> getUser() {
		try{
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("from User ");
			List<User> listuser=query.list();
			return listuser;
			}
			catch(Exception e)
			{
				System.out.println("Exception is "+e);
				return null;
			}
	}
	@Transactional
	public User getUserById(int userId) {
		try{
			Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery("from User where userId"+userId);
			query.setParameter(0, userId);
			User userlist=(User)query.getSingleResult();
			return userlist;
			}
			catch(Exception e)
			{
				System.out.println("Exception is "+e);
				return null;
			}
	}

}
