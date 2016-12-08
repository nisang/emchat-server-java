package com.che.easemob.entity;

import java.io.Serializable;

import com.fasterxml.jackson.databind.node.ContainerNode;

public class RequestBody implements Serializable{
	
	private static final long serialVersionUID = 1974216147079266814L;
	private String target_type = "users" ;
	private MsgContent msg;
	private String[] target;
	public String getTarget_type() {
		return target_type;
	}
	public void setTarget_type(String target_type) {
		this.target_type = target_type;
	}
	
	public MsgContent getMsg() {
		return msg;
	}
	public void setMsg(MsgContent msg) {
		this.msg = msg;
	}
	public String[] getTarget() {
		return target;
	}
	public void setTarget(String[] target) {
		this.target = target;
	}
	public ContainerNode<?> getBody() {
		return null;
	}
	public Boolean validate() {
		return true;
	}
	

}
