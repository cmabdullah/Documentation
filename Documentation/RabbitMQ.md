# Rabbit MQ

        <dependency>
            <groupId>com.rabbitmq</groupId>
            <artifactId>amqp-client</artifactId>
            <version>3.6.6</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/commons-io/commons-io -->
        <dependency>
            <groupId>commons-io</groupId>
            <artifactId>commons-io</artifactId>
            <version>2.6</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/commons-cli/commons-cli -->
        <dependency>
            <groupId>commons-cli</groupId>
            <artifactId>commons-cli</artifactId>
            <version>1.4</version>
        </dependency>

## Publish a message
```java
package com.abdullah.RabbitMQ;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * What is default exchange?
 * we have to specify exchange name and routing key..... 
 * when we create a queue, it  is binded with default exchange using queue name 
 *
 */
public class Publisher {
    public static void main( String[] args ) throws IOException, TimeoutException{
        // responsible to create connection
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        //factory.setPort();
        factory.setUsername("guest");
        factory.setPassword("guest");
        //ask factory to create new connection, connection is physical tcp connection
        //that establish connection with rabbit mq...
        Connection connection = factory.newConnection(); // newConnection() returns a connection object
        
        //we can create multiple channel from one connection
        
        Channel channel = connection.createChannel();// we can think channels as more virtual connection...
        String queName = "TestQueue";
        for (int i = 1; i<=10 ; i++) {
            String message = "Hello world " + i ;
            /***
             * in order to publish message we have to use method that is part of channel
             *  basicPublish(exchange ,routing key, headers, message )
             *  exchange = "" = empty = default
             *  routing key = TestQueue 
             *  headers = null
             */
            channel.basicPublish("", queName, null, message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");
        }
        channel.close();
        connection.close();
    }
}
```


## Consumer a message
```java
package com.abdullah.RabbitMQ;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.ConsumerCancelledException;
import com.rabbitmq.client.QueueingConsumer;
import com.rabbitmq.client.QueueingConsumer.Delivery;
import com.rabbitmq.client.ShutdownSignalException;

public class Consumer {

    public static void main(String[] args) throws IOException, TimeoutException, ShutdownSignalException, ConsumerCancelledException, InterruptedException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setUsername("guest");
        factory.setPassword("guest");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        String queueName = "TestQueue";
        QueueingConsumer consumer = new QueueingConsumer(channel);
        channel.basicConsume(queueName, consumer);
        boolean removeAllUpTo  = true;
        while(true) {
            Delivery delivery = consumer.nextDelivery(5000);
            if (delivery == null)
                break;
            if (processMessage(delivery)) {
                long deliveryTag = delivery.getEnvelope().getDeliveryTag();
                channel.basicAck(deliveryTag, removeAllUpTo);
            }
        }
        channel.close();
        connection.close();
    }
    private static boolean processMessage(Delivery delivery) throws UnsupportedEncodingException{
        String message = new String(delivery.getBody(), "UTF-8");
        System.out.println("[x] Receive redeliver= " + delivery.getEnvelope().isRedeliver() + " Msg : " + message);
        return false;
        //return true;
    }
}

```