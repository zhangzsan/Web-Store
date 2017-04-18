package lv.javaguru.java2.services.Category;

import lv.javaguru.java2.database.CategoryDAO;
import lv.javaguru.java2.database.jdbc.CategoryDAOImpl;
import lv.javaguru.java2.domain.Category;

import java.util.Optional;

/**
 * Created by Aster on 18.04.2017.
 */
public class EditCategoryServiceImpl implements EditCategoryService{

    private CategoryDAO categoryDAO = new CategoryDAOImpl();
    private CategoryValidator categoryValidator = new CategoryValidatorImpl();

    @Override
    public void edit(Long categoryId,
                     String newName) {
        Optional<Category> categoryOpt = categoryDAO.getById(categoryId);
        if (!categoryOpt.isPresent()) {
            throw new IllegalArgumentException("Category not found by id = " + categoryId);
        }

        categoryValidator.validate(newName);

        Category category = categoryOpt.get();
        category.setName(newName);
        categoryDAO.update(category);
    }
}
