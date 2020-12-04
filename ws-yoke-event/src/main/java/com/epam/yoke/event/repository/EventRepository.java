package com.epam.yoke.event.repository;

import com.epam.yoke.event.entity.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Long> {

}
