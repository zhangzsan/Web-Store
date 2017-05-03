package lv.javaguru.java2.services.user;

import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * Created by Mansur on 03.05.2017.
 */
public class UserRegistrationServiceImplTest {

    private UserValidator validator;
    private UserDAO dao;
    private UserRegistrationServiceImpl service;

    @Before
    public void init() {
        validator = mock(UserValidator.class);
        dao = mock(UserDAO.class);
        service = new UserRegistrationServiceImpl(validator, dao);
    }

    private static final String USER_NAME = "userName";
    private static final String USER_LASTNAME = "lastName";
    private static final String USER_MAIL = "userMail@";
    private static final String USER_PASSWORD = "userPassword";

    @Test
    public void shouldValidateAndThenSaveNewUserToDB() {
        service.register(USER_NAME, USER_LASTNAME, USER_MAIL, USER_PASSWORD);
        InOrder inOrder = inOrder(validator, dao);
        inOrder.verify(validator).validate(USER_NAME, USER_LASTNAME, USER_MAIL, USER_PASSWORD);
        inOrder.verify(dao).save(any(User.class));
    }

    @Test
    public void shouldReturnSameUserInstanceThatStoredToDB() {
        when(dao.save(any(User.class))).then(returnsFirstArg());
        User user = service.register(USER_NAME, USER_LASTNAME, USER_MAIL, USER_PASSWORD);
        verify(dao).save(user);
    }
}
