package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootExceptionHandleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootExceptionHandleApplication.class, args);
    }

    @RequestMapping("/hello")
    public String callMe() {
        return "Hello Spring Boot!";
    }
}
