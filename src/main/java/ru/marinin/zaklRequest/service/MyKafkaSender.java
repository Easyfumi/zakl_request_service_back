package ru.marinin.zaklRequest.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import ru.marinin.zaklRequest.model.RequestForProducer;

@Component
public class MyKafkaSender {
    private final KafkaTemplate<String, RequestForProducer> kafkaTemplate;

    public MyKafkaSender(KafkaTemplate<String, RequestForProducer> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(RequestForProducer requestForProducer, String topicName) {
        kafkaTemplate.send(topicName, requestForProducer);
    }
}
