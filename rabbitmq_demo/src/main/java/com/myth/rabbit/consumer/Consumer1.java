package com.myth.rabbit.consumer;


import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Consumer只关注RabbitMQ的Queues列表中的队列
 */
@Component
@RabbitListener(queues = "queue1")
public class Consumer1 {

    @RabbitHandler
    public void handler(String msg){
        System.out.println("Queue1 接受到的信息 :" + msg);
    }

}
