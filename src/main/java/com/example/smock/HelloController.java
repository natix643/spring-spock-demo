package com.example.smock;

import org.springframework.web.bind.annotation.*;

@RestController
class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello, world";
    }
}
