package com.example.springrabitmq.listener;

import com.example.springrabitmq.model.Notification;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 Datayı dinleyen class
*/
@Service
public class NotificationListener {

    @RabbitListener(queues = "kuyruk-yapisi")
    public void handleMessage(Notification notification){
        System.out.println("Message alındı");
        System.out.println(notification.toString());
    }
}
