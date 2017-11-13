package com.collab.CollaborationBack.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="Message")
public class Message implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	
	public Message() {
		
	}
	public Message( int id,String message) {
		
		this.message = message;
		this.id = id;
		
	}
	private String message;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
   
	  
	  
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	 
//	public Message

}
