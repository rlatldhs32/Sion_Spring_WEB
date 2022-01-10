package com.sion.book.spring.web;

import com.sion.book.spring.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController//컨트롤러
public class HelloController {
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto
    helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount){
    //@RequestParam : 외부에서 API로 넘긴 파라미터 가져오는거임.
        return new HelloResponseDto(name,amount);
    }
}
