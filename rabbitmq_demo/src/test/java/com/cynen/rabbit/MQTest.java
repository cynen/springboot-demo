package com.cynen.rabbit;


import com.myth.rabbit.RabbitApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RabbitApplication.class)
public class MQTest {
    @Autowired
    private RabbitTemplate rabbitTemplate;


    /**
     * 直连模式.
     */
    @Test
    public void sendMsg(){
        rabbitTemplate.convertAndSend("direct","直接模式发送消息...");
    }
    /**
     * fanout 分裂模式.
     */
    @Test
    public void fanoutsendMsg(){
        rabbitTemplate.convertAndSend("fanout","","分裂模式测试");
    }

    /**
     * topic主题模式.
     */
    @Test
    public void topicsendMsg(){
        rabbitTemplate.convertAndSend("topictest","good.log","主题模式测试");
    }


    /**
     * 直连模式.
     */
    @Test
    public void sendMsg2(){
        Map<String,String> map = new HashMap<>();
        map.put("mobile","18986521556");
        map.put("checkcode","666666");

        rabbitTemplate.convertAndSend("sms",map);
    }
}
