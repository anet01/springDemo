package com.example.springrabitmq.producer;

import com.example.springrabitmq.model.Notification;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.UUID;

/**
 * Datayı gönderen Class
 */
@Service
public class NotificationProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${sr.rabbit.routing.name}")
    private String routingName;

    @Value("${sr.rabbit.exchange.name}")
    private String exchangeName;

    @PostConstruct
    public void init() throws InterruptedException {
        Notification notification = new Notification();


        for (int i = 0; i < 100; i++) {

            notification.setNotificationId(UUID.randomUUID().toString());
            notification.setCreatedAt(new Date());
            notification.setMessage("Rabbit mq test");
            notification.setSeen(false);

            sendToQueue(notification);
            Thread.sleep(1000);
        }
    }

    public void sendToQueue(Notification notification) {
        System.out.println("Notification Sent ID: " + notification.getNotificationId());
        rabbitTemplate.convertAndSend(exchangeName,routingName, notification);
    }
}
