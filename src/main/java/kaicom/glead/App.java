package kaicom.glead;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kaicom.model.BikeDevice;
import com.kaicom.netty.MyServer;
import com.kaicom.service.BikeDeviceService;

import kaicom.test.sever.NettyServer;

/**
 * Hello world!
 *
 */
public class App 
{
	
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        NettyServer server = ctx.getBean(NettyServer.class);
        try {
			server.setPort(18888);
			server.startServer();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        		
    }
}
