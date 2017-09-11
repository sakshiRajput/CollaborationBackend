package com.collab.CollaborationBack;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.collab.CollaborationBack.Dao.FriendDao;
import com.collab.CollaborationBack.model.Blog;
import com.collab.CollaborationBack.model.Friend;


public class FriendTestCase {

	
	static FriendDao friendDao;
	
	@BeforeClass
	public static void initialize()
	{		
		AnnotationConfigApplicationContext annotationConfigApplicationContext =new AnnotationConfigApplicationContext();
		annotationConfigApplicationContext.scan("com.collab");
		annotationConfigApplicationContext.refresh();
		friendDao=(FriendDao)annotationConfigApplicationContext.getBean("friendDao");
		
	}
	
	@Test
	public void friendtest() {
		Friend friend=new Friend();
		
		friend.setFriendId(124);
		friend.setStatus("online");
		friend.setUserId(123);
        friendDao.createfriend(friend);
        
		System.out.println("creating friend 2");
		assertTrue("problem in creating a new friend",friendDao.createfriend(friend));
	}
	@Ignore
	@Test
	public void editfriend()
	{
		Friend friend=new Friend();
		
		friend.setFriendId(124);
		friend.setStatus("offline");
		friend.setUserId(123);
		 friendDao.editfriend(friend);
		 
		 assertTrue("problem in editing a friend",friendDao.editfriend(friend));
	}
	@Ignore
	@Test
	public void deletefriend()
	{
		 assertTrue("problem in deleting a friend",friendDao.deletefriend(124));
	}
	
	@Ignore
	@Test
	public void getallfriendtest()
	{
		List<Friend> friendlist=friendDao.getAllfriends();
		assertTrue("No friends",friendlist.size()>0);
	}
}
