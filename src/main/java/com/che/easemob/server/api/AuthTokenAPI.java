package com.che.easemob.server.api;

public interface AuthTokenAPI{	
	Object getAuthToken(String clientId, String clientSecret);
}
