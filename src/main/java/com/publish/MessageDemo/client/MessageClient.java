package com.publish.MessageDemo.client;

public interface MessageClient {
    void sendMessage(String message);
    String recieveMessage();
}
