package kaicom.test.sever;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.timeout.IdleStateHandler;
import io.netty.util.concurrent.Future;

@Component
public class NettyServer {
	private EventLoopGroup bossGroup = null;
	private EventLoopGroup workerGroup = null;
	private int port;
	private boolean isRunning =false;
	private Logger logger = Logger.getLogger(NettyServer.class);
	@Autowired
	NettyServerHandler nettyServerHandler;
	public NettyServer(int port) {
		super();
		this.port = port;
	}
	public NettyServer(){
		
	}
	

	public synchronized void startServer() {
		if (this.isRunning) {
			throw new IllegalStateException(this.getName() + " is already started .");
		}
		this.isRunning = true;
		new BindThread().start();
		//new Thread() 
		/*new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				this.bind();
			}
		};*/
		
	}
	class BindThread extends Thread {
		 void bind() throws Exception {
			bossGroup = new NioEventLoopGroup();
			workerGroup = new NioEventLoopGroup();
			ServerBootstrap serverBootstrap = new ServerBootstrap();
			serverBootstrap.group(bossGroup, workerGroup)//
					.channel(NioServerSocketChannel.class) //
					.childHandler(new ChannelInitializer<SocketChannel>() { //
						@Override
						public void initChannel(SocketChannel ch) throws Exception {
							ch.pipeline().addLast("idleStateHandler",
									new IdleStateHandler(30, 0, 0, TimeUnit.MINUTES));
							// 1024表示单条消息的最大长度，解码器在查找分隔符的时候，达到该长度还没找到的话会抛异常
							ch.pipeline().addLast(
									new DelimiterBasedFrameDecoder(1024, Unpooled.copiedBuffer(new byte[] { 0x7e }),
											Unpooled.copiedBuffer(new byte[] { 0x7e,0x7e })));
							ch.pipeline().addLast(new JT808Decoder());
							ch.pipeline().addLast(nettyServerHandler);
						}
					}).option(ChannelOption.SO_BACKLOG, 128) //
					.childOption(ChannelOption.SO_KEEPALIVE, true);

			logger.info("TCP服务启动完毕,port={"+port+"}");
			ChannelFuture channelFuture = serverBootstrap.bind(port).sync();

			channelFuture.channel().closeFuture().sync();
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
				try {
					this.bind();
				} catch (Exception e) {
					logger.info("TCP服务启动出错:{"+e.getMessage()+"}");
					
					e.printStackTrace();
				}
			
		}
		
	}
	public synchronized void stopServer() {
		if (!this.isRunning) {
			throw new IllegalStateException(this.getName() + " is not yet started .");
		}
		this.isRunning = false;

		try {
			Future<?> future = this.workerGroup.shutdownGracefully().await();
			if (!future.isSuccess()) {
				logger.info("workerGroup 无法正常停止:{"+future.cause()+"}");
				
			}

			future = this.bossGroup.shutdownGracefully().await();
			if (!future.isSuccess()) {
				logger.info("bossGroup 无法正常停止:{"+future.cause()+"}");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		logger.info("TCP服务已经停止...");
	}

	private String getName() {
		return "TCP-Server";
	}
	public void setPort(int port)
	{
		this.port = port;
	}
	public static void main(String[] args) throws Exception {
		System.out.println("hello main");
		NettyServer server = new NettyServer(20048);
		server.startServer();

		// Thread.sleep(3000);
		// server.stopServer();
	}
}
