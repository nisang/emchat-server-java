package com.che.easemob.entity;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * {"action":"get","path":"/users","uri":"http://a1.easemob.com/91310115MA1K3DAB2J/aichegujia/users/aichegujia173139233323","entities":[{"uuid":"96adc680-6ab3-11e6-b79d-0b58f6e6fdde","type":"user","created":1472123024104,"modified":1472123024104,"username":"aichegujia173139233323","activated":true,"nickname":"尼桑1923"}]\
 * ,"timestamp":1472127523027,"duration":3,"count":1}

"organization":"91310115ma1k3dab2j","applicationName"
 * @author syp
 *
 */
public class ImResponse {
	
	private String action;
	private String path;
	private String uri;
	private List<ResponseUser> entities;
	private Date timestamp;
	private int duration;
	private int count;
	private Map<String,String> data;
	private String organization;
	private String application;
	private String applicationName;
	
	/** 消息 成功 失败*/
	private String message = "成功";
	/** 0:成功 1：失败 */
	private int resultCode = 0;
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public List<ResponseUser> getEntities() {
		return entities;
	}
	public void setEntities(List<ResponseUser> entities) {
		this.entities = entities;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	public String getApplication() {
		return application;
	}
	public void setApplication(String application) {
		this.application = application;
	}
	public String getApplicationName() {
		return applicationName;
	}
	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getResultCode() {
		return resultCode;
	}
	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}
	public Map<String, String> getData() {
		return data;
	}
	public void setData(Map<String, String> data) {
		this.data = data;
	}

	
}
