package lv.javaguru.java2.services.Product;

/**
 * Created by Aster on 09.04.2017.
 */
public interface EditProductService {
    void edit(Long productId,
            String newProductName,
            String newProductCategory,
            Double newPrice);
}
