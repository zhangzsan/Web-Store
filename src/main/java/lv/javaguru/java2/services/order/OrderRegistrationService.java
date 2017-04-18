package lv.javaguru.java2.services.order;

import lv.javaguru.java2.domain.Order;

/**
 * Created by Vasja on 4/5/2017.
 */
public interface OrderRegistrationService {

    Order register(Integer product,
                  String mail);

}
