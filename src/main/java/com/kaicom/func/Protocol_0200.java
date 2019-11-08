package com.kaicom.func;

import java.util.ArrayList;
import java.util.Date;

import org.aspectj.weaver.reflect.ReflectionBasedResolvedMemberImpl;

import com.kaicom.model.BikeDevice;
import com.kaicom.model.BikeLocation;
import com.kaicom.model.BikeVersion;
import com.kaicom.protocol.IMessageBody;
import com.kaicom.protocol.JT_0200;
import com.kaicom.protocol.JT_8001;
import com.kaicom.protocol.JT_8103;
import com.kaicom.protocol.JT_8108;
import com.kaicom.protocol.ParameterItem;
import com.kaicom.protocol.T808Message;
import com.kaicom.protocol.T808MessageHeader;
import com.kaicom.service.BikeDeviceService;
import com.kaicom.tool.GPSUtil;
import com.kaicom.tool.Session;
import com.kaicom.tool.SessionManager;
import com.kaicom.tool.Tools;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import kaicom.activeMq.DispatchMqMgr;
import kaicom.activeMq.LocationMqMgr;

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
		boolean configChanged = false;
		BikeDevice bike2 = null;
		String led_conf = null;
		bikeDeviceService = (BikeDeviceService) service;
		T808Message msg = (T808Message) obj;
		IMessageBody backMsg = null;
		sessionManager = SessionManager.getInstance();
		Session dev = sessionManager.findBySessionId(chn.id().asLongText());
		BikeDevice bike = dev.getBike();
		JT_0200 loc = (JT_0200) msg.getMessageContents();
		double[] loc_info = { 0.0, 0.0 };
		if (loc.getLongitude() != 0) {
			double lng = loc.getLongitude() / 1000000.0;
			double lat = loc.getLatitude() / 1000000.0;
			loc_info = GPSUtil.gps84_To_Gcj02(lat, lng);
		}
		if (bike == null) {
			return null;
		}

		bike2 = bikeDeviceService.getBikeFromTel(msg.getSimNo());

		if (bike2 != null && bike2.getConfigChanged() == 1) {
			configChanged = true;
			led_conf = bike2.getLed();
			bike2.setLat(loc_info[0]);
			bike2.setLng(loc_info[1]);
			bike2.setUploadTime(new Date());
			bike2.setUnlockTimes(loc.getUnlock_times());
			bike2.setLockStatus((short) loc.getLock_status());
			bike2.setGsmVersion(loc.getGsm_version());
			bike2.setBtVersion(loc.getBt_version());
			bike2.setLastCharge(loc.getLast_charge());
			bike2.setBatVol(loc.getBat_vol());
			bike2.setConfigChanged((byte) 0);
			bike2.setStatus((byte) 1);
			bike2.setLed("");
			if (bike2.getIsReg() == 1) {
				logger.info("server:" + this.getClass().getName() + "update Device info");
				bikeDeviceService.update(bike2);
			} else {
				bike2.setIsReg((byte) 1);
				bike2.setRegTime(new Date());
				logger.info("server:" + this.getClass().getName() + "insert Device info");
				bikeDeviceService.save(bike2);
				bike2 = bikeDeviceService.getBikeFromTel(msg.getSimNo());
				dev.setBike(bike2);

				sessionManager.put(chn.id().asLongText(), dev);
			}
		} else {
			bike.setLat(loc_info[0]);
			bike.setLng(loc_info[1]);
			bike.setUploadTime(new Date());
			bike.setUnlockTimes(loc.getUnlock_times());
			bike.setLockStatus((short) loc.getLock_status());
			bike.setGsmVersion(loc.getGsm_version());
			bike.setBtVersion(loc.getBt_version());
			bike.setLastCharge(loc.getLast_charge());
			bike.setBatVol(loc.getBat_vol());
			bike.setConfigChanged((byte) 0);
			bike.setStatus((byte) 1);
			if (bike.getIsReg() == 1) {
				logger.info("server:" + this.getClass().getName() + "update Device info");
				bikeDeviceService.update(bike);
			} else {
				bike.setIsReg((byte) 1);
				bike.setRegTime(new Date());
				logger.info("server:" + this.getClass().getName() + "insert Device info");
				bikeDeviceService.save(bike);
				bike = bikeDeviceService.getBikeFromTel(msg.getSimNo());
				dev.setBike(bike);

				sessionManager.put(chn.id().asLongText(), dev);
			}
		}

		BikeLocation location = new BikeLocation();
		location.setAlt(loc.getAltitude());
		location.setDeviceId(bike.getDeviceId());
		location.setTel(bike.getTel());
		location.setLat(loc_info[0]);
		location.setLng(loc_info[1]);
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
		location.setAlarm(Tools.ToHexString(loc.getAlarmFlag()));
		location.setCn(loc.getCn());
		location.setGpsStatus(loc.getStatus());
		location.setCreateTime(new Date());
		bikeDeviceService.save(location);

		/**
		 * 处理定位信息及附加信息后判断终端是否要升级;
		 * 
		 * 
		 */
		sendAckMsg((T808Message) obj, chn);

		/**
		 * 发送消息队列 对接 监控平台
		 */
//		sendToDispatch(msg, loc);
		/**
		 * 
		 * 先异常处理队列
		 * 
		 */
