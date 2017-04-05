package lv.javaguru.java2.services;

import lv.javaguru.java2.services.User.UserValidator;
import lv.javaguru.java2.services.User.UserValidatorImpl;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class UserValidatorImplTest {

    private UserValidator validator = new UserValidatorImpl();

    @Rule
    public ExpectedException thrown = ExpectedException.none();


    @Test
    public void shouldThrowExceptionWhenFirstNameIsNull() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("First Name must be not empty!");
        validator.validate(null, "password", "mail", "password");
    }

    @Test
    public void shouldThrowExceptionWhenFirstNameIsEmpty() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("First Name must be not empty!");
        validator.validate("", "password", "mail", "password");
    }

    // write more tests

}
