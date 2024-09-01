package ru.marinin.zaklRequest.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import ru.marinin.zaklRequest.model.Request;

@Component
public class MyKafkaSender {
    private final KafkaTemplate<String, Request> kafkaTemplate;

    public MyKafkaSender(KafkaTemplate<String, Request> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(Request request, String topicName) {
        kafkaTemplate.send(topicName, request);
    }
}
