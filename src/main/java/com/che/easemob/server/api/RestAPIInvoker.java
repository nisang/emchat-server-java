package com.che.easemob.server.api;

import java.io.File;

import com.che.easemob.server.comm.wrapper.BodyWrapper;
import com.che.easemob.server.comm.wrapper.HeaderWrapper;
import com.che.easemob.server.comm.wrapper.QueryWrapper;
import com.che.easemob.server.comm.wrapper.ResponseWrapper;

public interface RestAPIInvoker {
	ResponseWrapper sendRequest(String method, String url, HeaderWrapper header, BodyWrapper body, QueryWrapper query);
	ResponseWrapper uploadFile(String url, HeaderWrapper header, File file);
    ResponseWrapper downloadFile(String url, HeaderWrapper header, QueryWrapper query);
}
