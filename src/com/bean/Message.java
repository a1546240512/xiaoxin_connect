package com.bean;

import java.io.Serializable;

public class Message implements Serializable{
	private User user;
	private String oprAction;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getOprAction() {
		return oprAction;
	}
	public void setOprAction(String oprAction) {
		this.oprAction = oprAction;
	}
	
}
