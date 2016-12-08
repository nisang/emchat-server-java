package com.che.easemob.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.che.easemob.server.comm.EasemobRestAPIFactory;
import com.che.easemob.server.comm.MessageTemplate;
import com.che.easemob.server.comm.TokenGenerator;

@Configuration
public class ClientContext {
	
	public static final String INIT_FROM_PROPERTIES = "FILE";
	
	public static final String INIT_FROM_CLASS = "CLASS";
	
	public static final String JERSEY_API = "jersey";
	
	
	public static final String HTTPCLIENT_API = "httpclient";
	
	private static final String API_PROTOCAL_KEY = "hx.api_protocal";
	
	private static final String API_HOST_KEY = "hx.api_host";
	
	private static final String API_ORG_KEY = "hx.api_org";
	
	private static final String API_APP_KEY = "hx.api_app";
	
	private static final String APP_CLIENT_ID_KEY = "hx.app_client_id";
	
	private static final String APP_CLIENT_SECRET_KEY = "hx.app_client_securt";
	
	private static final String APP_IMP_LIB_KEY = "hx.app_imp_lib";
	
	private static final Logger log = LoggerFactory.getLogger(ClientContext.class);
	
	private static ClientContext context;
		
	private Boolean initialized = Boolean.TRUE;
	
	@Value("${hx.api_protocal}")
	private String protocal="https";
	@Value("${hx.api_host}")
	private String host="a1.easemob.com";
	@Value("${hx.api_org}")
	private String org="91310115MA1K3DAB2J";
	@Value("${hx.api_app}")
	private String app="acgj2016";
	@Value("${hx.app_client_id}")
	private String clientId="YXA6yMCA4HmBEea7nxVzDfh1AQ";
	@Value("${hx.app_client_securt}")
	private String clientSecret="YXA6maJk747Q2TpJ3B2BYvWT-wJwsYI";
	@Value("${hx.app_imp_lib}")
	private String impLib="httpclient";
	
	
	private EasemobRestAPIFactory factory;
	
	private TokenGenerator token;
	
	public ClientContext() {};
	
	public ClientContext(String protocal, String host, String org, String app, String clientId, String clientSecret,
			String impLib) {
		this.protocal = protocal;
		this.host = host;
		this.org = org;
		this.app = app;
		this.clientId = clientId;
		this.clientSecret = clientSecret;
		this.impLib = impLib;
	}

	public static ClientContext getInstance() {
		if( null == context ) {
			context = new ClientContext();
		}
		return context;
	}
	
	@Bean
	public EasemobRestAPIFactory getAPIFactory() {
		context = this;
		if( null == this.factory ) {
			this.factory = EasemobRestAPIFactory.getInstance(context);
		}
		if ( null == this.token ) {
			this.token = new TokenGenerator();
		}
		return this.factory;
	}
	
	public String getSeriveURL() {
		if (null == context || !context.isInitialized()) {
			log.error(MessageTemplate.INVAILID_CONTEXT_MSG);
			throw new RuntimeException(MessageTemplate.INVAILID_CONTEXT_MSG);
		}

		String serviceURL = context.getProtocal() + "://" + context.getHost() + "/" + context.getOrg() + "/" + context.getApp();

		return serviceURL;
	}
	
	public String getAuthToken() {
		if( null == token ) {
			log.error(MessageTemplate.INVAILID_TOKEN_MSG);
			throw new RuntimeException(MessageTemplate.INVAILID_TOKEN_MSG);
		}
		
		return token.request(Boolean.FALSE);
	}
	
	
	public String getProtocal() {
		return protocal;
	}

	public String getHost() {
		return host;
	}

	public String getOrg() {
		return org;
	}

	public String getApp() {
		return app;
	}

	public String getClientId() {
		return clientId;
	}

	public String getClientSecret() {
		return clientSecret;
	}
	
	public Boolean isInitialized() {
		return initialized;
	}
	
	public String getImpLib() {
		return impLib;
	}

	
}
