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
        thrown.expectMessage("Product ID must be not empty!");
        validator.validate(null, "quantity", "prodpackID");
    }

    @Test
    public void shouldThrowExceptionWhenFirstNameIsEmpty() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Product ID must be not empty!");
        validator.validate("", "quantity", "prodpackID");
    }
}
//(Integer productID,
//        String mail,
//        Integer quantity,
//        Integer prodpackID)