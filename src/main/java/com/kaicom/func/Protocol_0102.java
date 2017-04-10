package com.kaicom.func;

import java.util.ArrayList;

import com.kaicom.model.BikeDevice;
import com.kaicom.protocol.IMessageBody;
import com.kaicom.protocol.JT_8001;
import com.kaicom.protocol.JT_8103;
import com.kaicom.protocol.JT_8106;
import com.kaicom.protocol.ParameterItem;
import com.kaicom.protocol.T808Message;
import com.kaicom.protocol.T808MessageHeader;
import com.kaicom.service.BikeDeviceService;
import com.kaicom.tool.Session;
import com.kaicom.tool.SessionManager;
import com.kaicom.tool.StringUtil;
import com.kaicom.tool.Tools;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;

/**
 * 服务器响应 终端发起的鉴权请求
 * 
 * 回复 如有配置信息修改,则发布配置信息数据,无配置信息修改 则查询配置信息.
 * 
 * @author cgm
 *
 */

public class Protocol_0102 implements ProtocolHandler {

	BikeDeviceService bikeDeviceService;
	private SessionManager sessionManager;

	@Override
	public IMessageBody handlerMsg(Object obj, Object service, Channel chn) {
		// TODO Auto-generated method stub
		// 判断是否有配置信息修改 联系数据库操作
		sendAckMsg((T808Message) obj, chn);
		// 先发送应答信息.然后再发送配置或查询信息;
		// bikeDeviceService = (BikeDeviceService)service;
		sessionManager = SessionManager.getInstance();
		Session dev = sessionManager.findBySessionId(chn.id().asLongText());

		logger.info("应答信息:{}" + dev);
		BikeDevice bike = dev.getBike();

		IMessageBody msg = null;
		if (bike != null) {
			if (bike.getConfigChanged() != null && bike.getConfigChanged() == 1) {
				msg = configParameter(bike);
			} else {
				msg = searchParameter();
			}
		}
		// sessionManager.put(chn.id().asLongText(), dev);

		return msg;
	}

	/**
	 * 服务器设置设备参数
	 * 
	 * @return
	 */

	private IMessageBody configParameter(BikeDevice bike) {
		JT_8103 msg = new JT_8103();
		ArrayList<ParameterItem> items = new ArrayList<>();
		ParameterItem apn = new ParameterItem();
		apn.setParameterId(0x10);
		apn.setParameterLength((byte) bike.getApn().length());
		apn.setParameterValue(bike.getApn());
		items.add(apn);
		ParameterItem ip = new ParameterItem();
		ip.setParameterId(0x13);
		ip.setParameterLength((byte) bike.getIp().length());
		ip.setParameterValue(bike.getIp());
		items.add(ip);
		ParameterItem port = new ParameterItem();
		port.setParameterId(0x18);
		port.setParameterLength((byte) 4);
		port.setParameterValue(bike.getPort());
		items.add(port);
		ParameterItem lock_upload_interval = new ParameterItem();
		lock_upload_interval.setParameterId(0x27);
		lock_upload_interval.setParameterLength((byte) 4);
		lock_upload_interval.setParameterValue(bike.getLockUploadInterval());
		items.add(lock_upload_interval);
		ParameterItem lock_can_upload = new ParameterItem();
		lock_can_upload.setParameterId(0x28);
		lock_can_upload.setParameterLength((byte) 4);
		lock_can_upload.setParameterValue(bike.getLockCanUpload());
		items.add(lock_can_upload);
		ParameterItem upload_interval = new ParameterItem();
		upload_interval.setParameterId(0x29);
		upload_interval.setParameterLength((byte) 4);
		upload_interval.setParameterValue(bike.getUploadInterval());
		items.add(upload_interval);
		ParameterItem gsonsor = new ParameterItem();
		gsonsor.setParameterId(0xe000);
		gsonsor.setParameterLength((byte) 1);
		gsonsor.setParameterValue(bike.getGsonserEnable());
		items.add(gsonsor);
		ParameterItem gsonser_awake = new ParameterItem();
		gsonser_awake.setParameterId(0xe001);
		gsonser_awake.setParameterLength((byte) 1);
		gsonser_awake.setParameterValue(bike.getGsonserWakeupUploadEnable());
		items.add(gsonser_awake);
		if(bike.getTts()!=null && bike.getTts().length()>0)
		{
			ParameterItem tts = new ParameterItem();
			tts.setParameterId(0xF001);
			tts.setParameterLength((byte)(bike.getTts().length()/2));
			tts.setParameterValue(Tools.HexString2Bytes(bike.getTts()));
			items.add(tts);
		}
		if(bike.getLed()!=null && bike.getLed().length()>0)
		{
			ParameterItem tts = new ParameterItem();
			tts.setParameterId(0xF002);
			tts.setParameterLength((byte)(bike.getLed().length()/2));
			tts.setParameterValue(Tools.HexString2Bytes(bike.getLed()));
			items.add(tts);
		}
		
		msg.setParameters(items);
		msg.setParametersCount((byte) items.size());
		return msg;
	}

	private IMessageBody searchParameter() {
		JT_8106 msg = new JT_8106();
		ArrayList<Integer> items = new ArrayList<>();
		items.add(0x10);
		items.add(0x13);
		items.add(0x18);
		items.add(0x27);
		items.add(0x28);
		items.add(0x29);

		items.add(0xe000);
		items.add(0xe001);
		/*
		 * items.add(0xf000); items.add(0xf001);
		 */
		msg.setParametersCount((byte) items.size());
		msg.setParametersIDs(items);
		return msg;
	}

	private void sendAckMsg(T808Message obj, Channel chn) {
		T808Message tMsg = (T808Message) obj;
		T808MessageHeader header = tMsg.getHeader();
		JT_8001 ack = new JT_8001();
		ack.setResponseMessageId((short) tMsg.getMessageType());
		header.setMessageType(0x8001);
		ack.setResponseMessageSerialNo(header.getMessageSerialNo());
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
