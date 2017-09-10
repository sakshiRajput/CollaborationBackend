package com.collab.CollaborationBack.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.collab.CollaborationBack.model.ForumComment;

@Repository("forumcommentDao")
public class ForumCommentDaoImpl implements ForumCommentDao {

	@Autowired
	SessionFactory sessionFactory;
	
	
	
	@Transactional
	public boolean createforumcomment(ForumComment forumcomment) {
		try 
		{
		sessionFactory.getCurrentSession().save(forumcomment);
		System.out.println("forumcomment is created");
		return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception is "+e);
			return false;
		}
	}
	@Transactional
	public boolean editforumcomment(ForumComment forumcomment) {
		try{
			sessionFactory.getCurrentSession().update(forumcomment);
			System.out.println("forumcomment is updated");
			return true;
			}
			catch(Exception e)
			{
				System.out.println("Exception is "+e);
				return false;
			}
	}
	@Transactional
	public boolean deleteforumcomment(int forumcommentId) {
		try{
			Session session= sessionFactory.getCurrentSession();
			ForumComment forumcomment=(ForumComment)session.load(ForumComment.class, forumcommentId);
			session.delete(forumcomment);
			return true;
			}
			catch(Exception e)
			{
				System.out.println("Exception is "+e);
				return false;
			}
	}
	@Transactional
	public ForumComment getforumcomment(int forumcommentId) {
		try{
			Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery("from Forumcomment where forumcommentId=?");
			query.setParameter(0, forumcommentId);
			ForumComment forumcommentlist=(ForumComment)query.getSingleResult();
			return forumcommentlist;
			}
			catch(Exception e)
			{
				System.out.println("Exception is "+e);
				return null;
			}
	}
	@Transactional
	public List<ForumComment> getAllforumcomments() {
		try{
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("from ForumComment");
			List<ForumComment> listforumcomment=query.list();
			return listforumcomment;
		}
		catch(Exception e)
		{
			System.out.println("Exception is "+e);
			return null;
		}
	}

}
