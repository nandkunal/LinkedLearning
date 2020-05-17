package com.learning.rabbitmq;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class BookingController {
	
	

	public static void main(String[] args) {
		ConnectionFactory conFactory = new ConnectionFactory();
		Connection connection = null;
		Channel channel = null;
		try {
			conFactory.setHost("localhost");
			connection = conFactory.newConnection();
			channel = connection.createChannel();
			channel.exchangeDeclare("webappExchange", BuiltinExchangeType.FANOUT,true);
			ExecutorService executors = Executors.newFixedThreadPool(10);	
			for (int i = 0; i < 10000; i++) {
				
				PostMessages  task = new PostMessages(channel);
				task.setMessage("Message - " + i + " for testing");
				executors.execute(task);
				task = null;
			}
			
			executors.shutdownNow();
			System.out.println("Triggered shutdown.....");
			if (executors.isTerminated()) {
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
			
			
		} catch( IllegalStateException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}

class PostMessages implements Runnable {
	
	private Channel channel;
	
	private String message;
	
	public PostMessages(Channel channel) {
		this.channel = channel;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public void run() {
		
		try {
			System.out.println(Thread.currentThread().getName());
			channel.basicPublish("webappExchange", "", null, this.message.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
