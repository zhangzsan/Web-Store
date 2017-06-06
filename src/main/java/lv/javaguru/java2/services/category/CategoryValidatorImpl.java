package lv.javaguru.java2.services.category;

import org.springframework.stereotype.Component;

/**
 * Created by Aster on 18.04.2017.
 */
@Component
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
