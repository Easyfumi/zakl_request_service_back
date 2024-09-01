package ru.marinin.zaklRequest.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import ru.marinin.zaklRequest.model.Message;

@Component
public class MyKafkaSender {
    private final KafkaTemplate<String, Message> kafkaTemplate;

    public MyKafkaSender(KafkaTemplate<String, Message> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(Message message, String topicName) {
        kafkaTemplate.send(topicName, message);
    }
}
