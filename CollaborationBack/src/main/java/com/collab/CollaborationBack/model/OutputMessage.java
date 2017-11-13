package com.collab.CollaborationBack.model;

import java.util.Date;

public class OutputMessage extends Message {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date time;

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	 public OutputMessage( Message message,Date time)
	 {
		 super(message.getId(),message.getMessage());
		 this.time=time;
		 
		 
	 }
}
