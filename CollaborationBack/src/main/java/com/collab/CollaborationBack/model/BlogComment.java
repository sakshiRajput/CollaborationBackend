package com.collab.CollaborationBack.model;

import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="BlogComment")
public class BlogComment {
	@Id
	private Integer blogcommentId;
	private Integer blogId;
	private String blogComment;
	public String getBlogComment() {
		return blogComment;
	}
	public void setBlogComment(String blogComment) {
		this.blogComment = blogComment;
	}
	private Date commentDate;
	private Integer userId;
	
	public Integer getBlogcommentId() {
		return blogcommentId;
	}
	public void setBlogcommentId(Integer blogcommentId) {
		this.blogcommentId = blogcommentId;
	}
	public Integer getBlogId() {
		return blogId;
	}
	public void setBlogId(Integer blogId) {
		this.blogId = blogId;
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
	private String userName;
	
	

}
