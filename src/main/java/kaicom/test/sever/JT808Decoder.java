package kaicom.test.sever;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;

import com.kaicom.protocol.T808Message;
import com.kaicom.tool.Tools;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

public class JT808Decoder extends ByteToMessageDecoder{
	private Logger logger = Logger.getLogger(JT808Decoder.class);
	protected int getRemain(ByteBuf in)
	{
		return (in.readableBytes());
	}
	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
		if (in.readableBytes()<=0) {
			return ;
		}
		while (getRemain(in)>0) {
			
			if(getRemain(in) > 0)
			{
				int packetLength = getRemain(in);
				if(packetLength > 1)
				{
					byte[] tmp = new byte[packetLength];
					in.readBytes(tmp);
					T808Message message = new T808Message();
					message.ReadFromBytes(tmp);
					out.add(message);
				}else
				{
					in.clear();
					in.readByte();
				}		
			}
		}
	}

}
