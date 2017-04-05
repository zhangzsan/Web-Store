package lv.javaguru.java2.services.Product;

import lv.javaguru.java2.domain.Product;

public interface ProductRegistrationService {

    Product register(String productName,
                     String productCategory,
                     Double price);


}
