package lv.javaguru.java2.services.Category;

/**
 * Created by Aster on 18.04.2017.
 */
public class CategoryValidatorImpl implements CategoryValidator{
    @Override
    public void validate(String name) {
        validateName(name);
    }

    private void validateName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Category name must be not empty!");
        }
    }
}
