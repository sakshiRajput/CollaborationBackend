package com.collab.CollaborationBack.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.collab.CollaborationBack.model.Forum;

@Repository("forumDao")
public class ForumDaoImpl implements ForumDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public ForumDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
		System.out.println("session created");
	}
	
	@Transactional
	public boolean createForum(Forum forum) {
		try 
		{
		sessionFactory.getCurrentSession().saveOrUpdate(forum);
		return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception is "+e);
			return false;
		}
		
	}
	@Transactional
	public boolean editForum(Forum forum) {
		try{
			sessionFactory.getCurrentSession().update(forum);
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
	public boolean deleteForum(int forumId) {
		try{
			Session session= sessionFactory.getCurrentSession();
			Forum forum=(Forum)session.load(Forum.class, forumId);
			session.delete(forum);
			return true;
			}
			catch(Exception e)
			{
				System.out.println("Exception is "+e);
				return false;
			}
	}
	@Transactional
	public Forum getForum(int forumId) {
		try{
			Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery("from Forum where forumId=?");
			query.setParameter(0, forumId);
			Forum forumlist=(Forum)query.getSingleResult();
			return forumlist;
			}
			catch(Exception e)
			{
				System.out.println("Exception is "+e);
				return null;
			}
	}
	@Transactional
	public List<Forum> getAllForums() {
		try{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Forum");
		List<Forum> listforum=query.list();
		return listforum;
		}
		catch(Exception e)
		{
			System.out.println("Exception is "+e);
			return null;
		}
	}

}
