package com.collab.CollaborationBack.model;


public class Error {

	
	private int code;
	private String messege;
	public Error(int code,String messege)
	{
	super();
	this.code=code;
	this.messege=messege;
		
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessege() {
		return messege;
	}
	public void setMessege(String messege) {
		this.messege = messege;
	}
	
}
