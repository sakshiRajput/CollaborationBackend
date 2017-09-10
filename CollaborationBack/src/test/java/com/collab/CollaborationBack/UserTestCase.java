package com.collab.CollaborationBack;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.collab.CollaborationBack.Dao.UserDao;
import com.collab.CollaborationBack.model.Forum;
import com.collab.CollaborationBack.model.User;

public class UserTestCase {

	static UserDao userDao;
	
	@BeforeClass
	public static void initialize()
	{		
		AnnotationConfigApplicationContext annotationConfigApplicationContext =new AnnotationConfigApplicationContext();
		annotationConfigApplicationContext.scan("com.collab");
		annotationConfigApplicationContext.refresh();
		userDao=(UserDao)annotationConfigApplicationContext.getBean("userDao");
		
	}
	@Ignore
	@Test
	public void addusertest() {
	
		User user=new User();
		user.setEmailId("sak@gmail.com");
		user.setFirstName("sakshi");
		user.setIsOnline("yes");
		user.setLastName("raj");
		user.setPassword("pass");
		user.setRole("user");
		user.setStatus("A");
		user.setUserId(123);
		userDao.addUser(user);
		assertTrue("problem in adding user",userDao.addUser(user));
		
	}
	 @Ignore
	@Test
	public void editusertest() {
	
		User user=new User();
		user.setEmailId("sak@gmail.com");
		user.setFirstName("diksha");
		user.setIsOnline("no");
		user.setLastName("raj");
		user.setPassword("pass");
		user.setRole("user");
		user.setStatus("A");
		user.setUserId(123);
	
		assertTrue("problem in editing user",userDao.updateUser(user));
		
	}
	
	 // @Ignore
	  @Test
		public void deleteuser()
		{
			 assertTrue("problem iin user deletion",userDao.deleteUser(123));
		}
	
	  @Ignore
	  @Test
		public void getallforumtest()
		{
			 List<User> listuser=userDao.getUser();
			 assertTrue("No forums",listuser.size()>0);
		}
	  

}
