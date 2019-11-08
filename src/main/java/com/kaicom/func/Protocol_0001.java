package com.kaicom.func;

import java.io.UnsupportedEncodingException;
import java.security.acl.Acl;
import java.util.ArrayList;

import com.kaicom.model.BikeDevice;
import com.kaicom.protocol.*;
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
        IMessageBody msg2 = null;
		switch(ack.getResponseMessageId()&0xffff)
		{

		case 0x8104:
			sessionManager = SessionManager.getInstance();
			BikeDevice devices0= bikeDeviceService.getBikeFromTel(msg.getSimNo());
			if (devices0 != null) {
				if (devices0.getConfigChanged() != null && devices0.getConfigChanged() == 1) {
                    msg2 = configParameter(devices0);
                    return msg2;
				} else {
                    return terminalControl();
                }

			}

		case 0x8103:
			sessionManager = SessionManager.getInstance();
			//Session dev = sessionManager.findBySessionId(chn.id().asLongText());
			BikeDevice devices= bikeDeviceService.getBikeFromTel(msg.getSimNo());
            if (devices != null) {
                return searchAllParameter();
            }

        case 0x8105:
            sessionManager = SessionManager.getInstance();
            //Session dev = sessionManager.findBySessionId(chn.id().asLongText());
            BikeDevice devices1= bikeDeviceService.getBikeFromTel(msg.getSimNo());
            if (devices1 != null) {
                return searchAllParameter();
            }
		
		case 0x8a00:
			//logger.info("server "+this.getClass().getName()+" wait for location info");
			
			BikeDevice devices2= bikeDeviceService.getBikeFromTel(msg.getSimNo());
			if(devices2.getTrans()!=null) {
				return sendTrans(devices2);
			}
			logger.info("server "+this.getClass().getName()+" not  config info wait for location info");
			break ;
		case 0x8108:
			logger.info("server "+this.getClass().getName()+" client recevie update info");
			break;
		case 0x8900:
			logger.info("server "+this.getClass().getName()+" trans over wait for location info");
		}
		
		return null;
	}
	private IMessageBody sendTrans(BikeDevice devices){
		
		
		if(devices.getTrans()!=null && devices.getTrans().length()>0) {
			JT_8900 trans = new JT_8900();
			byte[] dats;
			dats = Tools.HexString2Bytes(devices.getTrans());
			byte[] _dat = new byte[dats.length - 1];

			System.arraycopy(dats, 1, _dat, 0, _dat.length);
			trans.setMessageType(dats[0]);
			trans.setMessageContent(_dat);
			return trans;
			
		}
		/*btconfig.setBtPwd(devices.getBtPwd().getBytes());
		btconfig.setBtKey(devices.getBtKey().getBytes());*/
		return null;
	}
	/**
	 * 处理配置蓝牙密码及秘钥信息
	 * @return
	 */
	private IMessageBody configBt(BikeDevice devices){
		JT_8A00 btconfig = new JT_8A00();
		//byte[] pwd = {0x12,0x34,0x56,0x78,(byte)0x9a,0x11};
		//byte[] keys = {0x12,0x34,0x56,0x78,(byte)0x9a,11,1,2,3,4,5,6,7,8,9,0}
		//logger.info("server "
		btconfig.setBtPwd(devices.getBtPwd().getBytes());
		btconfig.setBtKey(devices.getBtKey().getBytes());
		return btconfig;
	}
	@Override
	public void dealOther(Object obj) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 服务器设置设备参数
	 *
	 * @return
	 */

	private IMessageBody configParameter(BikeDevice bike) {
		JT_8103 msg = new JT_8103();
		ArrayList<ParameterItem> items = new ArrayList<>();
		ParameterItem apn1 = new ParameterItem();
		apn1.setParameterId(0x0001);
		apn1.setParameterLength((byte)1);
		apn1.setParameterValue(70);
//		items.add(apn1);
//		ParameterItem apn2 = new ParameterItem();
//		apn2.setParameterId(0x0002);
//		apn2.setParameterLength((byte)1);
//		apn2.setParameterValue(10);
//		items.add(apn2);
//		ParameterItem apn3 = new ParameterItem();
//		apn3.setParameterId(0x0003);
//		apn3.setParameterLength((byte)1);
//		apn3.setParameterValue(10);
//		items.add(apn3);
//
//		ParameterItem apn = new ParameterItem();
//		apn.setParameterId(0x10);
//		apn.setParameterLength((byte) bike.getApn().length());
//		apn.setParameterValue(bike.getApn());
//		items.add(apn);
//		ParameterItem apn11 = new ParameterItem();
//		apn11.setParameterId(0x11);
//		apn11.setParameterLength((byte) bike.getLed().length());
//		apn11.setParameterValue(bike.getLed());
//		items.add(apn11);
//		ParameterItem apn12 = new ParameterItem();
//		apn12.setParameterId(0x12);
//		apn12.setParameterLength((byte) bike.getLed().length());
//		apn12.setParameterValue(bike.getLed());
//		items.add(apn12);
//		ParameterItem ip = new ParameterItem();
//		ip.setParameterId(0x13);
//		ip.setParameterLength((byte) bike.getIp().length());
//		ip.setParameterValue(bike.getIp());
//		items.add(ip);
		msg.setParameters(items);
		msg.setParametersCount((byte) items.size());
		return msg;
	}

    private IMessageBody searchAllParameter() {
        JT_8104 msg = new JT_8104();

        return msg;
    }

    /**
     * 终端控制
     * @return
     */
    private IMessageBody terminalControl(){
        JT_8105 msg = new JT_8105();
        msg.setCommandWord((byte)5);
        return msg;
    }
}
