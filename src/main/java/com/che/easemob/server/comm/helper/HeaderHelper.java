package com.che.easemob.server.comm.helper;

import com.che.easemob.config.ClientContext;
import com.che.easemob.server.comm.wrapper.HeaderWrapper;

public class HeaderHelper {
	
	private static ClientContext context = ClientContext.getInstance();

	public static HeaderWrapper getDefaultHeader() {
		return HeaderWrapper.newInstance().addJsonContentHeader();
	}
	
	public static HeaderWrapper getDefaultHeaderWithToken() {
 		return getDefaultHeader().addAuthorization(context.getAuthToken());
	}
	public static HeaderWrapper getDefaultHeaderWithToken(ClientContext context) {
 		return getDefaultHeader().addAuthorization(context.getAuthToken());
	}

	public static HeaderWrapper getUploadHeaderWithToken() {
		return HeaderWrapper.newInstance().addAuthorization(context.getAuthToken()).addRestrictAccess();
	}

	public static HeaderWrapper getDownloadHeaderWithToken(String shareSecret, Boolean isThumb) {
		HeaderWrapper headerWrapper = HeaderWrapper.newInstance().addAuthorization(context.getAuthToken()).addMediaAccept().addShareSecret(shareSecret);
		if(isThumb) {
			headerWrapper.addThumbnail();
		}

		return headerWrapper;
	}
}
