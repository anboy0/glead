package com.kaicom.func;

import java.util.Date;

import com.kaicom.model.BikeDevice;
import com.kaicom.protocol.IMessageBody;
import com.kaicom.protocol.JT_0104;
import com.kaicom.protocol.JT_0200;
import com.kaicom.protocol.JT_0900;
import com.kaicom.protocol.JT_8001;
import com.kaicom.protocol.T808Message;
import com.kaicom.protocol.T808MessageHeader;
import com.kaicom.service.BikeDeviceService;
import com.kaicom.tool.Session;
import com.kaicom.tool.SessionManager;
import com.kaicom.tool.Tools;

import io.netty.channel.Channel;

public class Protocol_0900 implements ProtocolHandler{
	BikeDeviceService bikeDeviceService;
	private SessionManager sessionManager;
	@Override
	public IMessageBody handlerMsg(Object obj, Object service, Channel chn) {
		// TODO Auto-generated method stub
		
		bikeDeviceService = (BikeDeviceService) service;
		sessionManager = SessionManager.getInstance();
		Session dev = sessionManager.findBySessionId(chn.id().asLongText());
		BikeDevice bike = dev.getBike();
		
		
		T808Message tMsg = (T808Message)obj;
		T808MessageHeader header = tMsg.getHeader();
		JT_0900 par = (JT_0900) tMsg.getMessageContents();
		
		byte type =  par.getMessageType();
		byte[] datas = par.getMessageContent(); 
		StringBuffer sb = new StringBuffer();
		sb.append(Tools.ToHexString(type));
		sb.append(Tools.ToHexString(datas));
		bike.setReceive(sb.toString());
		if(bike ==null)
			return null;
		
		if (bike.getIsReg() == 1) {
			
			bikeDeviceService.update(bike);
		} 
		JT_8001 ack = new JT_8001();
		
		ack.setResponseMessageId((short) tMsg.getMessageType());
		header.setMessageType(0x8001);
		ack.setResponseMessageSerialNo(header.getMessageSerialNo());
		tMsg.setHeader(header);
		tMsg.setMessageContents(ack);
		
		return ack;
	}

	@Override
	public void dealOther(Object obj) {
		// TODO Auto-generated method stub
		
	}

}
