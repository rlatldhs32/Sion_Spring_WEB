package com.sion.book.spring.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//컨트롤러
public class HelloController {
    @GetMapping("/good")
    public String hello(){
        return "hello";
    }
}
