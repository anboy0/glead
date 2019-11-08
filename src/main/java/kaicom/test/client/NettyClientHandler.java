package kaicom.test.client;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

import com.kaicom.func.ProtocolFactory;
import com.kaicom.protocol.T808Message;
import com.kaicom.tool.StringUtil;
import com.kaicom.tool.Tools;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.ReferenceCountUtil;

public class NettyClientHandler extends ChannelHandlerAdapter{

	Logger logger = Logger.getLogger(getClass());
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.fireChannelActive();
        logger.info("channelActive");
/*
        String body = "测试==>" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())
                + System.getProperty("line.separator");
        ByteBuf msg = Unpooled.buffer(body.getBytes().length);
        msg.writeBytes(body.getBytes());
        ctx.writeAndFlush(msg);*/
//        String msgStr="7e0100002c0200000000150025002c0133373039363054372d54383038000000000000000000000000003033323931373001d4c142383838387b7e";
        //String msgStr="7e010200060200000000150026313639333434397e";
//        String msgStr = "7e0200005d013631945116000000000000000000000000000000000000000000000000000101080000300100310100e10400000000e2020007e306520000000000e41900000000000000000000000000000000000000000000000000e50400000002e6020300e70200002a7e";
		String msgStr="7e0102000d020000000015002531353532323832363034363832097e";
		byte[] msgByte = Tools.HexString2Bytes(msgStr);
        logger.info(Tools.ToHexString(msgByte));
        logger.info(Tools.ToHexFormatString(msgByte));
        ByteBuf msg = Unpooled.buffer(msgByte.length);
        msg.writeBytes(msgByte);
        ctx.writeAndFlush(msg);
    }

    @Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws InterruptedException { // (2)
		try {
			//ctx.channel().write(msg)
			processPackageData((T808Message)msg,ctx.channel());
		} finally {
			release(msg);
		}
	}
    
    private void release(Object msg) {
		try {
			ReferenceCountUtil.release(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * 处理业务逻辑
	 * 
	 * @param packageData
	 * 
	 */
	private void processPackageData(T808Message packageData,Channel chn) {
		logger.info(packageData.getMessageContents().toString());
		try{
			ProtocolFactory.Handler(packageData.getMessageType(),packageData, null, chn);
		}catch(Exception exp){
			logger.error(exp.toString());
			exp.printStackTrace();
		}
		
	}

}
