package com.che.easemob.server.comm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.che.easemob.config.ClientContext;
import com.che.easemob.server.api.AuthTokenAPI;
import com.che.easemob.server.comm.wrapper.ResponseWrapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class TokenGenerator {
	
	private static final Logger log = LoggerFactory.getLogger(TokenGenerator.class);
	
	private String accessToken;
	private Long expiredAt = -1L;
	
	private ClientContext context = ClientContext.getInstance() ;
	
	public String request(Boolean force) {
		force = (null == force) ? Boolean.FALSE : force;
		
		if( isExpired() || force ) {
			// Request new token
			if( null == context || !context.isInitialized() ) {
				log.error(MessageTemplate.INVAILID_CONTEXT_MSG);
				throw new RuntimeException(MessageTemplate.INVAILID_CONTEXT_MSG);
			}
			
			AuthTokenAPI authService = (AuthTokenAPI) context.getAPIFactory().newInstance(EasemobRestAPIFactory.TOKEN_CLASS);
			String clientId = context.getClientId();
			String clientSecret = context.getClientSecret();
			ResponseWrapper response = (ResponseWrapper) authService.getAuthToken(clientId, clientSecret);
			
			if( null != response && 200 == response.getResponseStatus() && null != response.getResponseBody() ) {
				ObjectNode responseBody = (ObjectNode) response.getResponseBody();
				String newToken =  responseBody.get("access_token").asText();
				Long newTokenExpire = responseBody.get("expires_in").asLong() * 1000;
				
				log.debug("New token: " + newToken);
				log.debug("New token expires: " + newTokenExpire);
				
				this.accessToken = newToken;
				this.expiredAt = System.currentTimeMillis() + newTokenExpire;
				log.info(MessageTemplate.print(MessageTemplate.REFRESH_TOKEN_MSG, new String[]{accessToken, expiredAt.toString()}));
			}
			else {
				log.error(MessageTemplate.REFRESH_TOKEN_ERROR_MSG);
			}
		}
		
		return accessToken;
	}

	public Boolean isExpired() {
		return System.currentTimeMillis() > expiredAt;
	}
	
	public void setContext(ClientContext context) {
		this.context = context;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public Long getExpiredAt() {
		return expiredAt;
	}

	@Override
	public String toString() {
		return accessToken;
	}

}
