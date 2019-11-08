package kaicom.test.client;

import java.util.concurrent.TimeUnit;

import com.kaicom.tool.Tools;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.timeout.IdleStateHandler;
import kaicom.test.sever.JT808Decoder;
import kaicom.test.sever.NettyServer;

public class NettyClient {
	public void connect(String host, int port) throws Exception {

        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            Bootstrap b = new Bootstrap();
            b.group(workerGroup);
            b.channel(NioSocketChannel.class);
            b.option(ChannelOption.AUTO_READ, true);
            b.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                public void initChannel(SocketChannel ch) throws Exception {
                	ch.pipeline().addLast("idleStateHandler",
							new IdleStateHandler(30, 0, 0, TimeUnit.MINUTES));
					// 1024表示单条消息的最大长度，解码器在查找分隔符的时候，达到该长度还没找到的话会抛异常
					ch.pipeline().addLast(
							new DelimiterBasedFrameDecoder(1024, Unpooled.copiedBuffer(new byte[] { 0x7e }),
									Unpooled.copiedBuffer(new byte[] { 0x7e, 0x7e })));
					ch.pipeline().addLast(new JT808Decoder());
					ch.pipeline().addLast(new NettyClientHandler());
                }
            });
            ChannelFuture f = b.connect(host, port).sync();
            
            f.channel().closeFuture().sync();
        } finally {
            workerGroup.shutdownGracefully();
        }
    }
	public static void main(String[] args) throws Exception {
		System.out.println("hello main");
		NettyClient client = new NettyClient();
		byte test = 0x12;
		String str = ""+test;
		
		System.out.println(str);
		System.out.println(Tools.ToHexString(str.getBytes()));
		client.connect("127.0.0.1",18888);

		// Thread.sleep(3000);
		// server.stopServer();
	}
}
