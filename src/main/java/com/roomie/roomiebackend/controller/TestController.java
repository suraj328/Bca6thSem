package com.roomie.roomiebackend.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @RequestMapping("/")
    public String welcomeMessage() {
        return "Welcome to spring boot";
    }
}
