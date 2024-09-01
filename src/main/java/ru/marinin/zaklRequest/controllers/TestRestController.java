package ru.marinin.zaklRequest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.marinin.zaklRequest.model.Message;
import ru.marinin.zaklRequest.service.MyKafkaSender;

@RestController
public class TestRestController {

    @Autowired
    MyKafkaSender kafkaSender;


    @GetMapping("/hello")
    public String hello() {
        var msg = new Message();
        msg.setMyMessage("hello");
        kafkaSender.sendMessage(msg, "test_topic");
        return "hello";
    }

}
