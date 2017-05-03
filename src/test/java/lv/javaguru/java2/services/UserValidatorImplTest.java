package lv.javaguru.java2.services;

import lv.javaguru.java2.services.user.UserValidator;
import lv.javaguru.java2.services.user.UserValidatorImpl;
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
        validator.validate(null, "lastName", "mail", "password");
    }

    @Test
    public void shouldThrowExceptionWhenFirstNameIsEmpty() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("First Name must be not empty!");
        validator.validate("", "lastName", "mail", "password");
    }

    @Test
    public void shouldThrowExceptionWhenLastNameIsNull() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Last Name must be not empty!");
        validator.validate("firstName", null, "mail", "password");
    }

    @Test
    public void shouldThrowExceptionWhenLastNameIsEmpty() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Last Name must be not empty!");
        validator.validate("firstName", "", "mail", "password");
    }

    @Test
    public void shouldThrowExceptionWhenMailIsNull() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Mail must be not empty!");
        validator.validate("firstName", "lastName", null, "password");
    }

    @Test
    public void shouldThrowExceptionWhenMailIsEmpty() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Mail must be not empty!");
        validator.validate("firstName", "lastName", "", "password");
    }

    @Test
    public void shouldThrowExceptionWhenPasswordIsNull() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Password must be not empty!");
        validator.validate("firstName", "lastName", "mail", null);
    }

    @Test
    public void shouldThrowExceptionWhenPasswordIsEmpty() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Password must be not empty!");
        validator.validate("firstName", "lastName", "mail", "");
    }

    @Test
    public void shouldThrowExceptionWhenPasswordIsShort() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Password must be longer!");
        validator.validate("firstName", "lastName", "mail", "less8");
    }

    // write more tests

}
