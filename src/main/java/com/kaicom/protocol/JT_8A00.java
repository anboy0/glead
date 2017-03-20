package com.kaicom.protocol;

/** 
 数据下行透传
 
*/
public class JT_8A00 implements IMessageBody
{
	/** 
	 透传消息类型
	 
	*/
	private byte messageType;
	public final byte getMessageType()
	{
		return messageType;
	}
	public final void setMessageType(byte value)
	{
		messageType = value;
	}
	/** 
	 透传消息内容
	 
	*/
	private byte[] btPwd;
	public final byte[] getBtPwd()
	{
		return btPwd;
	}
	public final void setBtPwd(byte[] value)
	{
		if(value.length!=6)
		{
			throw new RuntimeException("蓝牙密码长度必须为6位!");
		}
		btPwd = value;
	}
	private byte[] btKey;
	public final byte[] getBtKey()
	{
		return btKey;
	}
	public final void setBtKey(byte[] value)
	{
		if(value.length!=16)
		{
			throw new RuntimeException("蓝牙秘密长度必须为16位!");
		}
		btKey = value;
	}
	public final byte[] WriteToBytes()
	{
		byte[] bytes = new byte[23];
		bytes[0] = getMessageType();
		System.arraycopy(getBtPwd(), 0, bytes, 1, btPwd.length);
		System.arraycopy(btKey, 0, bytes, 7, btKey.length);
		return bytes;
	}

	public final void ReadFromBytes(byte[] bytes)
	{
		setMessageType(bytes[0]);
		//setMessageContent(new byte[bytes.length - 1]);
		//setBtPwd(new byte[bytes.length - 1]);
		btKey = new byte[16];
		btPwd = new byte[6];
		System.arraycopy(bytes, 1, btPwd, 0,6);
		System.arraycopy(bytes, 7, btKey, 0,16);
		//System.arraycopy(bytes, 1, getMessageContent(), 0, bytes.length - 1);
	}
}