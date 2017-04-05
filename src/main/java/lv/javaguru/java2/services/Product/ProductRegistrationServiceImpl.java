package lv.javaguru.java2.services.Product;

/**
 * Created by Aster on 05.04.2017.
 */
public class ProductRegistrationServiceImpl implements ProductRegistrationService {
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
