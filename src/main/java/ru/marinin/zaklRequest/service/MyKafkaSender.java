package ru.marinin.zaklRequest.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import ru.marinin.zaklRequest.model.KafkaRequest;

@Component
public class MyKafkaSender {
    private final KafkaTemplate<String, KafkaRequest> kafkaTemplate;

    public MyKafkaSender(KafkaTemplate<String, KafkaRequest> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(KafkaRequest kafkaRequest, String topicName) {
        kafkaTemplate.send(topicName, kafkaRequest);
    }
}
