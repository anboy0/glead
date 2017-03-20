package com.kaicom.func;

import java.util.Date;

import com.kaicom.model.BikeDevice;
import com.kaicom.model.BikeLocation;
import com.kaicom.model.BikeVersion;
import com.kaicom.protocol.IMessageBody;
import com.kaicom.protocol.JT_0200;
import com.kaicom.protocol.JT_8001;
import com.kaicom.protocol.JT_8108;
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
 * 终端上报经纬度信息
 * 
 * @author cgm
 *
 */
public class Protocol_0200 implements ProtocolHandler {
	BikeDeviceService bikeDeviceService;
	private SessionManager sessionManager;

	@Override
	public IMessageBody handlerMsg(Object obj, Object service, Channel chn) {
		// TODO Auto-generated method stub
		bikeDeviceService = (BikeDeviceService) service;
		T808Message msg = (T808Message) obj;
		IMessageBody backMsg = null;
		sessionManager = SessionManager.getInstance();
		Session dev = sessionManager.findBySessionId(chn.id().asLongText());
		BikeDevice bike = dev.getBike();
		if(bike ==null)
			return null;
		JT_0200 loc = (JT_0200) msg.getMessageContents();
		
		bike.setLat((double) (loc.getLatitude() / 1000000.0));
		bike.setLng((double) (loc.getLongitude() / 1000000.0));
		bike.setUploadTime(new Date());
		bike.setUnlockTimes(loc.getUnlock_times());
		bike.setLockStatus((short) loc.getLock_status());
		bike.setGsmVersion(loc.getGsm_version());
		bike.setBtVersion(loc.getBt_version());
		bike.setLastCharge(loc.getLast_charge());
		bike.setBatVol(loc.getBat_vol());
		bike.setConfigChanged((byte) 0);
		if (bike.getIsReg() == 1) {
			
			bikeDeviceService.update(bike);
		} else {
			bike.setIsReg((byte) 1);
			bike.setRegTime(new Date());
			bikeDeviceService.save(bike);
		}
		BikeLocation location = new BikeLocation();
		location.setAlt(loc.getAltitude());
		location.setDeviceId(bike.getDeviceId());
		location.setTel(bike.getTel());
		location.setLat((double) (loc.getLatitude() / 1000000.0));
		location.setLng((double) (loc.getLongitude() / 1000000.0));
		location.setBatVol(loc.getBat_vol());
		location.setSpeed(loc.getSpeed());
		location.setCourse(loc.getCourse());
		location.setTime(Tools.strToDate(loc.getTime()));
		location.setSignalDb(loc.getSignal_db());
		location.setGnss(loc.getGnss());
		location.setLockStatus(loc.getLock_status());
		location.setUploadStatus(loc.getUpload_status());
		location.setMcc(loc.getMcc());
		location.setMnc(loc.getMnc());
		location.setLac(loc.getLoc());
		location.setBtVersion(loc.getBt_version());
		location.setGsmVersion(loc.getGsm_version());
		location.setVendor(bike.getVendor());
		location.setProductId(bike.getProductId());
		location.setCreateTime(new Date());
		bikeDeviceService.save(location);
		/**
		 * 处理定位信息及附加信息后判断终端是否要升级;
		 * 
		 * 
		 */
		sendAckMsg((T808Message) obj, chn);
		BikeVersion version = bikeDeviceService.getBikeVersionBy(bike.getVendor(), bike.getProductId());
		if (version != null) {
			if (version.getGsmVersion() != null && version.getGsmVersion() > bike.getGsmVersion()) {
				backMsg = handlerGsmVersion(version);
			} else {
				if (bike.getBtVersion() != null)
					backMsg = handlerBtVersion(version);
			}
		}
		return backMsg;

	}

	private void sendAckMsg(T808Message obj, Channel chn) {
		T808Message tMsg = (T808Message) obj;
		T808MessageHeader header = tMsg.getHeader();
		JT_8001 ack = new JT_8001();
		ack.setResponseMessageId((short) tMsg.getMessageType());
		header.setMessageType(0x8001);
		header.setMessageSerialNo((short) (header.getMessageSerialNo()+1));
		tMsg.setHeader(header);
		tMsg.setMessageContents(ack);
		byte[] writeByte = tMsg.WriteToBytes();
		ByteBuf tx = Unpooled.copiedBuffer(writeByte);
		chn.writeAndFlush(tx);
	}

	IMessageBody handlerGsmVersion(BikeVersion version) {

		JT_8108 update = new JT_8108();
		update.setType((byte) 0);
		update.setUrl(version.getGsmUrl());
		byte[] vendor = version.getVendorId().getBytes();
		update.setVersion("" + version.getGsmVersion());
		update.setVendor(vendor);
		return update;
	}

	IMessageBody handlerBtVersion(BikeVersion version) {
		JT_8108 update = new JT_8108();
		update.setType((byte) 1);
		update.setUrl(version.getBtUrl());
		byte[] vendor = version.getVendorId().getBytes();
		update.setVersion("" + version.getBtVersion());
		update.setVendor(vendor);
		return update;
	}

	@Override
	public void dealOther(Object obj) {
		// TODO Auto-generated method stub

	}
}
