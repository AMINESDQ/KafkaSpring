package com.sadiq.kafkaSpring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class SupplierService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void produceMessage(String message) {
        kafkaTemplate.send("test", message);
    }
}