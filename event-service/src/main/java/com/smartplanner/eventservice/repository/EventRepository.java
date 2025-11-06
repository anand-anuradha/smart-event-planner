package com.smartplanner.eventservice.repository;

import com.smartplanner.eventservice.entity.Event;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EventRepository extends MongoRepository<Event, String> {
    List<Event> findByUserId(String userId);
}
