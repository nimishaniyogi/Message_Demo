package com.publish.MessageDemo.client;

import com.publish.MessageDemo.consumer.MessageConsumer;
import com.publish.MessageDemo.producer.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.JMSConsumer;
import javax.jms.JMSProducer;

@Service
public class MessageClientImpl implements MessageClient {

    @Autowired
    MessageConsumer messageConsumer;

    @Autowired
    MessageProducer messageProducer;

    @Override
    public void sendMessage(String message) {
        messageProducer.sendMessage(message);
    }

    @Override
    public String recieveMessage() {
        return messageConsumer.recieveMessage();
    }
}
