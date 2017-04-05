package lv.javaguru.java2.domain;

/**
 * Created by Aster on 05.04.2017.
 */
public class ProductBuilder {

    private String productName;
    private String productCategory;
    private Double price;


    private ProductBuilder() {}

    public static ProductBuilder createUser() {
        return new ProductBuilder();
    }

    public Product build() {
        Product product = new Product();
        product.setProductName(productName);
        product.setProductCategory(productCategory);
        product.setPrice(price);
        return product;
    }

    public ProductBuilder withProductName(String productName) {
        this.productName = productName;
        return this;
    }

    public ProductBuilder withProductCategory(String productCategory) {
        this.productCategory = productCategory;
        return this;
    }

    public ProductBuilder withPrice(Double price) {
        this.price = price;
        return this;
    }

}
