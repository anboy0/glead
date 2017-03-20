package com.kaicom.func;

import org.apache.log4j.Logger;

import com.kaicom.protocol.IMessageBody;

import io.netty.channel.Channel;

public interface ProtocolHandler {
	Logger logger = Logger.getLogger("ProtocolHandler##");
	IMessageBody handlerMsg(Object obj,Object service, Channel chn);
	void dealOther(Object obj);
}
