package ru.marinin.zaklRequest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import ru.marinin.zaklRequest.model.Request;


@Component
class MyKafkaListener {

    @Autowired
    RequestService requestService;

    @KafkaListener(topics = "request_topic_2", groupId = "myGroup")
    void listener(Request request) {
        System.out.println(request);
        requestService.saveNewRequest(request);
    }
}
