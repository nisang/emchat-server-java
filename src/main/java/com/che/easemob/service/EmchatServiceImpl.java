package com.che.easemob.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.che.easemob.config.ClientContext;
import com.che.easemob.entity.EmchatType;
import com.che.easemob.entity.ImResponse;
import com.che.easemob.entity.ImUser;
import com.che.easemob.server.api.impl.EasemobIMUsers;
import com.che.easemob.server.api.impl.EasemobSendMessage;
import com.che.easemob.server.comm.EasemobRestAPIFactory;
import com.che.easemob.server.comm.body.CommandMessageBody;
import com.che.easemob.server.comm.body.IMUserBody;
import com.che.easemob.server.comm.body.IMUsersBody;
import com.che.easemob.server.comm.body.TextMessageBody;
import com.che.easemob.server.comm.wrapper.BodyWrapper;
import com.che.easemob.server.comm.wrapper.ResponseWrapper;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class EmchatServiceImpl implements EmchatService {

	
	@Autowired
	private ClientContext clientContext;
	
	/**
	 * 创建im用户
	 */
	public ImResponse createNewIMUser(ImUser imuser) {
		EasemobIMUsers hxuser = (EasemobIMUsers)clientContext.getAPIFactory().newInstance(EasemobRestAPIFactory.USER_CLASS);
		BodyWrapper userBody = new IMUserBody(imuser.getUserName(), imuser.getPassword(), imuser.getNickName());
		ResponseWrapper o = (ResponseWrapper)hxuser.createNewIMUserSingle(userBody);
		ImResponse im = new ImResponse();
		if(o.getResponseStatus()==200){
			ObjectMapper obj = new ObjectMapper();
			try {
				im = obj.readValue(o.getResponseBody().toString(), ImResponse.class);
			} catch (JsonParseException e) {
				e.printStackTrace();
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return im;
		}else {
			im.setResultCode(0x01);
			im.setMessage("失败");
			return im;
		}
	}
	/**
	 * 根据用户名获取Im用户信息
	 * {"action":"get","path":"/users","uri":"http://a1.easemob.com/91310115MA1K3DAB2J/aichegujia/users/aichegujia173139233323","entities":[{"uuid":"96adc680-6ab3-11e6-b79d-0b58f6e6fdde","type":"user","created":1472123024104,"modified":1472123024104,"username":"aichegujia173139233323","activated":true,"nickname":"尼桑1923"}],"timestamp":1472127523027,"duration":3,"count":1}
	 * //{"uuid":"96adc680-6ab3-11e6-b79d-0b58f6e6fdde","type":"user","created":1472123024104,"modified":1472123024104,"username":"aichegujia173139233323","activated":true,"nickname":"尼桑1923"}
	 */
	public ImResponse getImUserByUserName(String userName) {
		EasemobIMUsers hxuser = (EasemobIMUsers)clientContext.getAPIFactory().newInstance(EasemobRestAPIFactory.USER_CLASS);
		ResponseWrapper o = (ResponseWrapper)hxuser.getIMUsersByUserName(userName);
		ImResponse im = new ImResponse();
		if(o.getResponseStatus()==200){
			ObjectMapper obj = new ObjectMapper();
			try {
				im = obj.readValue(o.getResponseBody().toString(), ImResponse.class);
			} catch (JsonParseException e) {
				e.printStackTrace();
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return im;
		}else {
			im.setResultCode(0x01);
			im.setMessage("失败");
			return im;
		}
		
	}
	/**
	 * 批量添加用户
	 */
	public ImResponse createNewIMUserBatch(List<ImUser> imusers) {
		EasemobIMUsers hxuser = (EasemobIMUsers)clientContext.getAPIFactory().newInstance(EasemobRestAPIFactory.USER_CLASS);
		List<IMUserBody> userBody = new ArrayList<IMUserBody>();
		for(ImUser temp : imusers){
			IMUserBody imUserbody = new IMUserBody(temp.getUserName(), temp.getPassword(), temp.getNickName());
			userBody.add(imUserbody);
		}
		BodyWrapper usersBody = new IMUsersBody(userBody);
		ResponseWrapper o = (ResponseWrapper)hxuser.createNewIMUserBatch(usersBody);
		ImResponse im = new ImResponse();
		if(o.getResponseStatus()==200){
			ObjectMapper obj = new ObjectMapper();
			try {
				im = obj.readValue(o.getResponseBody().toString(), ImResponse.class);
			} catch (JsonParseException e) {
				e.printStackTrace();
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return im;
		}else {
			im.setResultCode(0x01);
			im.setMessage("失败");
			return im;
		}
	}
	public ImResponse getImUsersBatch(Long limit) {
		EasemobIMUsers hxuser = (EasemobIMUsers)clientContext.getAPIFactory().newInstance(EasemobRestAPIFactory.USER_CLASS);
		ResponseWrapper o = (ResponseWrapper)hxuser.getIMUsersBatch(limit,"");
		ImResponse im = new ImResponse();
		if(o.getResponseStatus()==200){
			ObjectMapper obj = new ObjectMapper();
			try {
				im = obj.readValue(o.getResponseBody().toString(), ImResponse.class);
			} catch (JsonParseException e) {
				e.printStackTrace();
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return im;
		}else {
			im.setResultCode(0x01);
			im.setMessage("失败");
			return im;
		}
	}
	public ImResponse sendMessage(String[] userNames,String mess) {
		EasemobSendMessage hxuser = (EasemobSendMessage)clientContext.getAPIFactory().newInstance(EasemobRestAPIFactory.SEND_MESSAGE_CLASS);
		ResponseWrapper payload = ResponseWrapper.newInstance();
		TextMessageBody responseBody = new TextMessageBody(EmchatType.targetUser.getTarget(), userNames, null, null, "text");
		payload.setResponseBody(responseBody);
		ResponseWrapper o = (ResponseWrapper)hxuser.sendMessage(payload);
		ImResponse im = new ImResponse();
		if(o.getResponseStatus()==200){
			ObjectMapper obj = new ObjectMapper();
			try {
				im = obj.readValue(o.getResponseBody().toString(), ImResponse.class);
			} catch (JsonParseException e) {
				e.printStackTrace();
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return im;
		}else {
			im.setResultCode(0x01);
			im.setMessage("失败");
			return im;
		}
	}
	/**
	 * mess 格式："{'messageType':0,'desc':'"+mess+"'}"
	 */
	public ImResponse sendCmdMessage(String[] userNames, String mess) {
		EasemobSendMessage hxuser = (EasemobSendMessage)clientContext.getAPIFactory().newInstance(EasemobRestAPIFactory.SEND_MESSAGE_CLASS);
		Map<String, String> ext = new HashMap<String,String>();
		ext.put("ext","ext");//"{'messageType':0,'desc':'"+mess+"'}"
		CommandMessageBody requestBody = new CommandMessageBody("users", userNames, null, ext, mess);
		ResponseWrapper o = (ResponseWrapper)hxuser.sendMessage(requestBody);
		ImResponse im = new ImResponse();
		if(o.getResponseStatus()==200){
			ObjectMapper obj = new ObjectMapper();
			try {
				im = obj.readValue(o.getResponseBody().toString(), ImResponse.class);
			} catch (JsonParseException e) {
				e.printStackTrace();
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return im;
		}else {
			im.setResultCode(0x01);
			im.setMessage("失败");
			return im;
		}
	}
	/**
	 * 发送自定义消息，并携带ext信息
	 */
	public ImResponse sendCustomTextMessage(String[] userName,String from, String mess, Map<String, String> ext) {
		EasemobSendMessage hxuser = (EasemobSendMessage)clientContext.getAPIFactory().newInstance(EasemobRestAPIFactory.SEND_MESSAGE_CLASS);
		TextMessageBody requestBody = new TextMessageBody("users", userName, from, ext, "{'messageType':0,'desc':'"+mess+"'}");
		ResponseWrapper o = (ResponseWrapper)hxuser.sendMessage(requestBody);
		ImResponse im = new ImResponse();
		if(o.getResponseStatus()==200){
			ObjectMapper obj = new ObjectMapper();
			try {
				im = obj.readValue(o.getResponseBody().toString(), ImResponse.class);
			} catch (JsonParseException e) {
				e.printStackTrace();
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return im;
		}else {
			im.setResultCode(0x01);
			im.setMessage("失败");
			return im;
		}
	}

}
