package com.kaicom.func;

import com.kaicom.model.BikeDevice;
import com.kaicom.protocol.IMessageBody;
import com.kaicom.protocol.JT_0104;
import com.kaicom.protocol.T808Message;
import com.kaicom.service.BikeDeviceService;
import com.kaicom.tool.Session;
import com.kaicom.tool.SessionManager;

import io.netty.channel.Channel;

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
			dev.setPort((short) par.getPort());
			dev.setIp(par.getIp());
			dev.setLockUploadInterval((short) par.getLock_upload_interval());
			dev.setLockCanUpload((short) par.getLock_can_upload());
			dev.setUploadInterval((short) par.getUpload_interval());
			dev.setGsonserEnable(par.getGsonser_enable());
			dev.setGsonserWakeupUploadEnable(par.getGsonser_wakeup_upload_enable());
			session.setBike(dev);
			// dev.setLed(led);
			sessionManager.put(chn.id().asLongText(), session);
		}
		return null;
	}

	@Override
	public void dealOther(Object obj) {
		// TODO Auto-generated method stub

	}

}
