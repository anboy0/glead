package com.kaicom.func;

import java.util.ArrayList;

import com.kaicom.model.BikeDevice;
import com.kaicom.protocol.*;
import com.kaicom.service.BikeDeviceService;
import com.kaicom.tool.Session;
import com.kaicom.tool.SessionManager;
import com.kaicom.tool.StringUtil;
import com.kaicom.tool.Tools;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import org.apache.commons.lang3.StringUtils;

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

	private void checkAuth(T808Message obj,Channel chn) {
		T808Message msg = (T808Message) obj;
		//sessionManager = SessionManager.getInstance();
		//Session dev = sessionManager.findBySessionId(chn.id().asLongText());
		//dev.setTerminalPhone(msg.getSimNo());
		System.out.println("1111111111111"+msg.getMessageContents().toString());
		String str = msg.getMessageContents().toString();
		System.out.println(str);
		System.out.println(str.substring(str.indexOf("：")+1));
		String ss = str.substring(str.indexOf("：")+1);
		if(bikeDeviceService.hasBike(msg.getSimNo())){
			BikeDevice bikeDevice = bikeDeviceService.getBikeFromTel(msg.getSimNo());
			if(1==1 || StringUtils.equals(ss,bikeDevice.getGroupIds())){
				Session dev = sessionManager.findBySessionId(chn.id().asLongText());
				dev.setBike(bikeDevice);
				sessionManager.put(chn.id().asLongText(), dev);
				sendAckMsg((T808Message) obj, 0,chn);
				logger.info("server:"+this.getClass().getName()+"old Device:"+msg.getSimNo());
			} else {
				sendAckMsg((T808Message) obj, 1,chn);
				logger.info("server:"+this.getClass().getName()+"New Device:"+msg.getSimNo()+"鉴权码错误");
			}
		} else {
			sendAckMsg((T808Message) obj, 1,chn);
			logger.info("server:"+this.getClass().getName()+"New Device:"+msg.getSimNo());
		}
		
	}
	@Override
	public IMessageBody handlerMsg(Object obj, Object service, Channel chn) {
		// TODO Auto-generated method stub
		// 判断是否有配置信息修改 联系数据库操作
		
		// 先发送应答信息.然后再发送配置或查询信息;
		bikeDeviceService = (BikeDeviceService)service;
		
		
		sessionManager = SessionManager.getInstance();
		checkAuth((T808Message)obj,chn);
		Session dev = sessionManager.findBySessionId(chn.id().asLongText());

		//logger.info("应答信息:{}" + dev);
		BikeDevice bike = dev.getBike();

		IMessageBody msg = null;
		if (bike != null) {
			if (bike.getConfigChanged() != null && bike.getConfigChanged() == 1) {
				msg = configParameter(bike);
			} else
			{
//				msg = searchAllParameter();
				msg = configBt(bike);
//				msg = terminalControl();
//				msg = textDown();
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
		ParameterItem apn1 = new ParameterItem();
		apn1.setParameterId(0x0001);
		apn1.setParameterLength((byte)1);
		apn1.setParameterValue(60);
		items.add(apn1);
		ParameterItem apn2 = new ParameterItem();
		apn2.setParameterId(0x0002);
		apn2.setParameterLength((byte)1);
		apn2.setParameterValue(10);
		items.add(apn2);
		ParameterItem apn3 = new ParameterItem();
		apn3.setParameterId(0x0003);
		apn3.setParameterLength((byte)1);
		apn3.setParameterValue(10);
		items.add(apn3);

		ParameterItem apn = new ParameterItem();
		apn.setParameterId(0x10);
		apn.setParameterLength((byte) bike.getApn().length());
		apn.setParameterValue(bike.getApn());
		items.add(apn);
		ParameterItem apn11 = new ParameterItem();
		apn11.setParameterId(0x11);
		apn11.setParameterLength((byte) bike.getLed().length());
		apn11.setParameterValue(bike.getLed());
		items.add(apn11);
		ParameterItem apn12 = new ParameterItem();
		apn12.setParameterId(0x12);
		apn12.setParameterLength((byte) bike.getLed().length());
		apn12.setParameterValue(bike.getLed());
		items.add(apn12);
		ParameterItem ip = new ParameterItem();
		ip.setParameterId(0x13);
		ip.setParameterLength((byte) bike.getIp().length());
		ip.setParameterValue(bike.getIp());
		items.add(ip);
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
//		if(bike.getTts()!=null && bike.getTts().length()>0)
//		{
//			ParameterItem tts = new ParameterItem();
//			tts.setParameterId(0xF001);
//			//System.out.println(bike.getTts());
//			//tts.setParameterLength((byte)(bike.getTts().length()/2));
//			tts.setParameterValue(bike.getTts());
//			//System.out.println(Tools.HexString2Bytes(bike.getTts()));
//			items.add(tts);
//		}
//		if(bike.getLed()!=null && bike.getLed().length()>0)
//		{
//			ParameterItem tts = new ParameterItem();
//			tts.setParameterId(0xF002);
//			//tts.setParameterLength((byte)(bike.getLed().length()/2));
//
//			tts.setParameterValue(bike.getLed());
//			items.add(tts);
//		}
		if(bike.getBtKey()!=null && bike.getBtKey().length()>0)
		{
			ParameterItem tts = new ParameterItem();
			tts.setParameterId(0xF000);
			tts.setParameterValue(bike.getBtKey());
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

	private IMessageBody searchAllParameter() {
		JT_8104 msg = new JT_8104();

		return msg;
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

	/**
	 * 终端控制
	 * @return
	 */
	private IMessageBody terminalControl(){
		JT_8105 msg = new JT_8105();
//		msg.setCommandWord((byte)1);
//		URL 地址;拨号点名称;拨号用户名;拨号密码;地址;TCP 端口;UDP 端口;制造商 ID; 硬件版本;固件版本; 连接到指定服务器时限
//		msg.setCommandParameters("http://118.31.3.102:50000/files/update.bin;;;;server.natappfree.cc;32803;;;1;1;2");
//		msg.setCommandParameters(";;;;;;;00123;;;2");

//		msg.setCommandWord((byte)12);
//		System.out.println("16进制转换成为string类型字符串"+hexStringToString("00200010003000200010003000"));
//		msg.setCommandParameters(hexStringToString("00200010003000200010003000"));//00200010003000200010003000
		msg.setCommandWord((byte)4);
//		msg.setCommandParameters("http://118.31.3.102:50000/files/update.bin");
//		msg.setCommandParameters("http://118.31.3.102:50000/files/update.bin");
		//http%3a%2f%2f118.31.3.102%3a50000%2ffiles%2fupdate.bin
//		System.out.println("字符串转换成为16进制"+str2HexStr("http://118.31.3.102:50000/files/update.bin"));
//		System.out.println("字符串转换成为16进制"+strTo16("http://118.31.3.102:50000/files/update.bin"));
//		System.out.println(hexStringToString("687474703A2F2F3131382E33312E332E3130323A35303030302F66696C65732F7570646174652E62696E"));

		return msg;
	}

	/**
	 * 16进制转换成为string类型字符串
	 * @param s
	 * @return
	 */
	public static String hexStringToString(String s) {
		if (s == null || s.equals("")) {
			return null;
		}
		s = s.replace(" ", "");
		byte[] baKeyword = new byte[s.length() / 2];
		for (int i = 0; i < baKeyword.length; i++) {
			try {
				baKeyword[i] = (byte) (0xff & Integer.parseInt(s.substring(i * 2, i * 2 + 2), 16));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		try {
			s = new String(baKeyword, "GBK");
			new String();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return s;
	}

	/**
	 * 字符串转换成为16进制(无需Unicode编码)
	 * @param str
	 * @return
	 */
	public static String str2HexStr(String str) {
		char[] chars = "0123456789ABCDEF".toCharArray();
		StringBuilder sb = new StringBuilder("");
		byte[] bs = str.getBytes();
		int bit;
		for (int i = 0; i < bs.length; i++) {
			bit = (bs[i] & 0x0f0) >> 4;
			sb.append(chars[bit]);
			bit = bs[i] & 0x0f;
			sb.append(chars[bit]);
			// sb.append(' ');
		}
		return sb.toString().trim();
	}

	/**
	 * 字符串转化成为16进制字符串
	 * @param s
	 * @return
	 */
	public static String strTo16(String s) {
		String str = "";
		for (int i = 0; i < s.length(); i++) {
			int ch = (int) s.charAt(i);
			String s4 = Integer.toHexString(ch);
			str = str + s4;
		}
		return str;
	}

    /**
     * 文本下发
     * @return
     */
    private IMessageBody textDown(){
        JT_8300 msg = new JT_8300();
        msg.setFlag((byte)0);
        msg.setText("sat");
        return msg;
    }



	private void sendAckMsg(T808Message obj, int info ,Channel chn) {
		T808Message tMsg = (T808Message) obj;
		T808MessageHeader header = tMsg.getHeader();
		JT_8001 ack = new JT_8001();
		ack.setResponseResult((byte)info);
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
