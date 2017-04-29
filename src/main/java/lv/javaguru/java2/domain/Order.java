package lv.javaguru.java2.domain;

/**
 * Order domain
 */
public class Order {
    private Long userId;
    private Integer productID;
    private String mail;
    private Integer quantity;
    private Integer prodpackID;
    public Order withProdpackID;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getProdpackID() { return prodpackID; }

    public void setProdPackID(Integer prodPackID) {
        this.prodpackID = prodPackID;
    }
}
