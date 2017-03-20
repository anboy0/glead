package com.kaicom.func;

import com.kaicom.model.BikeDevice;
import com.kaicom.protocol.IMessageBody;
import com.kaicom.protocol.JT_0001;
import com.kaicom.protocol.JT_8001;
import com.kaicom.protocol.JT_8A00;
import com.kaicom.protocol.T808Message;
import com.kaicom.protocol.T808MessageHeader;
import com.kaicom.service.BikeDeviceService;
import com.kaicom.tool.Session;
import com.kaicom.tool.SessionManager;
import com.kaicom.tool.Tools;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;

public class Protocol_0002 implements ProtocolHandler{
	
	BikeDeviceService bikeDeviceService;
	private SessionManager sessionManager;
	@Override
	public IMessageBody handlerMsg(Object obj,Object service, Channel chn) {
		// TODO Auto-generated method stub
		T808Message tMsg = (T808Message)obj;
		T808MessageHeader header = tMsg.getHeader();
		JT_8001 ack = new JT_8001();
		ack.setResponseMessageId((short) tMsg.getMessageType());
		header.setMessageType(0x8001);
		header.setMessageSerialNo((short) (header.getMessageSerialNo()+1));
		tMsg.setHeader(header);
		tMsg.setMessageContents(ack);
		
		return ack;
	}
	@Override
	public void dealOther(Object obj) {
		// TODO Auto-generated method stub
		
	}
}
