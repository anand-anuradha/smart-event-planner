package com.smartplanner.eventservice.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class EventReminderProducer {

    private static final String TOPIC = "event-reminders";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendReminder(String message) {
        kafkaTemplate.send(TOPIC, message);
    }
}
