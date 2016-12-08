package com.che.easemob.server.comm.wrapper;

import com.fasterxml.jackson.databind.node.ContainerNode;

public interface BodyWrapper {
	ContainerNode<?> getBody();
	Boolean validate();
}
