package com.smartplanner.eventservice.kafka;

import com.smartplanner.eventservice.dto.EventResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class EventProducer {

    private static final String TOPIC = "event-topic";

    @Autowired
    private KafkaTemplate<String, EventResponseDTO> kafkaTemplate;

    public void sendEvent(EventResponseDTO event) {
        kafkaTemplate.send(TOPIC, event);
    }
}
