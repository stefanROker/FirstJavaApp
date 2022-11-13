package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/hello-user")
    public String helloUser() {
        return "Hello User!";
    }

    @GetMapping("/hello-admin")
    public String helloAdmin() {
        return "Hello Admin!";
    }
}
