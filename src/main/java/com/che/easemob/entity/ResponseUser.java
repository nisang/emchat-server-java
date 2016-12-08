package com.che.easemob.entity;

import java.util.Date;

/**
 * "entities":[{"uuid":"96adc680-6ab3-11e6-b79d-0b58f6e6fdde","type":"user","created":1472123024104,"modified":1472123024104,"username":"aichegujia173139233323","activated":true,"nickname":"尼桑1923"}]
 * @author Administrator
 *
 */
public class ResponseUser {
	private String uuid;
	private String type;
	private Date created;
	private Date modified;
	private String username;
	private boolean activated;
	private String nickname;
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getModified() {
		return modified;
	}
	public void setModified(Date modified) {
		this.modified = modified;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public boolean isActivated() {
		return activated;
	}
	public void setActivated(boolean activated) {
		this.activated = activated;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
}
