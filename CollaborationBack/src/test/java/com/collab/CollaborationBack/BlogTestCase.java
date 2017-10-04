package com.collab.CollaborationBack;



import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.collab.CollaborationBack.Dao.BlogDao;
import com.collab.CollaborationBack.model.Blog;

public class BlogTestCase {

	static BlogDao blogDao;
	
	@BeforeClass
	public static void initialize()
	{		
		AnnotationConfigApplicationContext annotationConfigApplicationContext =new AnnotationConfigApplicationContext();
		annotationConfigApplicationContext.scan("com.collab");
		annotationConfigApplicationContext.refresh();
		blogDao=(BlogDao)annotationConfigApplicationContext.getBean("blogDao");
		
	}
	
	@Ignore
	@Test
	public void blogtest() {
		Blog blog=new Blog();
		blog.setBlogId(111);
		blog.setBlogName("firstblog");
		blog.setBlogContent("this is my first blog");
		blog.setCreateDate(new java.util.Date());
		blog.setLikes(0);
		blog.setStatus("NA");
		
		blogDao.createBlog(blog);
		
		assertTrue("problem in blog creation",blogDao.createBlog(blog));
		
	}
	@Ignore
	@Test
    public void	approveblog()
    {  Blog blog=new Blog();
       blog.setBlogId(111);
	   blog.setBlogName("firstblog");
	   blog.setBlogContent("this is my first blog");
	   blog.setCreateDate(new java.util.Date());
	   blog.setLikes(0);
	   blog.setStatus("NA");
		//blog.setUserName(user);;
    
       
       assertTrue("approved blog",blogDao.approveBlog(blog));
    }
	
	
	@Ignore
	@Test
	public void getallapprovedblogtest()
	{
		List<Blog> listblog=blogDao.getAllBlogs();
		assertTrue("No approved blogs",listblog.size()>0);
	}
	
   // @Ignore
	@Test
	public void editblog()
	{
		 Blog blog=blogDao.getBlog(111);
		
		   blog.setBlogId(111);
		   blog.setBlogName("secondblog");
		   blog.setBlogContent("this is my second blog");
		   blog.setCreateDate(new java.util.Date());
		   blog.setLikes(0);
		   blog.setStatus("NA");
			//blog.setUserName("sak");;
		
		 assertTrue("blog edited",blogDao.editBlog(blog));
	}
	
}
