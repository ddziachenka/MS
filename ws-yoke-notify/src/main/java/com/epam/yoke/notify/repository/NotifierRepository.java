package com.epam.yoke.notify.repository;

import com.epam.yoke.notify.model.Event;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotifierRepository extends MongoRepository<Event, String> {

    Event findEventByEventIdIs(String eventId);
}
