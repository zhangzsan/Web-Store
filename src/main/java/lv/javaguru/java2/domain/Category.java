package lv.javaguru.java2.domain;

/**
 * Created by Aster on 18.04.2017.
 */
public class Category {

    private Long categoryId;
    private String name;

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
