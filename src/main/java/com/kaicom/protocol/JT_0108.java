package com.kaicom.protocol;

public class JT_0108 implements IMessageBody
{
	private byte type;
	private byte result;
	@Override
	public byte[] WriteToBytes() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void ReadFromBytes(byte[] messageBodyBytes) {
		// TODO Auto-generated method stub
		type = messageBodyBytes[0];
		result = messageBodyBytes[1];
	}
	public byte getType() {
		return type;
	}
	public void setType(byte type) {
		this.type = type;
	}
	public byte getResult() {
		return result;
	}
	public void setResult(byte result) {
		this.result = result;
	}
	
}