package lv.javaguru.java2.services.category;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CategoryValidatorImplTest {

    private CategoryValidator validator = new CategoryValidatorImpl();

    @Rule
    public ExpectedException thrown = ExpectedException.none();


    @Test
    public void shouldThrowExceptionWhenFirstNameIsNull() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Name must be not empty!");
        validator.validate(null);
    }

    @Test
    public void shouldThrowExceptionWhenFirstNameIsEmpty() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Name must be not empty!");
        validator.validate("");
    }
}
