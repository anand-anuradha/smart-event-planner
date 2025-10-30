package com.smartplanner.userservice.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date; // or java.time.LocalDate if you prefer

@Data
@Document(collection = "events")
public class Event {

    @Id
    private String id;

    private String name;
    private String description;
    private String location;
    private String userId;

    private Date date; // Add this field for the event date
}
