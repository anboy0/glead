package com.kaicom.func;

import com.kaicom.protocol.IMessageBody;
import com.kaicom.protocol.T808Message;
import com.kaicom.protocol.T808MessageHeader;
import com.kaicom.tool.ClassUtils;
import com.kaicom.tool.Tools;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.util.internal.IntegerHolder;

public class ProtocolFactory {
	public static ProtocolHandler Handler(int messageType, Object obj,Object service, Channel chn) {
		messageType = messageType & 0xffff;
		String nameSpace = ProtocolFactory.class.getPackage().getName();
		String className = nameSpace + ".Protocol_" + Tools.ToHexString(messageType, 2);
		Object messageBody = ClassUtils.getBean(className);
		if (messageBody != null) {
			ProtocolHandler msg = (ProtocolHandler) messageBody;

			IMessageBody dataBack = msg.handlerMsg(obj,service, chn);
			if (dataBack != null) {
				T808Message tMsg = (T808Message) obj;
				T808MessageHeader header = tMsg.getHeader();
				System.out.println("###:"+header.getMessagePacketNo());
				//header.setSimId("15168325465");
				String backClassName[] = dataBack.getClass().getName().split("_");
				int msgType = Tools.HexString2Short(backClassName[1]);//Integer.parseInt(backClassName[1]);
				
				header.setMessageType(msgType);
				header.setMessageSerialNo(header.getMessageSerialNo());
				tMsg.setHeader(header);
				
				tMsg.setMessageContents(dataBack);
				byte[] writeByte = tMsg.WriteToBytes();
				ByteBuf tx = Unpooled.copiedBuffer(writeByte);

				chn.writeAndFlush(tx);
			}

			// msg.ReadFromBytes(messageBodyBytes);
			return msg;
		}
		return null;
	}
}
