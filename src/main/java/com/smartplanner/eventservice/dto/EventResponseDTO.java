package com.smartplanner.eventservice.dto;

import lombok.Data;
import java.util.Date;

@Data
public class EventResponseDTO {
    private String id;
    private String name;
    private String description;
    private String location;
    private String userId;
    private Date date;
}
