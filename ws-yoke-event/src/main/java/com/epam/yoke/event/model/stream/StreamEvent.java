package com.epam.yoke.event.model.stream;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class StreamEvent {

    public String eventId;
    public String transactionId;
    private EventStatus status;
    public List<String> emails;
    public String description;
    private Date date;
    private Integer capacity;
    private Integer slot;
}
