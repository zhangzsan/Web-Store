package lv.javaguru.java2.services.category;

import lv.javaguru.java2.database.CategoryDAO;
import lv.javaguru.java2.domain.Category;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InOrder;
import org.mockito.Mockito;

import java.util.Optional;

import static lv.javaguru.java2.domain.CategoryBuilder.createCategory;

public class EditCategoryServiceImplTest {

    private CategoryDAO dao;
    private CategoryValidator validator;

    private EditCategoryService service;

    @Before
    public void init() {
        dao = Mockito.mock(CategoryDAO.class);
        validator = Mockito.mock(CategoryValidator.class);
        service = new EditCategoryServiceImpl(dao, validator);
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private static final Long CATEGORY_ID = 1L;
    private static final String CATEGORY_OLD_NAME = "old_name";
    private static final String CATEGORY_NEW_NAME = "new_name";

    @Test
    public void shouldThrowExceptionWhenCategoryNotPresent() {
        Mockito.doReturn(Optional.empty()).when(dao).getById(CATEGORY_ID);

        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Category not found by id = " + CATEGORY_ID);

        service.edit(CATEGORY_ID, CATEGORY_NEW_NAME);
    }

    @Test
    public void shouldInvokeValidator() {
        Category category = createCategory()
                .withName(CATEGORY_OLD_NAME).build();
        Mockito.doReturn(Optional.of(category)).when(dao).getById(CATEGORY_ID);

        service.edit(CATEGORY_ID, CATEGORY_NEW_NAME);

        InOrder inOrder = Mockito.inOrder(validator, dao);
        inOrder.verify(validator).validate(CATEGORY_NEW_NAME);
        inOrder.verify(dao).update(category);
    }

}
