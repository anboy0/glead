package kaicom.glead;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import kaicom.activeMq.DispatchMqMgr;
import kaicom.activeMq.LocationMqMgr;
import kaicom.test.sever.NettyServer;

/**
 * Hello world!
 *
 */
public class App 
{
	
    public static void main( String[] args )
    {
        System.out.println( "this is common version v1.0!" );
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
//        LocationMqMgr.Init();
//        DispatchMqMgr.Init();
//        Runtime.getRuntime().addShutdownHook(new Thread(){
//			public void run() {
//				LocationMqMgr.close();
//				DispatchMqMgr.close();
//			}
//		});
        //LocationMqMgr.sendMqMsg("this is a test!");
        NettyServer server = ctx.getBean(NettyServer.class);
        try {
			server.setPort(10810);
			server.startServer();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        		
    }
}
