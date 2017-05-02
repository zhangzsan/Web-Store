package lv.javaguru.java2.services.order;

import lv.javaguru.java2.database.OrderDAO;
import lv.javaguru.java2.database.jdbc.OrderDAOImpl;
import lv.javaguru.java2.domain.Order;

import java.util.Optional;

/**
 * Order editing implementation
 */
public class EditOrderServiceImpl implements EditOrderService{

    private OrderDAO orderDAO = new OrderDAOImpl();
    private OrderValidator orderValidator= new OrderValidatorImpl();

    @Override
    public void edit(Long userId,
                     Integer NewProductID,
                     Integer NewQuantity,
                     Integer NewProdpackID ){
        Optional<Order> userOpt = orderDAO.getById(userId);
        if (!OrderDAO.isPresent()) {
            throw new IllegalArgumentException("User not found by id = " + userId);
        }

        orderValidator.validate(NewProductID, NewQuantity, NewProdpackID);

        Order order = OrderDAO.get();
        order.setNewProductID(newProductID);
        order.setNewQuantity (newQuantity);
        orderDAO.update(order);
    }

}
