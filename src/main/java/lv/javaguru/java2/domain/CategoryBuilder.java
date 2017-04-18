package lv.javaguru.java2.domain;

/**
 * Created by Aster on 18.04.2017.
 */
public class CategoryBuilder {

    private String name;

    private CategoryBuilder() {}

    public static CategoryBuilder createCategory() {
        return new CategoryBuilder();
    }

    public Category build() {
        Category category = new Category();
        category.setName(name);
        return category;
    }

    public CategoryBuilder withName(String name) {
        this.name = name;
        return this;
    }
}
