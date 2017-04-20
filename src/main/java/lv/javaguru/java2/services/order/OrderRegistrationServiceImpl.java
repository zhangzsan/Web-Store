package lv.javaguru.java2.services.Order;

import lv.javaguru.java2.database.OrderDAO;
import lv.javaguru.java2.database.jdbc.OrderDAOImpl;
import lv.javaguru.java2.domain.Order;
import lv.javaguru.java2.services.order.OrderRegistrationService;
import lv.javaguru.java2.services.order.OrderValidator;
import lv.javaguru.java2.services.order.OrderValidatorImpl;
import static lv.javaguru.java2.domain.OrderBuilder.createOrder;

public class OrderRegistrationServiceImpl implements OrderRegistrationService{

    private OrderValidator orderValidator = new OrderValidatorImpl();
    private OrderDAO orderDAO = new OrderDAOImpl();


    @Override
    public Order register(Integer productID,
                          String mail,
                          Integer quantity) {
        orderValidator.validate(productID, mail, quantity);

        Order order = createOrder()
                .withProductID(productID)
                .withMail(mail)
                .withQuantity(quantity).build();

        return orderDAO.save(order);
    }


}
