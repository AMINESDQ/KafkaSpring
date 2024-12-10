package com.sadiq.kafkaSpring.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Controller
public class RealTimeResultsController {

    private final List<SseEmitter> emitters = new CopyOnWriteArrayList<>();

    // Cette méthode consomme les messages Kafka et les envoie à tous les clients connectés via SSE
    @KafkaListener(topics = "test", groupId = "group_id")
    public void consume(String message) {
        System.out.println("Message received: " + message);
        List<SseEmitter> deadEmitters = new ArrayList<>();

        emitters.forEach(emitter -> {
            try {
                emitter.send(message);
            } catch (IOException e) {
                deadEmitters.add(emitter);  // Si l'émetteur ne fonctionne plus, on le retire
            }
        });

        emitters.removeAll(deadEmitters);
    }

    // Point d'entrée SSE pour les clients (navigateur)
    @GetMapping("/results-stream")
    public SseEmitter streamResults() {
        SseEmitter emitter = new SseEmitter();
        emitters.add(emitter);
        emitter.onCompletion(() -> emitters.remove(emitter));
        emitter.onTimeout(() -> emitters.remove(emitter));
        return emitter;
    }

    @GetMapping("/results")
    public String getResultsPage() {
        return "results";  // Le nom du fichier Thymeleaf (sans .html)
    }
}
