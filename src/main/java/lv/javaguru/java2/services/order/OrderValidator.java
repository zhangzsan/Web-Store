package lv.javaguru.java2.services.Order;

/**
 * Order Validator
 *
 */
public interface OrderValidator
{
    void validate(Integer productID,
                  String mail,
                  Integer quantity);
}
