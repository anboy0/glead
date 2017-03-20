package kaicom.test.sever;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kaicom.func.ProtocolFactory;
import com.kaicom.func.ProtocolHandler;
import com.kaicom.model.BikeDevice;
import com.kaicom.protocol.T808Message;
import com.kaicom.service.AppVersionService;
import com.kaicom.service.BikeDeviceService;
import com.kaicom.tool.ClassUtils;
import com.kaicom.tool.Session;
import com.kaicom.tool.SessionManager;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.ReferenceCountUtil;

@Component
@Sharable
public class NettyServerHandler extends ChannelHandlerAdapter { // (1)

	private Logger logger = Logger.getLogger(NettyServerHandler.class);
	@Autowired
    private BikeDeviceService bikeDeviceService;
	
	private final SessionManager sessionManager;
/*	private final MsgDecoder decoder;
	private TerminalMsgProcessService msgProcessService;*/
	
	public NettyServerHandler() {
		this.sessionManager = SessionManager.getInstance();
		/*this.decoder = new MsgDecoder();
		this.msgProcessService = new TerminalMsgProcessService();*/
		/*List<BikeDevice> devices= bikeDeviceService.getBikeFromTel("15168325465");
	    for (Iterator iterator = devices.iterator(); iterator.hasNext();) {
			BikeDevice bikeDevice = (BikeDevice) iterator.next();
			System.out.println(bikeDevice);
		}*/
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws InterruptedException { // (2)
		try {
			//ctx.channel().write(msg)
			processPackageData((T808Message)msg,bikeDeviceService,ctx.channel());
		} finally {
			release(msg);
		}
	}

	/**
	 * 
	 * 处理业务逻辑
	 * 
	 * @param packageData
	 * 
	 */
	private void processPackageData(T808Message packageData,Object service,Channel chn) {
		//logger.info(packageData.getMessageContents().toString());
		if(packageData.getMessageType()!=0x2)
		{
			logger.info(packageData.getMessageContents().toString());
		}
		
		/*logger.info(packageData.getSimNo());
		logger.info(packageData.getPrefixID());
		logger.info(packageData.getPlateNo());
		logger.info(packageData.getMessageType());*/
		try{
			ProtocolHandler handler = ProtocolFactory.Handler(packageData.getMessageType(), packageData,service, chn);
			
		}catch(Exception exp){
			logger.error(exp.toString());
			exp.printStackTrace();
		}
		
		
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) { // (4)
		logger.error("发生异常:{}"+cause.getMessage());
		cause.printStackTrace();
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		Session session = Session.buildSession(ctx.channel());
		sessionManager.put(session.getId(), session);
		logger.info("终端连接:{}"+ session);
		//BikeDevice devices= bikeDeviceService.getBikeFromTel("15168325465");
	    
		//System.out.println(devices);
		
	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		final String sessionId = ctx.channel().id().asLongText();
		Session session = sessionManager.findBySessionId(sessionId);
		this.sessionManager.removeBySessionId(sessionId);
		logger.info("终端断开连接:{}"+ session);
		ctx.channel().close();
		// ctx.close();
	}

	@Override
	public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
		if (IdleStateEvent.class.isAssignableFrom(evt.getClass())) {
			IdleStateEvent event = (IdleStateEvent) evt;
			if (event.state() == IdleState.READER_IDLE) {
				Session session = this.sessionManager.removeBySessionId(Session.buildId(ctx.channel()));
				logger.info("服务器主动断开连接:{}"+session);
				ctx.close();
			}
		}
	}

	private void release(Object msg) {
		try {
			ReferenceCountUtil.release(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*public BikeDeviceService getBikeDeviceService() {
		return bikeDeviceService;
	}

	public void setBikeDeviceService(BikeDeviceService bikeDeviceService) {
		this.bikeDeviceService = bikeDeviceService;
	}*/
	
}