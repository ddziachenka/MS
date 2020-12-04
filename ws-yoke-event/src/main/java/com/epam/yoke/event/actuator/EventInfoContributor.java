package com.epam.yoke.event.actuator;

import com.epam.yoke.event.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class EventInfoContributor implements InfoContributor {

    private EventService eventService;

    @Autowired
    public EventInfoContributor(EventService eventService) {
        this.eventService = eventService;
    }

    @Override
    public void contribute(Info.Builder builder) {
        Map<String, Integer> data = new HashMap<>();
        Integer counterEvents = eventService.findEvents().size();
        data.put("count", counterEvents);
        builder.withDetail("EventInfoContributor", data);
    }
}
