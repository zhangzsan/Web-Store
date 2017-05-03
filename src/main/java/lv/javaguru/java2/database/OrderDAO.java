package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.Order;
import lv.javaguru.java2.domain.OrderBuilder;

import java.util.List;
import java.util.Optional;

public interface OrderDAO {

    Order save(Order Order);

    Optional<Order> getById(Long id);

    void delete(Long id);

    void update(Order order);

    List<Order> getAll();

}
