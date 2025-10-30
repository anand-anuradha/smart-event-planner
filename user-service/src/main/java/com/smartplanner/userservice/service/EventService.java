package com.smartplanner.userservice.service;

import com.smartplanner.userservice.entity.Event;
import java.util.List;

public interface EventService {

    // Create a new event
    Event createEvent(Event event);

    // Get all events
    List<Event> getAllEvents();

    // Get event by ID
    Event getEventById(String id);

    // Update an event
    Event updateEvent(String id, Event event);

    // Delete an event
    void deleteEvent(String id);

    // Optional: get events created by a specific user
    List<Event> getEventsByUser(String userId);
}
