package lv.javaguru.java2.services.order;

/**
 * Order Validator
 *
 */
public interface OrderValidator
{
    void validate(Integer productID, Integer quantity, Integer prodpackID);

}
