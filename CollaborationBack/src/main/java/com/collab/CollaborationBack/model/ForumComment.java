package com.collab.CollaborationBack.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="ForumComment")
public class ForumComment {
	
	@Id
	private Integer forumcommentId;
	private Integer forumId;
	private String forumComment;
	private Date commentDate;
	private Integer userId;
    private String userName;
	public Integer getForumcommentId() {
		return forumcommentId;
	}
	public void setForumcommentId(Integer forumcommentId) {
		this.forumcommentId = forumcommentId;
	}
	public Integer getForumId() {
		return forumId;
	}
	public void setForumId(Integer forumId) {
		this.forumId = forumId;
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
	
	

}
