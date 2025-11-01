package com.smartplanner.eventservice.dto;

import lombok.Data;
import java.util.Date;

@Data
public class EventRequestDTO {
    private String name;
    private String description;
    private String location;
    private String userId;
    private Date date;
}
