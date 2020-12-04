package com.epam.yoke.attender.repository;

import com.epam.yoke.attender.model.entity.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Long> {

}