//		sendToLocation(dev.getBike(), location);

		if (configChanged) {
			bike2.setLed(led_conf);
			configChanged = false;
//			return configParameter(bike2);
			return null;
		} else {
			BikeVersion version = bikeDeviceService.getBikeVersionBy(bike.getVendor(), bike.getProductId());
			if (version != null) {
				if (version.getGsmVersion() != null && version.getGsmVersion() > bike.getGsmVersion()) {
					backMsg = handlerGsmVersion(version);
				} else {
					if (bike.getBtVersion() != null && version.getBtVersion() > bike.getBtVersion())
						backMsg = handlerBtVersion(version);
				}
			}
			return backMsg;
		}

	}

	private void sendToDispatch(T808Message obj, JT_0200 jt) {
		T808Message tMsg = (T808Message) obj;
		T808MessageHeader header = tMsg.getHeader();
		header.setMessageType(0x0200);
		tMsg.setHeader(header);
		Date _date = Tools.strToDate(jt.getTime());
		jt.setTime(Tools.getDateBCDStr(_date));
		tMsg.setMessageContents(jt);
		byte[] writeByte = tMsg.WriteToBytes();
		String dispatch = Tools.ToHexString(writeByte);
		DispatchMqMgr.sendMqMsg(dispatch);
	}

	private void sendToLocation(BikeDevice dev, BikeLocation loc) {
		if (dev.getId() == null | dev.getId() == 0) {
			return;
		}
		LocationMqMgr.sendMqMsg(dev.getId(), loc.getLng(), loc.getLat(), loc.getBatVol());
	}

	private void sendAckMsg(T808Message obj, Channel chn) {
		T808Message tMsg = (T808Message) obj;
		T808MessageHeader header = tMsg.getHeader();
		JT_8001 ack = new JT_8001();
		ack.setResponseMessageId((short) tMsg.getMessageType());
		header.setMessageType(0x8001);
		// header.setMessageSerialNo(header.getMessageSerialNo()+1));
		tMsg.setHeader(header);
		ack.setResponseMessageSerialNo(header.getMessageSerialNo());
		tMsg.setMessageContents(ack);
		byte[] writeByte = tMsg.WriteToBytes();
		System.out.println("1111111");
		ByteBuf tx = Unpooled.copiedBuffer(writeByte);
		System.out.println("2222222");
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

	private IMessageBody configParameter(BikeDevice bike) {
		JT_8103 msg = new JT_8103();
		ArrayList<ParameterItem> items = new ArrayList<>();
		ParameterItem apn1 = new ParameterItem();
		apn1.setParameterId(0x0001);
		apn1.setParameterLength((byte)1);
		apn1.setParameterValue(70);
		items.add(apn1);
//		ParameterItem apn = new ParameterItem();
//		apn.setParameterId(0x10);
//		apn.setParameterLength((byte) bike.getApn().length());
//		apn.setParameterValue(bike.getApn());
//		items.add(apn);
//		ParameterItem ip = new ParameterItem();
//		ip.setParameterId(0x13);
//		ip.setParameterLength((byte) bike.getIp().length());
//		ip.setParameterValue(bike.getIp());
//		items.add(ip);
//		ParameterItem port = new ParameterItem();
//		port.setParameterId(0x18);
//		port.setParameterLength((byte) 4);
//		port.setParameterValue(bike.getPort());
//		items.add(port);
//		ParameterItem lock_upload_interval = new ParameterItem();
//		lock_upload_interval.setParameterId(0x27);
//		lock_upload_interval.setParameterLength((byte) 4);
//		lock_upload_interval.setParameterValue(bike.getLockUploadInterval());
//		items.add(lock_upload_interval);
//		ParameterItem lock_can_upload = new ParameterItem();
//		lock_can_upload.setParameterId(0x28);
//		lock_can_upload.setParameterLength((byte) 4);
//		lock_can_upload.setParameterValue(bike.getLockCanUpload());
//		items.add(lock_can_upload);
//		ParameterItem upload_interval = new ParameterItem();
//		upload_interval.setParameterId(0x29);
//		upload_interval.setParameterLength((byte) 4);
//		upload_interval.setParameterValue(bike.getUploadInterval());
//		items.add(upload_interval);
//		ParameterItem gsonsor = new ParameterItem();
//		gsonsor.setParameterId(0xe000);
//		gsonsor.setParameterLength((byte) 1);
//		gsonsor.setParameterValue(bike.getGsonserEnable());
//		items.add(gsonsor);
//		ParameterItem gsonser_awake = new ParameterItem();
//		gsonser_awake.setParameterId(0xe001);
//		gsonser_awake.setParameterLength((byte) 1);
//		gsonser_awake.setParameterValue(bike.getGsonserWakeupUploadEnable());
//		items.add(gsonser_awake);
//		if (bike.getTts() != null && bike.getTts().length() > 0) {
//			ParameterItem tts = new ParameterItem();
//			tts.setParameterId(0xF001);
//			// tts.setParameterLength((byte)(bike.getTts().length()/2));
//			tts.setParameterValue(bike.getTts());
//			items.add(tts);
//		}
//		if (bike.getLed() != null && bike.getLed().length() > 0) {
//			ParameterItem tts = new ParameterItem();
//			tts.setParameterId(0xF002);
//			// tts.setParameterLength((byte)(bike.getLed().length()/2));
//			tts.setParameterValue(bike.getLed());
//			items.add(tts);
//		}

		msg.setParameters(items);
		msg.setParametersCount((byte) items.size());
		return msg;
	}

	@Override
	public void dealOther(Object obj) {
		// TODO Auto-generated method stub

	}
}
