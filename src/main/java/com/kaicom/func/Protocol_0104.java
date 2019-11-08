package com.kaicom.func;

import com.kaicom.model.BikeDevice;
import com.kaicom.protocol.*;
import com.kaicom.service.BikeDeviceService;
import com.kaicom.tool.Session;
import com.kaicom.tool.SessionManager;

import io.netty.channel.Channel;

import java.util.ArrayList;

/**
 * 终端返回查询信息
 * 
 * @author cgm
 *
 */
public class Protocol_0104 implements ProtocolHandler {

	BikeDeviceService bikeDeviceService;
	private SessionManager sessionManager;

	@Override
	public IMessageBody handlerMsg(Object obj, Object service, Channel chn) {
		// TODO Auto-generated method stub
		// bikeDeviceService = (BikeDeviceService)service;
		sessionManager = SessionManager.getInstance();
		Session session = sessionManager.findBySessionId(chn.id().asLongText());
		T808Message msg = (T808Message) obj;
		JT_0104 par = (JT_0104) msg.getMessageContents();
		if (par.getParametersCount() > (byte)0) {
			BikeDevice dev = session.getBike();
			dev.setApn(par.getApn());
			dev.setPort(((int) par.getPort() ) &0xffff);
			dev.setIp(par.getIp());
			dev.setLockUploadInterval((short) par.getLock_upload_interval());
			dev.setLockCanUpload((short) par.getLock_can_upload());
			dev.setUploadInterval((short) par.getUpload_interval());
			dev.setGsonserEnable(par.getGsonser_enable());
			dev.setGsonserWakeupUploadEnable(par.getGsonser_wakeup_upload_enable());
			session.setBike(dev);
			System.out.println("111111");
			// dev.setLed(led);
			sessionManager.put(chn.id().asLongText(), session);
			//查询完全部参数后 设置参数
			//下面是 鉴权-》读全部参数-》修改参数-》读全部参数-》恢复出厂-》读全部参数 流程中的一部分 add by zengshuai
			/*
            bikeDeviceService = (BikeDeviceService)service;
			BikeDevice devices0= bikeDeviceService.getBikeFromTel("85750216289");
			System.out.println("第一次时是否设置参数"+devices0.getConfigChanged());
			if (devices0 != null) {
				if (devices0.getConfigChanged() != null && devices0.getConfigChanged() == 1) {
					System.out.println("改变的值是"+devices0.getConfigChanged());
					System.out.println("这时先设置终端参数");
					return configParameter(devices0);
				}else  {
					System.out.println("这时查询终端参数");
					return terminalControl();
				}
			}
			*/
		}
		return null;
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
		items.add(apn1);
		System.out.println(apn1);
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
		ParameterItem apn = new ParameterItem();
		apn.setParameterId(0x10);
		apn.setParameterLength((byte) bike.getApn().length());
		apn.setParameterValue(bike.getApn());
		items.add(apn);
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
		ParameterItem ip = new ParameterItem();
		ip.setParameterId(0x13);
		ip.setParameterLength((byte) bike.getIp().length());
		ip.setParameterValue(bike.getIp());
		items.add(ip);
		msg.setParameters(items);
		msg.setParametersCount((byte) items.size());
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
