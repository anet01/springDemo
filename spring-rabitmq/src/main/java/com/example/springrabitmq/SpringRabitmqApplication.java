package com.example.springrabitmq;

import com.example.springrabitmq.model.Notification;
import com.example.springrabitmq.producer.NotificationProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class SpringRabitmqApplication {



    public static void main(String[] args) {
        SpringApplication.run(SpringRabitmqApplication.class, args);




    }


}
