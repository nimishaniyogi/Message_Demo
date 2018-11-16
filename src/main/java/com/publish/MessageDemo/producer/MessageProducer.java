package com.publish.MessageDemo.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.QosSettings;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class MessageProducer {

    @Autowired
    JmsTemplate jmsTemplate;

    @Value("some.queue")
    String destinationQueue;

    public void sendMessage(String message){
        QosSettings qosSettings = new QosSettings();
        Random random = new Random();
        //TODO: This sets random wait time for messages between 10 seonds to 1 minute i.e. 60 seconds
        qosSettings.setTimeToLive(random.nextInt((60000 - 10000) + 1) + 10000);  jmsTemplate.setQosSettings(qosSettings);
        jmsTemplate.convertAndSend(destinationQueue, message);
    }
}
