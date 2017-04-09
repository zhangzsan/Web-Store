package lv.javaguru.java2.services.Product;

import lv.javaguru.java2.database.ProductDAO;
import lv.javaguru.java2.database.jdbc.ProductDAOImpl;
import lv.javaguru.java2.domain.Product;

import java.util.Optional;

/**
 * Created by Aster on 09.04.2017.
 */
public class EditProductServiceImpl implements EditProductService{

    private ProductDAO productDAO = new ProductDAOImpl();
    private ProductValidator productValidator = new ProductValidatorImpl();

    @Override
    public void edit(Long productId, String newProductName, String newProductCategory, Double newPrice) {

        Optional<Product> productOpt = productDAO.getById(productId);
        if (!productOpt.isPresent()) {
            throw new IllegalArgumentException("User not found by id = " + productId);
        }

        productValidator.validate(newProductName, newProductCategory, newPrice);

        Product product = productOpt.get();
        product.setProductName(newProductName);
        product.setProductCategory(newProductCategory);
        productDAO.update(product);
    }
}
