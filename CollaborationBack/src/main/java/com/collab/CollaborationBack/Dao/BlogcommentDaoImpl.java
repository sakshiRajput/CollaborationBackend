package com.collab.CollaborationBack.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.collab.CollaborationBack.model.BlogComment;

@Repository("blogcommentDao")
public class BlogcommentDaoImpl implements BlogcommentDao{


	@Autowired
	SessionFactory sessionFactory;
	
	public BlogcommentDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
		System.out.println("session created");
	}
	
	
	@Transactional
	public boolean createBlogcomment(BlogComment blogcomment) {
		
			try 
			{
			sessionFactory.getCurrentSession().save(blogcomment);
			System.out.println("blogcomment is created");
			return true;
			}
			catch(Exception e)
			{
				System.out.println("Exception is "+e);
				return false;
			}
					
	
	}
	@Transactional
	public boolean editBlogcomment(BlogComment blogcomment) {
		try{
			sessionFactory.getCurrentSession().update(blogcomment);
			System.out.println("blogcomment is updated");
			return true;
			}
			catch(Exception e)
			{
				System.out.println("Exception is "+e);
				return false;
			}
		
	}
	@Transactional
	public boolean deleteBlogcomment(int blogcommentId) {
		try{
			Session session= sessionFactory.getCurrentSession();
			BlogComment blogcomment=(BlogComment)session.load(BlogComment.class, blogcommentId);
			session.delete(blogcomment);
			return true;
			}
			catch(Exception e)
			{
				System.out.println("Exception is "+e);
				return false;
			}
	}
	@Transactional
	public BlogComment getBlogcomment(int blogcommentId) {
		try{
			Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery("from BlogComment where blogcommentId=?");
			query.setParameter(0, blogcommentId);
			BlogComment blogcommentlist=(BlogComment)query.getSingleResult();
			return blogcommentlist;
			}
			catch(Exception e)
			{
				System.out.println("Exception is "+e);
				return null;
			}
	}
	@Transactional
	public List<BlogComment> getBlogcomments(int blogId) {
		try{
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("from BlogComment where blog.blogId="+blogId);
			List<BlogComment> listblogcomment=query.list();
			return listblogcomment;
		}
		catch(Exception e)
		{
			System.out.println("Exception is "+e);
			return null;
		}
	}
	



}
