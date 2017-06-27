import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.rabbitmq.*;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class MQSend {

	public final static String QUEUE_NAME = "shaozhb";

	public static void main(String[] args) throws InterruptedException{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date;
		ConnectionFactory cf=new ConnectionFactory();
		cf.setHost("10.80.2.86");
		cf.setPort(5672);
		cf.setUsername("liwei");
		cf.setPassword("liwei");
		try {
			Connection con=cf.newConnection();
			Channel channel=con.createChannel();
			channel.queueDeclare(QUEUE_NAME,false,false,false,null);
			System.out.println(sdf.format(new Date()));
			for(int i=0;i<1000;i++){
				String stra="stra="+i;
//				Thread.sleep(1000);
				
				for(int j=0;j<1000;j++){
					String strb=stra+"  ,  strb="+j;
					
					channel.basicPublish("",QUEUE_NAME,null,strb.getBytes());
//					System.out.println("X send : "+strb);
				}
			}
//			String message="Hello world1!";
//			channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
//			System.out.println("X send : "+message);	
			System.out.println(sdf.format(new Date()));
			channel.close();
			con.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
	}
}
