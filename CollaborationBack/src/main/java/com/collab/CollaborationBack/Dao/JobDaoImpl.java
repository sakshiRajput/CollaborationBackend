package com.collab.CollaborationBack.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.collab.CollaborationBack.model.Job;

@Repository("jobDao")
public class JobDaoImpl implements JobDao{

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public boolean addjob(Job job) {
		try 
		{
		sessionFactory.getCurrentSession().save(job);
		System.out.println("job added  ");
		return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception is "+e);
			return false;
		}
	}
	@Transactional
	public boolean updatejob(Job job) {
		try{
			Session session = sessionFactory.getCurrentSession();
			session.update(job);
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
	public boolean deletejob(int jobId) {
		try{
			Session session= sessionFactory.getCurrentSession();
			Job job=(Job)session.load(Job.class, jobId);
			session.delete(job);
			return true;
			}
			catch(Exception e)
			{
				System.out.println("Exception is "+e);
				return false;
			}
	}
	@Transactional
	public List<Job> getalljob() {
		try{
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("from Job");
			List<Job> listjob=query.list();
			return listjob;
			}
			catch(Exception e)
			{
				System.out.println("Exception is "+e);
				return null;
			}	
		}
	@Transactional
	public Job getjobById(int jobId) {
		try{
			Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery("from Job where jobId=?");
			query.setParameter(0, jobId);
			Job joblist=(Job)query.getSingleResult();
			//session.close();
			return joblist;
			}
			catch(Exception e)
			{
				System.out.println("Exception is "+e);
				return null;
			}	
	}

}
