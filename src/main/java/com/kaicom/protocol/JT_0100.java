package com.kaicom.protocol;

import java.nio.charset.Charset;

import com.kaicom.tool.Tools;

/**
 * 终端注册
 */
public class JT_0100 implements IMessageBody {
	/**
	 * 省域ID
	 */
	private short province;

	public final short getProvinceId() {
		return province;
	}

	public final void setProvinceId(short value) {
		province = value;
	}

	/**
	 * 市、县域ID
	 */
	private short city;

	public final short getCityId() {
		return city;
	}

	public final void setCityId(short value) {
		city = value;
	}

	/**
	 * 制造商ID
	 */
	private String vendor;

	public final String getManufactureId() {
		return vendor;
	}

	public final void setManufactureId(String value) {
		vendor = value;
	}

	/**
	 * 终端型号
	 */
	private String product_id;

	public final String getProductlNo() {
		return product_id;
	}

	public final void setProductlNo(String value) {
		product_id = value;
	}

	/**
	 * 终端ID
	 */
	private String device_id;

	public final String getDeviceId() {
		return device_id;
	}

	public final void setDeviceId(String value) {
		device_id = value;
	}

	/**
	 * 车辆类型
	 */
	private byte type = 0;

	public final byte getType() {
		return type;
	}

	public final void setType(byte value) {
		type = value;
	}

	/**
	 * 车牌号码
	 */
	private String macInfo;

	public final String getMacInfo() {
		return macInfo;
	}

	public final void setMacInfo(String value) {
		macInfo = value;
	}

	private String iccid;
	private String bt_mac;
	

	public String getIccid() {
		return iccid;
	}

	public void setIccid(String iccid) {
		this.iccid = iccid;
	}

	public String getBt_mac() {
		return bt_mac;
	}

	public void setBt_mac(String bt_mac) {
		this.bt_mac = bt_mac;
	}

	public final void setMacInfo(String iccid, String bt_mac) {
		macInfo = iccid + bt_mac;
	}

	public final byte[] WriteToBytes() {
		MyBuffer buff = new MyBuffer();
		if (BitConverter.IsLittleEndian) {
			java.util.ArrayList<Byte> bytes = new java.util.ArrayList<Byte>(50);
			buff.put((byte) (getProvinceId() >> 8));
			buff.put((byte) getProvinceId());
			buff.put((byte) (getCityId() >> 8));
			buff.put((byte) getCityId());
			buff.put(getManufactureId(), 5);
			buff.put(getProductlNo(), 20);
			buff.put(Byte.parseByte(getDeviceId().substring(0, 2), 16));
			buff.put(Byte.parseByte(getDeviceId().substring(2, 4), 16));
			buff.put(Byte.parseByte(getDeviceId().substring(4, 6), 16));
			buff.put(Byte.parseByte(getDeviceId().substring(6, 8), 16));
			buff.put(Byte.parseByte(getDeviceId().substring(8, 10), 16));
			buff.put(Byte.parseByte(getDeviceId().substring(10, 12), 16));
			buff.put((byte) 0xFF);
			// buff.putRange(GetFixedSizedBytes(TerminalId, 7, 0x00));
			buff.put((byte) getType());
			buff.put(getMacInfo());
			buff.put((byte) 0x00);
			return buff.array();
		} else {

			try {
				try {
					buff.put(getProvinceId());
					buff.put(getCityId());
					/*buff.put(getManufactureId().getBytes(), 5);
					buff.put(getProductlNo().getBytes(), 20);*/
					buff.put(getManufactureId().getBytes());
					buff.put(getProductlNo().getBytes());
					buff.put(getDeviceId().getBytes());
					/*buff.put(Byte.parseByte(getDeviceId().substring(0, 2), 16));
					buff.put(Byte.parseByte(getDeviceId().substring(2, 4), 16));
					buff.put(Byte.parseByte(getDeviceId().substring(4, 6), 16));
					buff.put(Byte.parseByte(getDeviceId().substring(6, 8), 16));
					buff.put(Byte.parseByte(getDeviceId().substring(8, 10), 16));
					buff.put(Byte.parseByte(getDeviceId().substring(10, 12), 16));
					*/
					buff.put((byte) 0xFF);
					// buff.put(GetFixedSizedBytes(TerminalId, 7, 0x00));
					buff.put((byte) getType());
					buff.put(getMacInfo());
					buff.put((byte) 0x00);
				} finally {

				}
				return buff.array();
			} finally {

			}
		}
	}

