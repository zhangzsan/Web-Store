package lv.javaguru.java2.services.user;

import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;

/**
 * Created by Mansur on 16.05.2017.
 */
public class EditUserServiceImplTest {

    private UserValidator validator;
    private UserDAO dao;
    private EditUserServiceImpl service;

    @Before
    public void init() {
        validator = mock(UserValidator.class);
        dao = mock(UserDAO.class);
        service = new EditUserServiceImpl();
    }

    private static final long NEW_USER_ID = 55;
    private static final String NEW_USER_NAME = "newUserName";
    private static final String NEW_USER_LAST_NAME = "newLastName";
    private static final String NEW_USER_MAIL = "newUserMail@";
    private static final String NEW_USER_PASSWORD = "newUserPassword";

    @Test
    public void shouldValidateAndThenUpdateUserInDB() {
        service.edit(NEW_USER_ID, NEW_USER_NAME, NEW_USER_LAST_NAME, NEW_USER_MAIL, NEW_USER_PASSWORD);
        InOrder inOrder = inOrder(validator, dao);
        inOrder.verify(validator).validate(NEW_USER_NAME, NEW_USER_LAST_NAME, NEW_USER_MAIL, NEW_USER_PASSWORD);
        inOrder.verify(dao).update(any(User.class));
    }

}