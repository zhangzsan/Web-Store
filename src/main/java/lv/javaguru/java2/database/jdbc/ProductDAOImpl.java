package lv.javaguru.java2.database.jdbc;

import lv.javaguru.java2.database.ProductDAO;
import lv.javaguru.java2.domain.Product;

import java.util.List;
import java.util.Optional;

public class ProductDAOImpl extends DAOImpl implements ProductDAO {

    @Override
    public Product save(Product product) {
        return null;
    }

    @Override
    public Optional<Product> getById(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(Product product) {

    }

    @Override
    public List<Product> getAll() {
        return null;
    }
}
