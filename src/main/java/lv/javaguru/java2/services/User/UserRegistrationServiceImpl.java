package lv.javaguru.java2.services.User;

import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.database.jdbc.UserDAOImpl;
import lv.javaguru.java2.domain.User;

import static lv.javaguru.java2.domain.UserBuilder.createUser;

public class UserRegistrationServiceImpl implements UserRegistrationService {

    private UserValidator userValidator = new UserValidatorImpl();
    private UserDAO userDAO = new UserDAOImpl();


    @Override
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

}