	public final void ReadFromBytes(byte[] bytes) {
		MyBuffer buff = new MyBuffer(bytes);
		if (BitConverter.IsLittleEndian) {
			setProvinceId((short) ((bytes[0] << 8) + bytes[1]));
			setCityId((short) ((bytes[2] << 8) + bytes[3]));

			setManufactureId(buff.getString(5).trim());

			if (bytes.length < 36) {
				// 没有实现808补充协议
				setProductlNo(buff.getString(8).trim());
				setDeviceId(buff.getString(7).trim());
				setType(buff.get());
				setMacInfo(buff.getString(bytes.length - 25).trim());
			} else {
				// 808补充协议 终端型号是20个字节
				setProductlNo(buff.getString(20).trim());
				setDeviceId(buff.getString(7).trim());
				setType(buff.get());
				setMacInfo(buff.getString(bytes.length - 37).trim());
			}

		} else {
			setProvinceId(buff.getShort());
			setCityId(buff.getShort());
			vendor = buff.getString(5).trim();

			int dataLen = 37;
			if (bytes.length < 36) {
				setProductlNo(buff.getString(8).trim());
				dataLen = 25;
			} else
				this.product_id = buff.getString(20).trim();
			// byte[] bcdBytes = buff.gets(7);
			this.device_id = buff.getString(7).trim();
			// TerminalId = buff.getString(7));
			this.type = (buff.get());

			switch (type) {
			case 0x1:
				if (bytes.length - dataLen == 10) {
					this.iccid = (String.format("%02X", buff.get()) + String.format("%02X", buff.get())
							+ String.format("%02X", buff.get()) + String.format("%02X", buff.get())
							+ String.format("%02X", buff.get()) + String.format("%02X", buff.get())
							+ String.format("%02X", buff.get()) + String.format("%02X", buff.get())
							+ String.format("%02X", buff.get()) + String.format("%02X", buff.get())).trim();
					this.macInfo = this.iccid;
				} else {
					this.macInfo = buff.getString(bytes.length - dataLen).trim();
					this.iccid = this.macInfo;
				}
				break;
			case 0x2:
				this.macInfo = buff.getString(bytes.length - dataLen).trim();
				this.bt_mac = this.macInfo;
				break;
			case 0x3:
				if (bytes.length - dataLen == 27) {

					this.iccid = (String.format("%02X", buff.get()) + String.format("%02X", buff.get())
							+ String.format("%02X", buff.get()) + String.format("%02X", buff.get())
							+ String.format("%02X", buff.get()) + String.format("%02X", buff.get())
							+ String.format("%02X", buff.get()) + String.format("%02X", buff.get())
							+ String.format("%02X", buff.get()) + String.format("%02X", buff.get())).trim();
					this.bt_mac = buff.getString(17).trim();
					this.macInfo = this.iccid + this.bt_mac;
				} else {
					this.macInfo = buff.getString(bytes.length - dataLen).trim();
				}
				break;
			}
		}
	}

	@Override
	public String toString() {
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append(String.format("省：%1$s,市：%2$s,制造商：%3$s，型号：%4$s，终端：%5$s，车辆类型：%6$s，车辆标示:%7$s", getProvinceId(),
				getCityId(), getManufactureId(), getProductlNo(), getDeviceId(), getType(), getMacInfo()));
		sBuilder.append(String.format("iccid: %1$s bt_mac: %2$s ",getIccid(),getBt_mac()));
		return sBuilder.toString();
	}

}