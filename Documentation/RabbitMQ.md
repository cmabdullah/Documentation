# Rabbit MQ


## Publish a message
```java
package com.abdullah.RabbitMQ;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * Hello world!
 *
 */
public class Publisher {
    public static void main( String[] args ) throws IOException, TimeoutException{
        System.out.println( "Hello World!" );
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        //factory.setPort();
        factory.setUsername("guest");
        factory.setPassword("guest");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        String queName = "TestQueue";
        for (int i = 1; i<=10 ; i++) {
        	String message = "Hello world " + i ;
        	channel.basicPublish("", queName, null, message.getBytes());
        	System.out.println(" [x] Sent '" + message + "'");
        }
        channel.close();
        connection.close();
    }
}
```
