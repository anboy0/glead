package com.kaicom.protocol;


public interface IPositionAdditionalItem
{
	int getAdditionalId();
	byte getAdditionalLength();
	byte[] WriteToBytes();
	void ReadFromBytes(byte[] bytes);
}