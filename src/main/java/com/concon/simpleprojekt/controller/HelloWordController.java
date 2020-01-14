package com.concon.simpleprojekt.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWordController {
    @RequestMapping("/")
    public String sayHello(){
        return "<h1>Hello World</>";
    }

}
