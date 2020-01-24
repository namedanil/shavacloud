package ru.dvilnikov.springinaction.shavacloud.data;

import org.springframework.data.repository.CrudRepository;
import ru.dvilnikov.springinaction.shavacloud.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
