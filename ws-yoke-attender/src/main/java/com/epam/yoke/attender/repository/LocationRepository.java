package com.epam.yoke.attender.repository;

import com.epam.yoke.attender.model.entity.Location;
import org.springframework.data.repository.CrudRepository;

public interface LocationRepository extends CrudRepository<Location, String> {

}
