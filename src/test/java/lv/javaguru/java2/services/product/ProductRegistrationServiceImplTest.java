package lv.javaguru.java2.services.product;

import lv.javaguru.java2.database.ProductDAO;
import lv.javaguru.java2.domain.Product;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ProductRegistrationServiceImplTest {

    private ProductValidator validator;
    private ProductDAO dao;
    private ProductRegistrationService service;

    @Before
    public void init() {
        validator = mock(ProductValidator.class);
        dao = mock(ProductDAO.class);
        service = new ProductRegistrationServiceImpl(validator, dao);
    }

    private static final String PRODUCT_NAME = "productName";
    private static final String PRODUCT_CATEGORY = "productCategory";
    private static final Double PRODUCT_PRISE = 1.1;

    @Test
    public void shouldValidateAndThenSaveNewProductToDB() {
        service.register(PRODUCT_NAME, PRODUCT_CATEGORY, PRODUCT_PRISE);
        InOrder inOrder = inOrder(validator, dao);
        inOrder.verify(validator).validate(PRODUCT_NAME, PRODUCT_CATEGORY, PRODUCT_PRISE);
        inOrder.verify(dao).save(any(Product.class));
    }

    @Test
    public void shouldReturnSameProductInstanceThatStoredToDB() {
        when(dao.save(any(Product.class))).then(returnsFirstArg());
        Product product = service.register(PRODUCT_NAME, PRODUCT_CATEGORY, PRODUCT_PRISE);
        verify(dao).save(product);
    }

}