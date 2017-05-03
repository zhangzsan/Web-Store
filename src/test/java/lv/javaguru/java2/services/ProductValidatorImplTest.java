package lv.javaguru.java2.services;

import lv.javaguru.java2.services.product.ProductValidator;
import lv.javaguru.java2.services.product.ProductValidatorImpl;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ProductValidatorImplTest {

    private ProductValidator validator = new ProductValidatorImpl();

    @Rule
    public ExpectedException thrown = ExpectedException.none();


    @Test
    public void shouldThrowExceptionWhenProductNameIsNull() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Product Name must be not empty!");
        validator.validate(null, "productCategory", 1.1);
    }

    @Test
    public void shouldThrowExceptionWhenProductNameIsEmpty() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Product Name must be not empty!");
        validator.validate("", "productCategory", 1.1);
    }

    @Test
    public void shouldThrowExceptionWhenProductCategoryIsNull() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Product Category must be not empty!");
        validator.validate("productName", null, 1.1);
    }

    @Test
    public void shouldThrowExceptionWhenProductCategoryIsEmpty() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Product Name must be not empty!");
        validator.validate("productName", "", 1.1);
    }

    @Test
    public void shouldThrowExceptionWhenProductPriceIsNull() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Product Price must be not empty!");
        validator.validate("productName", "productCategory", null);
    }
}
