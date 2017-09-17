package com.collab.CollaborationBack;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.collab.CollaborationBack.Dao.JobDao;
import com.collab.CollaborationBack.model.Job;


public class JobTestCase {

static JobDao jobDao;
	
	@BeforeClass
	public static void initialize()
	{		
		AnnotationConfigApplicationContext annotationConfigApplicationContext =new AnnotationConfigApplicationContext();
		annotationConfigApplicationContext.scan("com.collab");
		annotationConfigApplicationContext.refresh();
		jobDao=(JobDao)annotationConfigApplicationContext.getBean("jobDao");
		
	}
	 @Ignore
	@Test
	public void addjobtest() {
		
		Job job =new Job();
		job.setJobDesc("this is job description");
		job.setJobId(565);
		job.setJobProfile("jobProfile");
		job.setQualification("qualification");
		job.setStatus("NA");
		job.setPostDate(new java.util.Date());
		jobDao.addjob(job);
		
		assertTrue("problem in adding job",jobDao.addjob(job));
		
	}
	// @Ignore
	@Test
	public void editjobtest() {
		Job job =jobDao.getjobById(565);
		job.setJobDesc("this is job description 2");
		job.setJobId(565);
		job.setJobProfile("jobProfile1");
		job.setQualification("qualification1");
		job.setStatus("NA");
		
		assertTrue("problem in adding job",jobDao.updatejob(job));
	
	}
	 @Ignore
	 @Test
		public void deleteuser()
		{
			 assertTrue("problem iin user deletion",jobDao.deletejob(565));
		}
	 
	  @Ignore
	  @Test
		public void getalljobtest()
		{
			 List<Job> listjob=jobDao.getalljob();
			 assertTrue("No users",listjob.size()>0);
		}
	   @Ignore 
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
