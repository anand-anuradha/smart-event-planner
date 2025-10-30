package com.smartplanner.userservice.service;

import com.smartplanner.userservice.entity.Event;
import com.smartplanner.userservice.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public Event createEvent(Event event) {
        return eventRepository.save(event); // Save new event
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll(); // Fetch all events
    }

    @Override
    public Event getEventById(String id) {
        Optional<Event> optionalEvent = eventRepository.findById(id);
        return optionalEvent.orElse(null); // Return event if found, else null
    }

    @Override
    public Event updateEvent(String id, Event event) {
        return eventRepository.findById(id).map(existingEvent -> {
            existingEvent.setName(event.getName());
            existingEvent.setDescription(event.getDescription());
            existingEvent.setLocation(event.getLocation());
            existingEvent.setDate(event.getDate());
            return eventRepository.save(existingEvent); // Save updated event
        }).orElse(null);
    }

    @Override
    public void deleteEvent(String id) {
        eventRepository.deleteById(id); // Delete event by ID
    }

    @Override
    public List<Event> getEventsByUser(String userId) {
        return eventRepository.findByUserId(userId); // Custom query in repository
    }
}
