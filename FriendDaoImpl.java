package com.collab.CollaborationBack.Dao;

import java.util.List;


import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SQLQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
//import org.hibernate.query.Query;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import com.collab.CollaborationBack.model.Friend;
import com.collab.CollaborationBack.model.User;

@Transactional
@Repository(value="friendDao")
public class FriendDaoImpl implements FriendDao{
	
	@Autowired
	SessionFactory sessionFactory;
	
	public FriendDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
		System.out.println("friend session created");
	}
	
	@SuppressWarnings("deprecation")
	public List<User> listofsuggestedusers(String userName)
	{
		Session session=sessionFactory.getCurrentSession();
		SQLQuery query= session.createSQLQuery("select * from Usertable where userName in"
				+"(select userName from Usertable where userName!=? minus"
				+"(select fromId from Friend where toId=?"
				+" union select toId from Friend where fromId=?"
				+"))");
		query.setString(0,userName);
		query.setString(1,userName);
		query.setString(2,userName);
	    query.addEntity(User.class);
	    List<User> suggestedusers=query.list();
	    System.out.println("list:-"+suggestedusers);
	    return suggestedusers;
	}
	
	
	

	public void createfriend(Friend friend) {
		try 
		{
		sessionFactory.getCurrentSession().save(friend);
		
		
		}
		catch(Exception e)
		{
			System.out.println("Exception is "+e);
			
		}
	}
	
	public List<Friend> pendingrequest(String toId){
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Friend where toId=? and status='P'");
		query.setString(0, toId);
		return query.list();
	}
	
	
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

	public List<String> listoffriends(String userName) {
	
		Session session=sessionFactory.getCurrentSession();
		SQLQuery query1 = session.createSQLQuery("select fromId from Friend where toId=? and status='A'")
				.addScalar("fromId", StandardBasicTypes.STRING);
		query1.setString(0, userName);
		List<String> list = query1.list();
		System.out.println(list);
		Query query2 = session.createSQLQuery("select toId from Friend where fromId=? and status='A'")
				.addScalar("toId",StandardBasicTypes.STRING);
		query2.setString(0, userName);

		List<String> list1 = query2.list();
		System.out.println(list1);
		list1.addAll(list);
		return list1;
	}





	public void updatePendingRequest(Friend friend) {
		Session session = sessionFactory.getCurrentSession();
		if(friend.getStatus()=='A')
		{   session.update(friend);   }
		else
		session.delete(friend);
		
	}

}
