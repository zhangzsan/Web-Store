package lv.javaguru.java2.services.Order;

import lv.javaguru.java2.domain.User;

/**
 * Created by Vasja on 4/5/2017.
 */
public interface OrderRegistrationService {

    User register(String firstName,
                  String lastName,
                  String mail,
                  String password);

}
