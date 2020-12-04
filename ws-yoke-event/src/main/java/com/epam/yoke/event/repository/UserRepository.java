package com.epam.yoke.event.repository;

import com.epam.yoke.event.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {

}
