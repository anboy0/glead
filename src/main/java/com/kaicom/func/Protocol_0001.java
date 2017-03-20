package com.kaicom.func;

import java.security.acl.Acl;

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

/**
 * 处理服务器接收到的应答
 * @author cgm
 *
 */

public class Protocol_0001 implements ProtocolHandler{
	
	BikeDeviceService bikeDeviceService;
	private SessionManager sessionManager;
	@Override
	public IMessageBody handlerMsg(Object obj,Object service, Channel chn) {
		// TODO Auto-generated method stub
		T808Message msg = (T808Message)obj;
		JT_0001 ack =(JT_0001) msg.getMessageContents();
		bikeDeviceService = (BikeDeviceService)service;
		logger.info("server "+this.getClass().getName()+""+ack);
		switch(ack.getResponseMessageId()&0xffff)
		{
		case 0x8103:
			sessionManager = SessionManager.getInstance();
			Session dev = sessionManager.findBySessionId(chn.id().asLongText());
			BikeDevice devices= bikeDeviceService.getBikeFromTel(msg.getSimNo());
			
			return configBt(devices);
		case 0x8108:
			logger.info("server "+this.getClass().getName()+" client recevie update info");
			break;
		case 0x8a00:
			logger.info("server "+this.getClass().getName()+" wait for location info");
		}
		return null;
	}
	/**
	 * 处理配置蓝牙密码及秘钥信息
	 * @return
	 */
	private IMessageBody configBt(BikeDevice devices){
		JT_8A00 btconfig = new JT_8A00();
		//byte[] pwd = {0x12,0x34,0x56,0x78,(byte)0x9a,0x11};
		//byte[] keys = {0x12,0x34,0x56,0x78,(byte)0x9a,11,1,2,3,4,5,6,7,8,9,0};
		btconfig.setBtPwd(Tools.HexString2Bytes(devices.getBtPwd()));
		btconfig.setBtKey(Tools.HexString2Bytes(devices.getBtKey()));
		return btconfig;
	}
	@Override
	public void dealOther(Object obj) {
		// TODO Auto-generated method stub
		
	}
}
