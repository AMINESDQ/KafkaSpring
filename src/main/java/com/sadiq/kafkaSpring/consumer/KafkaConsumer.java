//package com.sadiq.kafkaSpring.consumer;
//
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//@Controller
//public class KafkaConsumer {
//    private List<String> results = new ArrayList<>();
//
//
//    @KafkaListener(topics = "test", groupId = "group_id")
//    public void consume(String message) {
//        System.out.println("Message received: " + message);
//        results.add(message);
//    }
//
//    @GetMapping("/results")
//    public String getResults(Model model) {
//        model.addAttribute("results", results);
//        return "results"; // Renvoie le nom de la vue Thymeleaf
//    }
//
//}
