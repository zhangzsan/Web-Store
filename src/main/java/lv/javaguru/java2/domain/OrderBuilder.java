package lv.javaguru.java2.domain;

public class OrderBuilder {


    private Integer productID;
    private String mail;
    private Integer quantity;
    private Integer prodpackID;


    private OrderBuilder() {}

    public static OrderBuilder createOrder() {
        return new OrderBuilder();
    }

    public Order build() {
        Order order = new Order();
        order.setProductID(productID);
        order.setMail(mail);
        order.setQuantity(quantity);
        order.setProductID(prodpackID);
        return order;
    }

    public OrderBuilder withProductID(Integer productID) {
        this.productID = productID;
        return this;
    }

    public OrderBuilder withMail(String mail) {
        this.mail = mail;
        return this;
    }

    public OrderBuilder withQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public OrderBuilder withProdpackID(Integer productID){
        this.prodpackID = prodpackID;
        return this;
    }

}
