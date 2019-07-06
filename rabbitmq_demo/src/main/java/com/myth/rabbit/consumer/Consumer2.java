package com.myth.rabbit.consumer;


import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "queue2")
public class Consumer2 {

    @RabbitHandler
    public void handler(String msg){
        System.out.println("Queue2 接受到的信息 :" + msg);
    }

}
