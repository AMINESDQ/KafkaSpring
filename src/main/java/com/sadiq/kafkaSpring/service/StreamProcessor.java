package com.sadiq.kafkaSpring.service;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class StreamProcessor {

    @Bean
    public Function<String, String> process() {
        return message -> {
            // Traitement des messages Kafka en flux
            return "Processed message: " + message.toUpperCase();
        };
    }
}
