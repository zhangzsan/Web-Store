package lv.javaguru.java2.services.order;

import lv.javaguru.java2.database.OrderDAO;
import lv.javaguru.java2.database.jdbc.OrderDAOImpl;

/**
 * Order update implementation
 */
public class EditOrderServiceImpl implements EditOrderService{

    private OrderDAO orderDAO = new OrderDAOImpl();
    private OrderValidator orderValidator= new OrderValidatorImpl();

/*    @Override
    public void update(Long userId,
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
    }*/

    @Override
    public void update(Integer productID,
                       Integer quantity,
                       Integer prodpackID) {

    }
}
