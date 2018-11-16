package com.publish.MessageDemo.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    @Autowired
    JmsTemplate jmsTemplate;

    @Value("some.queue")
    String destinationQueue;

    public String recieveMessage(){
        System.out.println(jmsTemplate.receiveAndConvert(destinationQueue));
       return (String) jmsTemplate.receiveAndConvert(destinationQueue);
    }
}

