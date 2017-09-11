package com.collab.CollaborationBack.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="ForumComment")
public class ForumComment {
	
	@Id
	private Integer forumcommentId;
//	private Integer forumId;
	private String forumComment;
	private Date commentDate;
	//private Integer userId;
    private String userName;
	public Integer getForumcommentId() {
		return forumcommentId;
	}
	public void setForumcommentId(Integer forumcommentId) {
		this.forumcommentId = forumcommentId;
	}

	public String getForumComment() {
		return forumComment;
	}
	public void setForumComment(String forumComment) {
		this.forumComment = forumComment;
	}
	public Date getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	

	@ManyToOne
	@JoinColumn(name = "userId", nullable = false, updatable = false, insertable = false)
	private User user;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	private Integer userId;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "forumId",nullable = false, updatable = false, insertable = false)
	private Forum forum;
	private Integer forumId;
	public Integer getForumId() {
		return forumId;
	}
	public void setForumId(Integer forumId) {
		this.forumId = forumId;
	}
	public Forum getForum() {
		return forum;
	}
	public void setForum(Forum forum) {
		this.forum = forum;
	}

}
