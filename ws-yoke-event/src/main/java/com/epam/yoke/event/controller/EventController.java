package com.epam.yoke.event.controller;

import com.epam.yoke.event.model.rq.EventBody;
import com.epam.yoke.event.model.rs.EventResponse;
import com.epam.yoke.event.model.rs.NotifyEvent;
import com.epam.yoke.event.service.EventService;
import com.epam.yoke.event.service.NotifyService;
import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/event", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class EventController {

    private EventService eventService;
    private NotifyService notifyService;
    private final Counter eventCounter;

    @Autowired
    public EventController(EventService eventService, NotifyService notifyService, MeterRegistry registry) {
        this.eventService = eventService;
        this.notifyService = notifyService;
        this.eventCounter = Counter.builder("EventInfoContributor").register(registry);
    }

    @GetMapping("/")
    @ApiOperation(value = "Finds all events", response = Object.class)
    public @ResponseBody
    List<EventResponse> findAll() {
        return eventService.findEvents();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Find event by id", response = EventResponse.class)
    public @ResponseBody
    EventResponse getEventById(@PathVariable String id) {
        return eventService.findEventById(id);
    }

    @PostMapping(value = "/")
    @ApiOperation(value = "Save event", response = EventResponse.class)
    @Timed(value = "EventInfoContributor")
    public EventResponse create(@RequestBody EventBody event) {
        EventResponse response = eventService.saveEvent(event);
        notifyService.createEvent(response.getId(), response.getDescription());
        return response;
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "Delete event")
    public void delete(@PathVariable String id) {
        eventService.deleteEvent(id);
        notifyService.deleteEvent(id);
    }

    @GetMapping("/notify/all")
    @ApiOperation(value = "Notifies all events", response = Object.class)
    public @ResponseBody
    NotifyEvent[] getNotifyEvents() {
        return notifyService.getEvents();
    }
}
