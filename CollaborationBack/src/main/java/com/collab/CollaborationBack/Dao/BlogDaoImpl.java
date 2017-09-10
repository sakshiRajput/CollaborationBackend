package com.collab.CollaborationBack.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.collab.CollaborationBack.model.Blog;

@Repository("blogDao")
public class BlogDaoImpl implements BlogDao{

	
	@Autowired
	SessionFactory sessionFactory;
	

	
	public BlogDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
		System.out.println("session created");
	}
	

//	@Override
	@Transactional
	public boolean createBlog(Blog blog) {
		try 
		{
		sessionFactory.getCurrentSession().saveOrUpdate(blog);
		return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception is "+e);
			return false;
		}
		
	}
	@Transactional
	public boolean editBlog(Blog blog) {
		
		try{
		sessionFactory.getCurrentSession().update(blog);
		System.out.println("table is updated");
		System.out.println("id:-");
		return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception is "+e);
			return false;
		}
		
	}
	@Transactional
	public boolean deleteBlog(int blogId) {
		
		try{
		Session session= sessionFactory.getCurrentSession();
		Blog blog=(Blog)session.load(Blog.class, blogId);
		session.delete(blog);
		return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception is "+e);
			return false;
		}
	}
	@Transactional
	public Blog getBlog(int blogId) {
	
		try{
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Blog where blogid=?");
		query.setParameter(0, blogId);
		Blog bloglist=(Blog)query.getSingleResult();
		return bloglist;
		}
		catch(Exception e)
		{
			System.out.println("Exception is "+e);
			return null;
		}
	}
	@Transactional
	public List<Blog> getAllBlogs() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Blog where status='A'");
		List<Blog> listblog=query.list();
		return listblog;
	}
	@Transactional
	public boolean approveBlog(Blog blog) {
		try{
		blog.setStatus("A");
		sessionFactory.getCurrentSession().saveOrUpdate(blog);
		return true ;
		}
		catch(Exception e)
		{
			System.out.println("Exception is "+e);
			return false;
		}
		
	}

}
