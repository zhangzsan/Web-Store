package lv.javaguru.java2.services.product;

/**
 * Created by Aster on 05.04.2017.
 */
public class ProductValidatorImpl implements ProductValidator{
    @Override
    public void validate(String productName,
                         String productCategory,
                         Double price) {
            validateProductName(productName);
            validateProductCategory(productCategory);
            validatePrice(price);
        }

    private void validateProductName(String productName) {
        if (productName == null || productName.isEmpty()) {
            throw new IllegalArgumentException("Product Name must be not empty!");
        }
    }

    private void validateProductCategory(String productCategory) {
        if (productCategory == null || productCategory.isEmpty()) {
            throw new IllegalArgumentException("Product Category must be not empty!");
        }
    }

    private void validatePrice(Double price) {
        if (price == null) {
            throw new IllegalArgumentException("Price must be not empty!");
        }
    }

}
