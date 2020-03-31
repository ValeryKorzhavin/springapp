package com.company.springapp.controller;

import com.company.springapp.controller.dto.HelloDto;
import com.company.springapp.service.EchoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
@AllArgsConstructor
@Slf4j
public class HelloController {

    private final EchoService echoService;

    @GetMapping
    public HelloDto getHello() {
        log.info("Hello world!");
        return HelloDto.builder()
                .message(echoService.helloWorld())
                .build();
    }

}
