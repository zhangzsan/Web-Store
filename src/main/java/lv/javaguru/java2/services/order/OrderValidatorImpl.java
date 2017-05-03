package lv.javaguru.java2.services.order;

/**
 * Order creation validation. Variables Product ID and user mail (unique for each  client), quantity.
 */

public class OrderValidatorImpl implements OrderValidator {

    @Override
    public void validate(Integer productID,
                         Integer quantity,
                         Integer prodpackID) {
        validateProductID(productID);
        validateQuantity(quantity);
        validateProdpackID (prodpackID);
    }

    private void validateProdpackID(Integer prodpackID) {
        if (prodpackID == null){
            throw new IllegalArgumentException("Product ID must be not empty!");
        }
}
    private void validateProductID(Integer productID) {
        if (productID == null) {
            throw new IllegalArgumentException("Product ID must be not empty!");
        }
    }

    private void validateQuantity(Integer quantity) {
        if (quantity == null) {
            throw new IllegalArgumentException("Quantity must be not empty!");
        }
    }

}
