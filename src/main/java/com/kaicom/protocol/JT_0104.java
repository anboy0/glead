package com.kaicom.protocol;

import java.io.UnsupportedEncodingException;

import com.kaicom.tool.Tools;

/**
 * 查询终端参数应答
 */
public class JT_0104 implements IMessageBody {
	/**
	 * 应答流水号,对应的终端参数查询消息的流水号
	 */

	// ORIGINAL LINE: private ushort responseMessageSerialNo;
	private short responseMessageSerialNo;

	// ORIGINAL LINE: public ushort getResponseMessageSerialNo()
	public final short getResponseMessageSerialNo() {
		return responseMessageSerialNo;
	}

	// ORIGINAL LINE: public void setResponseMessageSerialNo(ushort value)
	public final void setResponseMessageSerialNo(short value) {
		responseMessageSerialNo = value;
	}

	/**
	 * 应答参数个数
	 */
	private byte parametersCount;

	public final byte getParametersCount() {
		return parametersCount;
	}

	public final void setParametersCount(byte value) {
		parametersCount = value;
	}

	/**
	 * 参数项列表
	 */
	private java.util.ArrayList<ParameterItem> parameters;

	public final java.util.ArrayList<ParameterItem> getParameters() {
		return parameters;
	}

	public final void setParameters(java.util.ArrayList<ParameterItem> value) {
		parameters = value;
	}

	public final byte[] WriteToBytes() {
		MyBuffer buff = new MyBuffer();

		buff.put(getResponseMessageSerialNo());
		buff.put(getParametersCount());
		for (ParameterItem item : getParameters()) {
			buff.put(item.getParameterId());
			// buff.put(item.ParameterLength);
			switch (item.getParameterLength()) {
			case 1: // 参数值类型为byte
				buff.put(item.getParameterLength());
				buff.put(Byte.parseByte("" + item.getParameterValue()));
				break;
			case 2: // 参数值类型为16位无符号整形数值
				buff.put(item.getParameterLength());
				buff.put(Short.parseShort("" + item.getParameterValue()));
				break;
			case 4: // 参数值类型为32位无符号整形数值
				buff.put(item.getParameterLength());
				buff.put(Integer.parseInt(""+ item.getParameterValue()));
				break;
			default: // 参数值类型为字符串
			{
				byte[] strBytes = item.getParameterValue().toString().getBytes();
				item.setParameterLength((byte) (strBytes.length));
				buff.put(item.getParameterLength());
				buff.put(strBytes);
				//buff.put((byte) 0x00);
			}
				break;
			}
		}

		return buff.array();

	}

	public final void ReadFromBytes(byte[] bytes) {

		MyBuffer buff = new MyBuffer(bytes);

		setResponseMessageSerialNo(buff.getShort());
		setParametersCount(buff.get());
		setParameters(new java.util.ArrayList<ParameterItem>());
		int pos = 3;
		while ( buff.hasRemain()) {
			ParameterItem item = new ParameterItem();
			item.setParameterId(buff.getLong());
			pos += 4;
			item.setParameterLength(buff.get());
			pos += 1;
			switch (item.getParameterLength()) {
			case 1: // 参数值为byte类型
				item.setParameterValue(buff.get());
				break;
			case 2: // 参数值为ushort类型
				item.setParameterValue(buff.getShort());
				break;
			case 4: // 参数值为uint类型
				item.setParameterValue(buff.getLong());
				break;
			default:
				/*byte[] strBytes = buff.gets(item.getParameterLength());
				String strValue;
				try {
					strValue = new String(strBytes, "gbk");
					item.setParameterValue(strValue);
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				String strValue;
				switch (item.getParameterId()) {
				case 0xf001:
				case 0xf002:
					byte[] strBytes = buff.gets(item.getParameterLength());
					strValue = Tools.ToHexString(strBytes);
					break;
				default:
					strValue = buff.getString(item.getParameterLength());
					break;
				}
				item.setParameterValue(strValue);
				break;
			}
			this.parameters.add(item);
			pos += item.getParameterLength();
			handler(item);
		}
	}
	
	private String apn;
	private String ip;
	private int port;
	private int lock_upload_interval;
	private int lock_can_upload;
	private int upload_interval;
	private byte gsonser_enable;
	private byte gsonser_wakeup_upload_enable;
	
	private void handler(ParameterItem item){
		//parameters.
		switch(item.getParameterId())
		{
		case 0x10:
			apn = (String) item.getParameterValue();
			break;
		case 0x13:
			ip = (String) item.getParameterValue();
			break;
		case 0x18:
			port =(int) item.getParameterValue();
			break;
		case 0x27:
			lock_upload_interval =(int) item.getParameterValue();
			break;
		case 0x28:
			lock_can_upload =(int) item.getParameterValue();
			break;
		case 0x29:
			upload_interval =(int) item.getParameterValue();
			break;
		case 0xe000:
			gsonser_enable = (byte)item.getParameterValue();
			break;
		case 0xe001:
			gsonser_wakeup_upload_enable = (byte)item.getParameterValue();
			break;
		case 0xf000:
			break;
		case 0xf001:
			break;	
		}
	}

	@Override
	public String toString() {
		return "JT_0104 [apn=" + apn + ", ip=" + ip + ", port=" + port + ", lock_upload_interval="
				+ lock_upload_interval + ", lock_can_upload=" + lock_can_upload + ", upload_interval=" + upload_interval
				+ ", gsonser_enable=" + gsonser_enable + ", gsonser_wakeup_upload_enable="
				+ gsonser_wakeup_upload_enable + "]";
	}

	public String getApn() {
		return apn;
	}

	public void setApn(String apn) {
		this.apn = apn;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public int getLock_upload_interval() {
		return lock_upload_interval;
	}

	public void setLock_upload_interval(int lock_upload_interval) {
		this.lock_upload_interval = lock_upload_interval;
	}

	public int getLock_can_upload() {
		return lock_can_upload;
	}

	public void setLock_can_upload(int lock_can_upload) {
		this.lock_can_upload = lock_can_upload;
	}

	public int getUpload_interval() {
		return upload_interval;
	}

	public void setUpload_interval(int upload_interval) {
		this.upload_interval = upload_interval;
	}

	public byte getGsonser_enable() {
		return gsonser_enable;
	}

	public void setGsonser_enable(byte gsonser_enable) {
		this.gsonser_enable = gsonser_enable;
	}

	public byte getGsonser_wakeup_upload_enable() {
		return gsonser_wakeup_upload_enable;
	}

	public void setGsonser_wakeup_upload_enable(byte gsonser_wakeup_upload_enable) {
		this.gsonser_wakeup_upload_enable = gsonser_wakeup_upload_enable;
	}
	
}