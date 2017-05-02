package lv.javaguru.java2.services.order;

/**
 * Order editing
 */
public interface EditOrderService {

    void edit(Integer productID,
              Integer quantity,
              Integer prodpackID
              );

}
