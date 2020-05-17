package com.learning.rabbitmq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class SendMessageDirectExchange {

	public static void main(String[] args) {
		ConnectionFactory conFactory = new ConnectionFactory();
		Connection connection = null;
		Channel channel = null;
		try {
			conFactory.setHost("localhost");
			connection = conFactory.newConnection();
			channel = connection.createChannel();
			channel.exchangeDeclare("webappExchange", BuiltinExchangeType.DIRECT,true);
			String message = "Hello world from Direct Exchange Type";
			
			channel.basicPublish("webappExchange", "booking.reserve", null, message.getBytes());
		}  catch( IllegalStateException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
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
