package com.epam.yoke.event.actuator;

import com.epam.yoke.event.model.rs.EventResponse;
import com.epam.yoke.event.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PostgresHealthIndicator implements HealthIndicator {

    private EventService eventService;

    @Autowired
    public PostgresHealthIndicator(EventService eventService) {
        this.eventService = eventService;
    }

    @Override
    public Health health() {
        List<EventResponse> events = eventService.findEvents();
        if (events == null) {
            return Health.down().build();
        }
        return Health.up().build();
    }

}