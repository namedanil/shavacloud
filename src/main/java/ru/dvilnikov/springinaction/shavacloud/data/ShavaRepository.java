package ru.dvilnikov.springinaction.shavacloud.data;

import org.springframework.data.repository.CrudRepository;
import ru.dvilnikov.springinaction.shavacloud.Shava;

public interface ShavaRepository extends CrudRepository<Shava, Long> {
}
