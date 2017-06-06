package lv.javaguru.java2.services.category;

import lv.javaguru.java2.database.CategoryDAO;
import lv.javaguru.java2.domain.Category;
import org.springframework.stereotype.Component;

/**
 * Created by Aster on 18.04.2017.
 */
@Component
public class EditCategoryServiceImpl implements EditCategoryService{

    private CategoryDAO categoryDAO;
    private CategoryValidator categoryValidator;

    public EditCategoryServiceImpl(CategoryDAO categoryDAO,
                                   CategoryValidator categoryValidator) {
        this.categoryDAO = categoryDAO;
        this.categoryValidator = categoryValidator;
    }

    @Override
    public void edit(Long categoryId,
                     String newName) {
        categoryValidator.validate(newName);

        Category category = categoryDAO.getById(categoryId)
                .orElseThrow(() -> new IllegalArgumentException("Category not found by id = " + categoryId));

        category.setName(newName);
        categoryDAO.update(category);
    }
}
