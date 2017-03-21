package com.kaicom.protocol;

import com.kaicom.tool.ClassUtils;
import com.kaicom.tool.Tools;


public final class T808MessageFactory {
	private static final boolean RECORDER_VER_2012 = true;
	public static IMessageBody Create(int messageType, byte[] messageBodyBytes)
	{
			
			messageType = messageType&0xffff;
			String nameSpace = T808MessageFactory.class.getPackage().getName();
			String className = nameSpace + ".JT_" + Tools.ToHexString(messageType,2);
			/*if(messageType == 0x0700 && RECORDER_VER_2012){
				className = nameSpace + "jt2012.JT2012_" + Tools.ToHexString(messageType,2);
			}
			*/
			Object messageBody = ClassUtils.getBean(className);
			if (messageBody != null)
			{
				IMessageBody msg = (IMessageBody)messageBody;
				msg.ReadFromBytes(messageBodyBytes);
				return msg;
			}
			return null;
	}

}