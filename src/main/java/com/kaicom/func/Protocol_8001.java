package com.kaicom.func;

import com.kaicom.protocol.IMessageBody;
import com.kaicom.protocol.JT_8001;
import com.kaicom.protocol.T808Message;

import io.netty.channel.Channel;

public class Protocol_8001 implements ProtocolHandler{

	@Override
	public IMessageBody handlerMsg(Object obj,Object service, Channel chn) {
		T808Message msg = (T808Message)obj;
		JT_8001 ack =(JT_8001) msg.getMessageContents();
		logger.info("client:"+this.getClass().getName()+""+ack);
		return null;
	}

	@Override
	public void dealOther(Object obj) {
		// TODO Auto-generated method stub
		
	}

}
