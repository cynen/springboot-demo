package com.cynen.springboothello.web;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 使用RestController 注解 = Controller + ResponseBody
 * 返回的就是一个JSON数据
 * 传统的 Controller ,返回的是一个视图.
 */
@RestController
public class HelloController {

    // 可以简写.
    @GetMapping("hello")
    // @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(){
        return  "Hello SpringBoot ...123";
    }
}
