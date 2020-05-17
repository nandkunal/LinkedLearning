package com.learning.rabbitmq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.ShutdownSignalException;
import com.rabbitmq.client.AMQP.BasicProperties;

public class ConsumerDirectExchange {

	public static void main(String[] args) {

		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection = null;
		Channel channel = null;
		
		try {
			connection = factory.newConnection();
			channel = connection.createChannel();
			channel.queueBind("emailServiceQueue", "webappExchange", "booking.reserve");
			channel.queueBind("bookingServiceQueue", "webappExchange", "");
			System.out.println("Consuming messages, press ctrl + c to exit");
			
			/* In case of lambda use below syntax
			 * DeliverCallback deliverCallback = (consumerTag, delivery) -> {
						String message = new String(delivery.getBody(), "UTF-8");
	        				System.out.println(" Received '" + message + "'");
	        				};
	        				
	        				DeliverCallback deliverCallback = (consumerTag, delivery) -> {
						String message = new String(delivery.getBody(), "UTF-8");
	        				System.out.println(" Received '" + message + "'");
	        				};
	        						
	        	CancelCallback cancelCallback = (consumerTag) -> {
    				System.out.println("cancel");
    				};
			    
			
			channel.basicConsume("emailServiceQueue", deliverCallback, cancelCallback);
	       */
	        	
			Consumer consumer = new Consumer() {
				
				@Override
				public void handleShutdownSignal(String consumerTag, ShutdownSignalException sig) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void handleRecoverOk(String consumerTag) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void handleDelivery(String arg0, Envelope arg1, BasicProperties arg2, byte[] arg3) throws IOException {
					String message = new String(arg3, "UTF-8");
			        System.out.println(" Received '" + message + "'" + arg1.getRoutingKey());
			        
					
				}
				
				@Override
				public void handleConsumeOk(String consumerTag) {
					System.out.println("consumer is registered");
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void handleCancelOk(String consumerTag) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void handleCancel(String consumerTag) throws IOException {
					// TODO Auto-generated method stub
					
				}
			}; 
			channel.basicConsume("emailServiceQueue", true, consumer);
			//channel.basicConsume("bookingServiceQueue", true, consumer);
		    try {
				Thread.sleep(Integer.MAX_VALUE);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (TimeoutException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				channel.close();
				connection.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TimeoutException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	
	}

}
