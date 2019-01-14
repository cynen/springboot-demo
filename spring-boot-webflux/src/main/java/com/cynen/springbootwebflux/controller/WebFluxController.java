package com.cynen.springbootwebflux.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebFluxController {

    @GetMapping("/hello-reactive")
    public String hello(){
        return  "Hello reactive...";
    }
}
