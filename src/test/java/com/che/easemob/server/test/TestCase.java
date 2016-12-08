package com.che.easemob.server.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.che.easemob.config.ClientContext;
import com.che.easemob.server.api.impl.EasemobSendMessage;
import com.che.easemob.server.comm.EasemobRestAPIFactory;
import com.che.easemob.server.comm.body.CommandMessageBody;
import com.che.easemob.server.comm.wrapper.ResponseWrapper;

public class TestCase {
	
	/**
	 * 发送透传消息
	 */
	public void testCmd(){
		Map<String, String> ext = new HashMap<String,String>();
		ext.put("ext","ext");
		EasemobSendMessage hxuser = (EasemobSendMessage)ClientContext.getInstance().getAPIFactory().newInstance(EasemobRestAPIFactory.SEND_MESSAGE_CLASS);
		CommandMessageBody requestBody = new CommandMessageBody("users", new String[]{"aichegujia15221618022"}, null, ext, "{'messageType':0,'desc':'您发布的车源：2015款 奥迪A4L 30 TFSI 自动舒适型有一条新估价。'}");
		ResponseWrapper o = (ResponseWrapper)hxuser.sendMessage(requestBody);
		System.out.println(o.toString());
	}

}
