package lv.javaguru.java2.services.User;

import lv.javaguru.java2.domain.User;

public interface UserRegistrationService {

    User register(String firstName,
                  String lastName,
                  String mail,
                  String password);

}