package com.smartplanner.eventservice.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "events")
public class Event {

    @Id
    private String id;

    private String name;
    private String description;
    private String location;
    private String userId;
    private Date date;
}
