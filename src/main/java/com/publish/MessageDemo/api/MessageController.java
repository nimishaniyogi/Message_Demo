package com.publish.MessageDemo.api;

import com.publish.MessageDemo.client.MessageClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MessageController {

    @Autowired
    MessageClient messageClient;

    @PostMapping(value = "/sendMessage", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String produceMessage(@RequestBody String msg){
        // Take input JSON object as a string and send it as a string to read
        messageClient.sendMessage(msg);
        return "Published";
    }

    @GetMapping(value = "/getMessage")
    public String recieveMessage(){
        return messageClient.recieveMessage();
    }

}
