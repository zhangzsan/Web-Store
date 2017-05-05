package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.Order;
import lv.javaguru.java2.domain.OrderBuilder;

public interface OrderDAO {

    Order save(OrderBuilder Order);

    void delete(Long id);

    void update(Order order);

}
