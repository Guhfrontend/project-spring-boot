package com.gustavo.spring_boot_project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {

    @GetMapping
    public HelloResponse helloWorld() {
       return new HelloResponse(LocalDateTime.now(), "Hello World!");
    }
}

