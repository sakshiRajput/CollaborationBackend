package com.collab.CollaborationBack;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.collab.CollaborationBack.Dao.ForumCommentDao;
import com.collab.CollaborationBack.model.ForumComment;

public class ForumcommentTestCase {

	static ForumCommentDao forumcommentDao; 
	
	@BeforeClass
	public static void initialize()
	{		
		AnnotationConfigApplicationContext annotationConfigApplicationContext =new AnnotationConfigApplicationContext();
		annotationConfigApplicationContext.scan("com.collab");
		annotationConfigApplicationContext.refresh();
		forumcommentDao=(ForumCommentDao)annotationConfigApplicationContext.getBean("forumcommentDao");
		
	}
	@Ignore
	@Test
	public void createforumcommenttest() {
		 ForumComment forumcomment=new ForumComment(); 
		 forumcomment.setCommentDate(new java.util.Date());
		 forumcomment.setForumComment("forumComment");
		 forumcomment.setForumcommentId(122);
		 forumcomment.setForumId(111);
		 forumcomment.setUserId(123);
		 forumcomment.setUserName("sakshi");
		 forumcommentDao.createforumcomment(forumcomment);
		 
		 assertTrue("problem in creating forumcomment",forumcommentDao.createforumcomment(forumcomment));
	}
	//@Ignore
	@Test
	public void editforumcomment()
	{
		 ForumComment forumcomment= new ForumComment() ;
		 
		 forumcomment.setForumcommentId(212);
		 forumcomment.setForumId(212);
		 forumcomment.setForumComment("new forumComment");
		 forumcomment.setCommentDate(new java.util.Date());
		 forumcomment.setUserId(123);
		 forumcomment.setUserName("sak");
		 
		 assertTrue("problem in editing forumcomment",forumcommentDao.editforumcomment(forumcomment));
	}
	@Ignore
	@Test
	public void deletetforumcomment()
	{
		 assertTrue("problem in deleting forumcomment",forumcommentDao.deleteforumcomment(122));
	}

		
}
