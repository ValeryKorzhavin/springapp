package com.company.springapp.service;

import org.springframework.stereotype.Service;

@Service
public class EchoService {

    public String helloWorld() {
        return "Hello world!";
    }

}
