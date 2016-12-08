package com.che.easemob.server.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.che.easemob.config.ClientContext;
import com.che.easemob.entity.ImResponse;
import com.che.easemob.server.api.ChatGroupAPI;
import com.che.easemob.server.api.ChatMessageAPI;
import com.che.easemob.server.api.ChatRoomAPI;
import com.che.easemob.server.api.FileAPI;
import com.che.easemob.server.api.IMUserAPI;
import com.che.easemob.server.api.SendMessageAPI;
import com.che.easemob.server.comm.EasemobRestAPIFactory;
import com.che.easemob.server.comm.body.IMUserBody;
import com.che.easemob.server.comm.body.IMUsersBody;
import com.che.easemob.server.comm.helper.HeaderHelper;
import com.che.easemob.server.comm.wrapper.BodyWrapper;
import com.che.easemob.server.comm.wrapper.HeaderWrapper;
import com.che.easemob.server.comm.wrapper.ResponseWrapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class TestUser {

	public void test1() throws Exception {
		EasemobRestAPIFactory factory = ClientContext.getInstance().getAPIFactory();
		
		ObjectMapper obj = new ObjectMapper();
		
		IMUserAPI user = (IMUserAPI)factory.newInstance(EasemobRestAPIFactory.USER_CLASS);
		
		
		BodyWrapper userBody = new IMUserBody("User105611112211", "1231222211456", "12333314");
		ResponseWrapper o2 = (ResponseWrapper)user.createNewIMUserSingle(userBody);
		
		ImResponse im = obj.readValue(o2.getResponseBody().toString(), ImResponse.class);
		System.out.println(im.getEntities().get(0).getNickname());
		System.out.println(o2.toString());
		System.out.println("===================");
		ResponseWrapper o = (ResponseWrapper) user.getIMUsersByUserName("aichegujia173139233323");
		
		 im = obj.readValue(o.getResponseBody().toString(), ImResponse.class);
		System.out.println(im.getEntities().get(0).getNickname());
		ChatMessageAPI chat = (ChatMessageAPI)factory.newInstance(EasemobRestAPIFactory.MESSAGE_CLASS);
		FileAPI file = (FileAPI)factory.newInstance(EasemobRestAPIFactory.FILE_CLASS);
		SendMessageAPI message = (SendMessageAPI)factory.newInstance(EasemobRestAPIFactory.SEND_MESSAGE_CLASS);
		ChatGroupAPI chatgroup = (ChatGroupAPI)factory.newInstance(EasemobRestAPIFactory.CHATGROUP_CLASS);
		ChatRoomAPI chatroom = (ChatRoomAPI)factory.newInstance(EasemobRestAPIFactory.CHATROOM_CLASS);
//
        ResponseWrapper fileResponse = (ResponseWrapper) file.uploadFile(new File("d:/banner.jpg"));
        String uuid = ((ObjectNode) fileResponse.getResponseBody()).get("entities").get(0).get("uuid").asText();
        String shareSecret = ((ObjectNode) fileResponse.getResponseBody()).get("entities").get(0).get("share-secret").asText();
        InputStream in = new FileInputStream((File)((ResponseWrapper) file.downloadFile(uuid, shareSecret, false)).getResponseBody());
        FileOutputStream fos = new FileOutputStream("d:/banner1.jpg");
        byte[] buffer = new byte[1024];
        int len1 = 0;
        while ((len1 = in.read(buffer)) != -1) {
            fos.write(buffer, 0, len1);
        }
        fos.close();

        // Create a IM user
		userBody = new IMUserBody("User1056", "123111456", "1233334");
		user.createNewIMUserSingle(userBody);
		// Create some IM users
		List<IMUserBody> users = new ArrayList<IMUserBody>();
		users.add(new IMUserBody("User002", "123456", null));
		users.add(new IMUserBody("User003", "123456", null));
		BodyWrapper usersBody = new IMUsersBody(users);
		user.createNewIMUserBatch(usersBody);
		
		// Get a IM user
		
		 //Get a fake user
		user.getIMUsersByUserName("FakeUser001");
		
//		// Get 12 users
		user.getIMUsersBatch(null, null);
	}
	
	/**
	 * 获取聊天记录中所需的token
	 * url:https://a1.easemob.com/91310115MA1K3DAB2J/acgj2016/chatmessages?ql=select+*+where+timestamp<1477360680023&limit=1000&cursor=MTQzNjgyOTEyMDpnR2tBQVFNQWdHa0FCZ0ZYNnhuNWFnQ0FkUUFRdWlCeUFwZ2hFZWFYRUNjckxUNktIUUNBZFFBUXVpQngtSmdoRWVhRXZ2SERBR3F4WGdB
	 */
	@Test
	public void test2(){
		EasemobRestAPIFactory factory = ClientContext.getInstance().getAPIFactory();
		HeaderWrapper header = HeaderHelper.getDefaultHeaderWithToken();
		Calendar cla = Calendar.getInstance();
		cla.set(2016, 10, 23, 01, 00);
		System.out.println(cla.getTime().getTime());
		System.out.println(new Date().getTime());
	}

}
