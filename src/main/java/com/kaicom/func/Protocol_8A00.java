package com.kaicom.func;

import java.util.Date;

import com.kaicom.protocol.IMessageBody;
import com.kaicom.protocol.JT_0001;
import com.kaicom.protocol.JT_0200;
import com.kaicom.protocol.T808Message;
import com.kaicom.protocol.T808MessageHeader;
import com.kaicom.tool.Tools;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;

public class Protocol_8A00 implements ProtocolHandler{

	@Override
	public IMessageBody handlerMsg(Object obj,Object service, Channel chn) {
		// TODO Auto-generated method stub
		logger.info("client:"+this.getClass().getName()+" save bt config info and send ack");
		sendAckMsg((T808Message)obj,chn);
		T808Message msg = (T808Message)obj;
		JT_0200 loc = new JT_0200();
		loc.setAlarmFlag(0);
		loc.setStatus(0);
		loc.setAltitude((short)50);
		loc.setLatitude(30260000);
		loc.setLongitude(120190000);
		loc.setSpeed((short)15);
		loc.setCourse((short)175);
		logger.info("client:"+this.getClass().getName()+" date time "+ Tools.getDateBCDStr(new Date()));
		
		loc.setTime(Tools.getDateBCDStr(new Date()));
		loc.setSignal_db((byte)20);
		loc.setGnss((byte)16);
		loc.setUnlock_times(1000);
		loc.setLock_status((byte)1);
		loc.setUpload_status((byte)3);
		loc.setBat_vol((byte)75);
		loc.setMcc((short)460);
		loc.setMnc((short)2);
		loc.setLoc("21198,36222,3;21193,36221,2;21193,34552,6");
		loc.setGsm_version(1000);
		loc.setBt_version(300);
		loc.setLast_charge((short)(500));
		//ack.setResponseMessageId((short)msg.getMessageType());
		return loc;
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
