package com.collab.CollaborationBack.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


@Entity
@Component
@Table(name="BlogComment")
public class BlogComment {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer blogcommentId;
	
	private String blogComment;
	private Date commentDate;
	@ManyToOne
	private User commentedBy;
	public User getCommentedBy() {
		return commentedBy;
	}
	public void setCommentedBy(User commentedBy) {
		this.commentedBy = commentedBy;
	}
	public Blog getBlog() {
		return blog;
	}
	public void setBlog(Blog blog) {
		this.blog = blog;
	}
	@ManyToOne
	private Blog blog;
	
	
	
	public String getBlogComment() {
		return blogComment;
	}
	public void setBlogComment(String blogComment) {
		this.blogComment = blogComment;
	}
	
	
	public Integer getBlogcommentId() {
		return blogcommentId;
	}
	public void setBlogcommentId(Integer blogcommentId) {
		this.blogcommentId = blogcommentId;
	}
	
	public Date getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}
	
	
	
	
}
