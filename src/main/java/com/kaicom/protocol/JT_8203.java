package com.kaicom.protocol;

/**
 * �˹�ȷ�ϱ���
 */
public class JT_8203 implements IMessageBody {

	/**
	 * �˹�����ȷ�ϵı�����Ϣ����ˮ��
	 */
	private short responseMessageSerialNo;

	public final short getResponseMessageSerialNo() {
		return responseMessageSerialNo;
	}

	public final void setResponseMessageSerialNo(short value) {
		responseMessageSerialNo = value;
	}

	
	/**
	 * �˹�ȷ�ϱ�������
	 */
	private int alarmType;


	@Override
	public String toString() {
		return "�˹�ȷ�ϱ�������:"+getAlarmType();
	}

	public final byte[] WriteToBytes() {
		MyBuffer buff = new MyBuffer();

		buff.put(getResponseMessageSerialNo());
		buff.put(this.getAlarmType());

		return buff.array();

	}

	public final void ReadFromBytes(byte[] messageBodyBytes) {

		setResponseMessageSerialNo((short) BitConverter.ToUInt16(
				messageBodyBytes, 0));
		this.setAlarmType((int) BitConverter.ToUInt32(messageBodyBytes, 2));
	}

	public int getAlarmType() {
		return alarmType;
	}

	public void setAlarmType(int alarmType) {
		this.alarmType = alarmType;
	}
}