package com.che.easemob.service;

import java.util.List;
import java.util.Map;

import com.che.easemob.entity.ImResponse;
import com.che.easemob.entity.ImUser;


public interface EmchatService {
	
	ImResponse createNewIMUser(ImUser imuser);
	
	ImResponse getImUserByUserName(String userName);
	
	ImResponse createNewIMUserBatch(List<ImUser> imusers);
	
	ImResponse getImUsersBatch(Long limit);
	
	ImResponse sendMessage(String[] userNames,String mess);
	
	ImResponse sendCmdMessage(String[] userName,String mess);
	
	ImResponse sendCustomTextMessage(String[] userName,String from, String mess,Map<String, String> ext);
}
