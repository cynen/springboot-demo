package com.myth.rabbit.consumer;


import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 直连模式
 *
 * Rabbit 产生着直接发送消息到 指定的队列Quene中.
 *  RabbitMQ的监听器,监听队列: direct [可配置]
 *
 *  我们需要将消息发给唯一一个节点时使用这种模式，这是最简单的一种形式
 *
 */
@Component
@RabbitListener(queues = "direct")
public class RabbitConsumerDirect {


    @RabbitHandler
    public void consume(String msg){
        System.out.println("直连模式: "+ msg);
    }

}
