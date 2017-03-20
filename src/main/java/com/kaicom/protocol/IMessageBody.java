package com.kaicom.protocol;

public interface IMessageBody
{
	byte[] WriteToBytes();
	void ReadFromBytes(byte[] messageBodyBytes);
}