package com.kaicom.func;

import java.util.ArrayList;
import java.util.Date;

import com.kaicom.protocol.IMessageBody;
import com.kaicom.protocol.JT_0001;
import com.kaicom.protocol.JT_0104;
import com.kaicom.protocol.JT_0200;
import com.kaicom.protocol.ParameterItem;
import com.kaicom.protocol.T808Message;
import com.kaicom.protocol.T808MessageHeader;
import com.kaicom.func.ProtocolHandler;
import com.kaicom.tool.Tools;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;

public class Protocol_8106 implements ProtocolHandler{

	@Override
	public IMessageBody handlerMsg(Object obj,Object service, Channel chn) {
		// TODO Auto-generated method stub
		T808Message msg = (T808Message)obj;
		JT_0200 loc = new JT_0200();
		loc.setAlarmFlag(0);
		loc.setStatus(0);
		loc.setAltitude((short)50);
		loc.setLatitude(30260000);
		loc.setLongitude(120190000);
		loc.setSpeed((short)15);
		loc.setCourse((short)175);
		//logger.info("client:"+this.getClass().getName()+" date time "+ Tools.getDateBCDStr(new Date()));
		
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
		
		sendConfigInfo((T808Message)obj,chn);
		//ack.setResponseMessageId((short)msg.getMessageType());
		return loc;
	}
	void sendConfigInfo(T808Message obj,Channel chn)
	{
		T808Message tMsg = (T808Message) obj;
		T808MessageHeader header = tMsg.getHeader();
		//JT_0001 ack = new JT_0001();
		
		JT_0104 msg = new JT_0104();
		ArrayList<ParameterItem> items = new ArrayList<>();
		ParameterItem apn = new ParameterItem();
		apn.setParameterId(0x10);
		apn.setParameterLength((byte)5);
		apn.setParameterValue("cnnet");
		items.add(apn);
		ParameterItem ip = new ParameterItem();
		ip.setParameterId(0x13);
		ip.setParameterLength((byte)11);
		ip.setParameterValue("192.168.1.2");
		items.add(ip);
		ParameterItem port = new ParameterItem();
		port.setParameterId(0x18);
		port.setParameterLength((byte)4);
		port.setParameterValue(60665);
		items.add(port);
		ParameterItem lock_upload_interval = new ParameterItem();
		lock_upload_interval.setParameterId(0x27);
		lock_upload_interval.setParameterLength((byte)4);
		lock_upload_interval.setParameterValue(5);
		items.add(lock_upload_interval);
		ParameterItem lock_can_upload = new ParameterItem();
		lock_can_upload.setParameterId(0x28);
		lock_can_upload.setParameterLength((byte)4);
		lock_can_upload.setParameterValue(2);
		items.add(lock_can_upload);
		ParameterItem upload_interval = new ParameterItem();
		upload_interval.setParameterId(0x29);
		upload_interval.setParameterLength((byte)4);
		upload_interval.setParameterValue(30);
		items.add(upload_interval);
		msg.setParameters(items);
		msg.setParametersCount((byte)items.size());
		
		header.setMessageType(0x0104);
		tMsg.setHeader(header);
		tMsg.setMessageContents(msg);
		byte[] writeByte = tMsg.WriteToBytes();
		ByteBuf tx = Unpooled.copiedBuffer(writeByte);
		chn.writeAndFlush(tx);
	}
	@Override
	public void dealOther(Object obj) {
		// TODO Auto-generated method stub
		
	}
}
