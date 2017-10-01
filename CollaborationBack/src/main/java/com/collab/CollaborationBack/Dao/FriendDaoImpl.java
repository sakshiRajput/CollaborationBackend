package com.collab.CollaborationBack.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.collab.CollaborationBack.model.Friend;
@Repository("friendDao")
public class FriendDaoImpl implements FriendDao{
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public boolean createfriend(Friend friend) {
		try 
		{
		sessionFactory.getCurrentSession().save(friend);
		return true;
		
		}
		catch(Exception e)
		{
			System.out.println("Exception is "+e);
			return false;
		}
	}
	@Transactional
	public boolean editfriend(Friend friend) {
		try{
			sessionFactory.getCurrentSession().update(friend);
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
	public boolean deletefriend(int friendId) {
		try{
			Session session= sessionFactory.getCurrentSession();
			Friend friend=(Friend)session.load(Friend.class, friendId);
			session.delete(friend);
			return true;
			}
			catch(Exception e)
			{
				System.out.println("Exception is "+e);
				return false;
			}
	}
	@Transactional
	public Friend getfriend(int friendId) {
		try{
			Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery("from Friend where friendId="+friendId);
			Friend friendlist=(Friend)query.getSingleResult();
			return friendlist;
			}
			catch(Exception e)
			{
				System.out.println("Exception is "+e);
				return null;
			}
	}
	@Transactional
	public List<Friend> getAllfriends() {
		try{
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("from Friend");
			List<Friend> friendlist=query.list();
			return friendlist;
		}
		catch(Exception e)
		{
			System.out.println("Exception is "+e);
			return null;
		}
	}

}
