import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.rabbitmq.*;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.ConsumerCancelledException;
import com.rabbitmq.client.QueueingConsumer;
import com.rabbitmq.client.ShutdownSignalException;

public class MQReceive {

	public final static String QUEUE_NAME="shaozhb";
	
	public static void main(String[] args){
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date;
		ConnectionFactory fc=new ConnectionFactory();
		
		fc.setHost("10.80.2.86");
		fc.setPort(5672);
		fc.setUsername("liwei");
		fc.setPassword("liwei");
		try {
			Connection con=fc.newConnection();
			Channel channel=con.createChannel();
			
			
			QueueingConsumer qc=new QueueingConsumer(channel);
			channel.basicConsume(QUEUE_NAME,true,qc);
			
			while (true) {
//				System.out.println(sdf.format(new Date()));
				QueueingConsumer.Delivery delivery;
		
					delivery = qc.nextDelivery();
					String message=new String(delivery.getBody());
//					System.out.println("x  received : "+message);
					
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ShutdownSignalException e) {
			e.printStackTrace();
		} catch (ConsumerCancelledException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}
	
}
