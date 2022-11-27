package com.example.springaop.service;

import org.springframework.stereotype.Service;

@Service
public class MessageService {


    public String mesajVer(String param){
        System.out.println("metod mesajı: " + param);
        return param;
    }
}
