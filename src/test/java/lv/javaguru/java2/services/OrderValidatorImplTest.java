package lv.javaguru.java2.services;

import lv.javaguru.java2.services.order.OrderValidator;
import lv.javaguru.java2.services.order.OrderValidatorImpl;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Validation test
 */
public class OrderValidatorImplTest {
    private OrderValidator validator = new OrderValidatorImpl();

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
}
