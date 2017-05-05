package lv.javaguru.java2.services.order;

import lv.javaguru.java2.database.OrderDAO;
import lv.javaguru.java2.database.jdbc.OrderDAOImpl;
import lv.javaguru.java2.domain.Order;
import lv.javaguru.java2.domain.OrderBuilder;
import static lv.javaguru.java2.domain.OrderBuilder.createOrder;


public class OrderRegistrationServiceImpl implements OrderRegistrationService{

    private OrderValidator orderValidator = new OrderValidatorImpl();
    private OrderDAO orderDAO = new OrderDAOImpl();


    @Override
    public Order register(Integer productID,
                          String mail,
                          Integer quantity,
                          Integer prodpackID) {
        orderValidator.validate(productID, quantity, prodpackID);

        OrderBuilder order = createOrder()
                .withProductID(productID)
                .withMail(mail)
                .withQuantity(quantity)
                .withProdpackID(prodpackID);

        return orderDAO.save(order);
    }


}
