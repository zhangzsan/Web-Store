package lv.javaguru.java2.services.order;

import lv.javaguru.java2.domain.Order;

/**
 * Order Registration Service Interface
 * Order created after all products has been added to list
 * Variables Product ID, user mail (unique for each  client), quantity
 * Product ID and user mail not empty. Quantity 1-99 in case if not defined that shows 1
 *
 */
public interface OrderRegistrationService {

    Order register(Integer productID,
                   String mail,
                   Integer quantity);

}
