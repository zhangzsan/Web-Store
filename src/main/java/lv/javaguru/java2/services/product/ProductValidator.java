package lv.javaguru.java2.services.product;

/**
 * Created by Aster on 05.04.2017.
 */
public interface ProductValidator {
    void validate(String productName,
                  String productCategory,
                  Double price);
}
