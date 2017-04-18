package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.Order;
import lv.javaguru.java2.domain.User;
import java.util.List;
import java.util.Optional;

public interface OrderDAO {

    Order save(Order Order);

    Optional<User> getById(Long id);

    void delete(Long id);

    void update(User user);

    List<User> getAll();

}
