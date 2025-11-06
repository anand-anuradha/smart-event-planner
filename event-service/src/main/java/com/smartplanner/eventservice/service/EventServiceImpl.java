package com.smartplanner.eventservice.service;

import com.smartplanner.eventservice.dto.EventRequestDTO;
import com.smartplanner.eventservice.dto.EventResponseDTO;
import com.smartplanner.eventservice.entity.Event;
import com.smartplanner.eventservice.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    // Convert Event entity to Response DTO
    private EventResponseDTO mapToDTO(Event event) {
        EventResponseDTO dto = new EventResponseDTO();
        dto.setId(event.getId());
        dto.setName(event.getName());
        dto.setDescription(event.getDescription());
        dto.setLocation(event.getLocation());
        dto.setUserId(event.getUserId());
        dto.setDate(event.getDate());
        return dto;
    }

    // Convert Request DTO to Event entity
    private Event mapToEntity(EventRequestDTO dto) {
        Event event = new Event();
        event.setName(dto.getName());
        event.setDescription(dto.getDescription());
        event.setLocation(dto.getLocation());
        event.setUserId(dto.getUserId());
        event.setDate(dto.getDate());
        return event;
    }

    @Override
    public EventResponseDTO createEvent(EventRequestDTO eventRequestDTO) {
        Event event = mapToEntity(eventRequestDTO);
        Event savedEvent = eventRepository.save(event);
        return mapToDTO(savedEvent);
    }

    @Override
    public List<EventResponseDTO> getAllEvents() {
        return eventRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EventResponseDTO getEventById(String id) {
        return eventRepository.findById(id)
                .map(this::mapToDTO)
                .orElse(null);
    }

    @Override
    public EventResponseDTO updateEvent(String id, EventRequestDTO eventRequestDTO) {
        return eventRepository.findById(id).map(existingEvent -> {
            existingEvent.setName(eventRequestDTO.getName());
            existingEvent.setDescription(eventRequestDTO.getDescription());
            existingEvent.setLocation(eventRequestDTO.getLocation());
            existingEvent.setUserId(eventRequestDTO.getUserId());
            existingEvent.setDate(eventRequestDTO.getDate());
            return mapToDTO(eventRepository.save(existingEvent));
        }).orElse(null);
    }

    @Override
    public void deleteEvent(String id) {
        eventRepository.deleteById(id);
    }

    @Override
    public List<EventResponseDTO> getEventsByUser(String userId) {
        return eventRepository.findByUserId(userId)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }
}
