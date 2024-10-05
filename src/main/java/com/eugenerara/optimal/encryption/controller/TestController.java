package com.eugenerara.optimal.encryption.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    // This is a simple test controller to check if the application is running
    @RequestMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }
}
