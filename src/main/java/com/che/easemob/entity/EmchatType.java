package com.che.easemob.entity;

public enum EmchatType {
	
	targetUser("User"),
	targetGroup("chatgroups"),
	targetChatrooms("chatrooms")
	;
	private String target;

	private EmchatType(String target) {
		this.target = target;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}
}
