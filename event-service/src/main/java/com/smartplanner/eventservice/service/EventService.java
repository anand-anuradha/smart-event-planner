package com.smartplanner.eventservice.service;

import com.smartplanner.eventservice.dto.EventRequestDTO;
import com.smartplanner.eventservice.dto.EventResponseDTO;

import java.util.List;

public interface EventService {
    EventResponseDTO createEvent(EventRequestDTO eventRequestDTO);
    List<EventResponseDTO> getAllEvents();
    EventResponseDTO getEventById(String id);
    EventResponseDTO updateEvent(String id, EventRequestDTO eventRequestDTO);
    void deleteEvent(String id);
    List<EventResponseDTO> getEventsByUser(String userId);
}
