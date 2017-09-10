package com.collab.CollaborationBack;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.collab.CollaborationBack.Dao.ForumDao;
import com.collab.CollaborationBack.model.Forum;

public class ForumTestCase {

	
	
	static ForumDao forumDao;
	
	@BeforeClass
	public static void initialize()
	{		
		AnnotationConfigApplicationContext annotationConfigApplicationContext =new AnnotationConfigApplicationContext();
		annotationConfigApplicationContext.scan("com.collab");
		annotationConfigApplicationContext.refresh();
		forumDao=(ForumDao)annotationConfigApplicationContext.getBean("forumDao");
		
	}
	@Ignore
	@Test
	public void forumtest() {
		Forum forum=new Forum();
		forum.setCreateDate(new java.util.Date());
		forum.setForumContent("this is my first forum");
		forum.setForumId(4001);
		forum.setForumName("firstforum");
		forum.setStatus("Na");
		forum.setUserId(123);
		forumDao.createForum(forum);
		
		assertTrue("problem in blog creation",forumDao.createForum(forum));
		
	}
	
	@Ignore
	@Test
	public void editforumtest() {
		Forum forum=new Forum();
		forum.setCreateDate(new java.util.Date());
		forum.setForumContent("this is my second forum");
		forum.setForumId(4001);
		forum.setForumName("secondforum");
		forum.setStatus("Na");
		forum.setUserId(123);
		
		assertTrue("problem in blog editing",forumDao.editForum(forum));
	}
	
	  @Ignore
	  @Test
		public void deleteblogcomment()
		{
			 assertTrue("blogcomment deleted",forumDao.deleteForum(4001));
		}
		
	
}
