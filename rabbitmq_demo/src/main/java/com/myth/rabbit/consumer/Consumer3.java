package com.myth.rabbit.consumer;


import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "queue3")
public class Consumer3 {

    @RabbitHandler
    public void handler(String msg){
        System.out.println("Queue3 接受到的信息 :" + msg);
    }

}
