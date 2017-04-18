package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.Category;

import java.util.List;
import java.util.Optional;

/**
 * Created by Aster on 18.04.2017.
 */
public interface CategoryDAO {

    Category save(Category product);

    Optional<Category> getById(Long id);

    void delete(Long id);

    void update(Category product);

    List<Category> getAll();
}
