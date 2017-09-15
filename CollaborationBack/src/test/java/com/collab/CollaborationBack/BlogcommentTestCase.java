package com.collab.CollaborationBack;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.collab.CollaborationBack.Dao.BlogcommentDao;
import com.collab.CollaborationBack.model.BlogComment;

public class BlogcommentTestCase {

	
	static BlogcommentDao blogcommentDao; 
	
	@BeforeClass
	public static void initialize()
	{		
		AnnotationConfigApplicationContext annotationConfigApplicationContext =new AnnotationConfigApplicationContext();
		annotationConfigApplicationContext.scan("com.collab");
		annotationConfigApplicationContext.refresh();
		blogcommentDao=(BlogcommentDao)annotationConfigApplicationContext.getBean("blogcommentDao");
		
	}
    @Ignore
	@Test
	public void createblogcommenttest() {
	BlogComment blogcomment=new BlogComment();
	blogcomment.setBlogcommentId(123);
	blogcomment.setBlogId(111);
	blogcomment.setBlogComment("this is my first comment");
	blogcomment.setCommentDate(new java.util.Date());
	blogcomment.setUserId(222);
	blogcomment.setUserName("sakshi");
	blogcommentDao.createBlogcomment(blogcomment);
	
	assertTrue("problem in blogcomment creation",blogcommentDao.createBlogcomment(blogcomment));
		
	}
	
   // @Ignore
	@Test
	public void editblogcomment()
	{
		BlogComment blogcomment=blogcommentDao.getBlogcomment(512);
		blogcomment.setBlogId(412);
		blogcomment.setBlogComment("this is my second comment");
		blogcomment.setCommentDate(new java.util.Date());
		blogcomment.setUserId(232);
		blogcomment.setUserName("diksha");
		
		assertTrue("blogcomment edited",blogcommentDao.editBlogcomment(blogcomment));
	}
    @Ignore	
	@Test
	public void getallblogcommentstest()
	{
		 List<BlogComment> listblogcomment=blogcommentDao.getAllBlogcomments();
		assertTrue("No approved blogs",listblogcomment.size()>0);
	}
    @Ignore
	@Test
	public void deleteblogcomment()
	{
		 assertTrue("blogcomment deleted",blogcommentDao.deleteBlogcomment(123));
	}
	
}
