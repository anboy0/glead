package com.kaicom.func;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.kaicom.model.BikeDevice;
import com.kaicom.protocol.IMessageBody;
import com.kaicom.protocol.JT_0100;
import com.kaicom.protocol.JT_8100;
import com.kaicom.protocol.T808Message;
import com.kaicom.protocol.T808MessageHeader;
import com.kaicom.service.BikeDeviceService;
import com.kaicom.tool.Session;
import com.kaicom.tool.SessionManager;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import kaicom.test.sever.NettyServerHandler;

/**
 * 处理终端注册
 * @author cgm
 *
 */

public class Protocol_0100 implements ProtocolHandler{
	
	private static final byte SUCCESS = (byte)0; 
	private static final byte CAR_REGISTER = (byte)1; 
	private static final byte NO_CAR = (byte)2; 
	private static final byte DEVICE_REGISTER = (byte)3; 
	private static final byte NO_DEVICE = (byte)4; 
	//Logger logger = Logger.getLogger(ProtocolHandler.class);
	
	BikeDeviceService bikeDeviceService;
	private SessionManager sessionManager;
	@Override
	public IMessageBody handlerMsg(Object obj,Object service, Channel chn) {
		// TODO Auto-generated method stub
		T808Message msg = (T808Message) obj;
		bikeDeviceService = (BikeDeviceService)service;
		
		//BikeDevice devices= bikeDeviceService.getBikeFromTel("15168325465");
		//logger.info("server:"+this.getClass().getName()+"[设备信息]"+devices);
		logger.info("server:"+this.getClass().getName()+"[车辆手机号]"+msg.getSimNo());

		JT_8100 register = new JT_8100();
		long registerNo = System.currentTimeMillis();
		
		//register.setRegisterNo();
		register.setRegisterResponseMessageSerialNo(msg.getHeader().getMessageSerialNo());
		register.setRegisterNo(""+registerNo);
		sessionManager = SessionManager.getInstance();
		Session dev = sessionManager.findBySessionId(chn.id().asLongText());
		dev.setTerminalPhone(msg.getSimNo());
		if(bikeDeviceService.hasBike(msg.getSimNo())){
			//register.setRegisterResponseResult(CAR_REGISTER);
			register.setRegisterResponseResult(SUCCESS);
			BikeDevice devices= bikeDeviceService.getBikeFromTel(msg.getSimNo());
			dev.setBike(devices);
		} else {
			register.setRegisterResponseResult(SUCCESS);
			BikeDevice info = new BikeDevice();
			JT_0100 _bike = (JT_0100) msg.getMessageContents();
			info.setProvince(_bike.getProvinceId());
			info.setCity(_bike.getCityId());
			info.setVendor(_bike.getManufactureId());
			info.setProductId(_bike.getProductlNo());
			info.setDeviceId(_bike.getDeviceId());
			info.setTel(msg.getSimNo());
			info.setType(_bike.getType());
			info.setBtMac(_bike.getBt_mac());
			info.setIccid(_bike.getIccid());
			info.setChargeStatus((byte)0);
			info.setIsReg((byte)0);
			dev.setBike(info);
		}
		sessionManager.put(chn.id().asLongText(), dev);
		/**
		 * 处理注册应答
		 * 
		 * 数据库中查询该设备是否已注册.并返回响应的数据
		 * 
		 */
		logger.info("server:"+this.getClass().getName()+"[分配鉴权码]"+registerNo);
		return register;
		
	}
	@Override
	public void dealOther(Object obj) {
		// TODO Auto-generated method stub
		
	}

}
