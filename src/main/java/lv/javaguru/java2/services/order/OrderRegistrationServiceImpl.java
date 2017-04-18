package lv.javaguru.java2.services.order;

import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.database.jdbc.UserDAOImpl;
import lv.javaguru.java2.domain.Order;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.services.user.UserValidator;
import lv.javaguru.java2.services.user.UserValidatorImpl;

import static lv.javaguru.java2.domain.UserBuilder.createUser;

public class OrderRegistrationServiceImpl implements OrderRegistrationService {

    private UserValidator userValidator = new UserValidatorImpl();
    private UserDAO userDAO = new UserDAOImpl();


    //@Override
    public User register(String firstName,
                         String lastName,
                         String mail,
                         String password) {
        userValidator.validate(firstName, lastName, mail, password);

        User user = createUser()
                .withFirstName(firstName)
                .withLastName(lastName)
                .withMail(mail)
                .withPassword(password).build();

        return userDAO.save(user);
    }

    @Override
    public Order register(Integer product, String mail) {
        return null;
    }
}
