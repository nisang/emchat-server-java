package com.che.easemob.entity;

import java.io.Serializable;

public class ImUser implements Serializable{
	private static final long serialVersionUID = -2115999065081339815L;

	private String userName;
	
	private String password;
	
	private String nickName;
	
	public ImUser(){}
	public ImUser(String userName, String password, String nickName) {
		this.userName = userName;
		this.password = password;
		this.nickName = nickName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	

}
