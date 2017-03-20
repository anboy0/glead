package com.kaicom.protocol;

import java.util.Arrays;

/**
 * 查询终端参数,查询终端参数消息体为空。则返回主要的参数。也可下发查询具体的几个参数；
 */
public class JT_8108 implements IMessageBody {
	/**
	 * 要查询的参数个数
	 */
	private byte type;
	
	private byte[] vendor;
	
	private byte version_len;
	
	private String version;
	
	private int url_len;
	
	private String url;
	

	public final byte[] WriteToBytes() {
		MyBuffer buff = new MyBuffer();
		buff.put(type);
		buff.put(vendor);
		buff.put(version_len);
		buff.put(version);
		buff.put(url_len);
		buff.put(url);

		return buff.array();

	}

	public final void ReadFromBytes(byte[] bytes) {
		MyBuffer buff = new MyBuffer(bytes);
		type = buff.get();
		vendor = buff.gets(5);
		version_len = buff.get();
		version = buff.getString(version_len);
		url_len = buff.getLong();
		url = buff.getString(url_len);
	
	}

	public byte getType() {
		return type;
	}

	public void setType(byte type) {
		this.type = type;
	}

	public byte[] getVendor() {
		return vendor;
	}

	public void setVendor(byte[] vendor) {
		if(vendor.length!=5)
			throw new RuntimeException("设备供应商长度必须为5个字节");
		this.vendor = vendor;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
		this.version_len = (byte) version.length();
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
		this.url_len = url.length();
	}

	@Override
	public String toString() {
		return "JT_8108 [type=" + type + ", vendor=" + Arrays.toString(vendor) + ", version_len=" + version_len
				+ ", version=" + version + ", url_len=" + url_len + ", url=" + url + "]";
	}
	
}