package com.smartplanner.userservice.repository;

import com.smartplanner.userservice.entity.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface EventRepository extends MongoRepository<Event, String> {
    List<Event> findByUserId(String userId); // Fetch events created by a specific user
}
