package lv.javaguru.java2.services.order;

/**
 * Order update
 */
public interface EditOrderService {

    void update(Integer productID,
              Integer quantity,
              Integer prodpackID
              );

}
