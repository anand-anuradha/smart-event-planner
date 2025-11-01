package com.smartplanner.eventservice.controller;

import com.smartplanner.eventservice.dto.EventRequestDTO;
import com.smartplanner.eventservice.dto.EventResponseDTO;
import com.smartplanner.eventservice.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping("/create")
    public ResponseEntity<EventResponseDTO> createEvent(@RequestBody EventRequestDTO eventRequestDTO) {
        return ResponseEntity.ok(eventService.createEvent(eventRequestDTO));
    }

    @GetMapping("/all")
    public ResponseEntity<List<EventResponseDTO>> getAllEvents() {
        return ResponseEntity.ok(eventService.getAllEvents());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<EventResponseDTO>> getEventsByUser(@PathVariable String userId) {
        return ResponseEntity.ok(eventService.getEventsByUser(userId));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<EventResponseDTO> updateEvent(@PathVariable String id,
                                                        @RequestBody EventRequestDTO eventRequestDTO) {
        EventResponseDTO updatedEvent = eventService.updateEvent(id, eventRequestDTO);
        if (updatedEvent == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updatedEvent);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEvent(@PathVariable String id) {
        eventService.deleteEvent(id);
        return ResponseEntity.ok("Event deleted successfully");
    }
}
