package com.che.easemob.server.comm.wrapper;

import java.io.IOException;

import com.che.easemob.entity.RequestBody;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ContainerNode;
/**
 * ������
 * 
 * 
 * @author syp
 *
 */

public class MessageWrapper implements BodyWrapper {

	private RequestBody requestBody;
	
	public ContainerNode<?> getBody() {
		
		ObjectMapper mapper = new ObjectMapper();
		ContainerNode cnode = null;
		try {
			String content= mapper.writeValueAsString(requestBody);
			JsonNode node = mapper.readTree(content);
			cnode = (ContainerNode) node;
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cnode;
	}

	public Boolean validate() {
		return true;
	}

	public RequestBody getRequestBody() {
		return requestBody;
	}

	public void setRequestBody(RequestBody requestBody) {
		this.requestBody = requestBody;
	}
	
	public static void main(String[] args) {
		ObjectMapper mapper = new ObjectMapper();
		ContainerNode cnode = null;
		try {
			String content= mapper.writeValueAsString(null);
			JsonNode node = mapper.readTree(content);
			cnode = (ContainerNode) node;
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
