package lv.javaguru.java2.services.product;

import lv.javaguru.java2.database.ProductDAO;
import lv.javaguru.java2.domain.Product;

import static lv.javaguru.java2.domain.ProductBuilder.createProduct;

/**
 * Created by Aster on 05.04.2017.
 */
public class ProductRegistrationServiceImpl implements ProductRegistrationService {

    private ProductValidator productValidator;
    private ProductDAO productDAO;

    public ProductRegistrationServiceImpl(ProductValidator productValidator,
                                          ProductDAO productDAO) {
        this.productValidator = productValidator;
        this.productDAO = productDAO;
    }

    @Override
    public Product register(String productName,
                            String productCategory,
                            Double price)  {
            productValidator.validate(productName, productCategory, price);

            Product product = createProduct()
                    .withProductName(productName)
                    .withProductCategory(productCategory)
                    .withPrice(price).build();

            return productDAO.save(product);
    }
}
