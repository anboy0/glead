package com.kaicom.func;

import com.kaicom.protocol.IMessageBody;
import com.kaicom.protocol.JT_0102;

import io.netty.channel.Channel;
/**
 * 
 * @author cgm
 *
 *
 *	终端响应    注册应答处理,终端处理完成后向服务器发起鉴权
 */


public class Protocol_8100 implements ProtocolHandler{
	@Override
	public IMessageBody handlerMsg(Object obj,Object service, Channel chn) {
		// TODO Auto-generated method stub
		JT_0102 register = new JT_0102();
		register.setRegisterNo(""+System.currentTimeMillis());
		return register;
	}

	@Override
	public void dealOther(Object obj) {
		// TODO Auto-generated method stub
		
	}

}
