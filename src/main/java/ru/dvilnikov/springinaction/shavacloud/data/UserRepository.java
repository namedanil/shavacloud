package ru.dvilnikov.springinaction.shavacloud.data;

import org.springframework.data.repository.CrudRepository;
import ru.dvilnikov.springinaction.shavacloud.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
