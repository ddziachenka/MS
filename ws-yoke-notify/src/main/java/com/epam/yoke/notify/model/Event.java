package com.epam.yoke.notify.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
public class Event {

    @Id
    public String id;
    public String eventId;
    public List<String> emails;
    public String description;
}
