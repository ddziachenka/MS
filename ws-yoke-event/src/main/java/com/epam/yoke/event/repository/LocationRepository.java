package com.epam.yoke.event.repository;

import com.epam.yoke.event.entity.Location;
import org.springframework.data.repository.CrudRepository;

public interface LocationRepository extends CrudRepository<Location, String> {

}
