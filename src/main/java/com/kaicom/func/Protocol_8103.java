package com.kaicom.func;


import org.apache.log4j.Logger;

import com.kaicom.protocol.IMessageBody;
import com.kaicom.protocol.JT_0001;
import com.kaicom.protocol.JT_8001;
import com.kaicom.protocol.T808Message;
import com.kaicom.protocol.T808MessageHeader;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;

public class Protocol_8103 implements ProtocolHandler{
	Logger logger = Logger.getLogger(getClass());
	@Override
	public IMessageBody handlerMsg(Object obj,Object service, Channel chn) {
		// TODO Auto-generated method stub
		T808Message msg = (T808Message) obj;
		logger.info(" client:"+this.getClass().getName()+""+msg);
		//sendAckMsg((T808Message)obj, chn);
		JT_0001 ack = new JT_0001();
		ack.setResponseMessageId((short)msg.getMessageType());
		return ack;
	}
	private void sendAckMsg(T808Message obj,Channel chn)
	{
		T808Message tMsg = (T808Message) obj;
		T808MessageHeader header = tMsg.getHeader();
		JT_0001 ack = new JT_0001();
		ack.setResponseMessageId((short)tMsg.getMessageType());
		header.setMessageType(0x0001);
		tMsg.setHeader(header);
		tMsg.setMessageContents(ack);
		byte[] writeByte = tMsg.WriteToBytes();
		ByteBuf tx = Unpooled.copiedBuffer(writeByte);
		chn.writeAndFlush(tx);
	}
	@Override
	public void dealOther(Object obj) {
		// TODO Auto-generated method stub
		
	}
}
