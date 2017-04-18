package lv.javaguru.java2.database.jdbc;

import lv.javaguru.java2.database.CategoryDAO;
import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.domain.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Aster on 18.04.2017.
 */
public class CategoryDAOImpl extends DAOImpl implements CategoryDAO{
    @Override
    public Category save(Category category) throws DBException{
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("insert into categorydb values (default, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, category.getName());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()){
                category.setCategoryId(rs.getLong(1));
            }
        } catch (Throwable e) {
            System.out.println("Exception while execute CategoryDAOImpl.save()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }

        return category;    }

    @Override
    public Optional<Category> getById(Long id) throws DBException{
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from categorydb where CategoryID = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Category category = null;
            if (resultSet.next()) {
                category = new Category();
                category.setCategoryId(resultSet.getLong("CategoryID"));
                category.setName(resultSet.getString("Name"));
            }
            return Optional.ofNullable(category);

        } catch (Throwable e) {
            System.out.println("Exception while execute CategoryDAOImpl.getById()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }    }

    @Override
    public void delete(Long id) throws DBException{
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from categorydb where CategoryID = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute CategoryDAOImpl.delete()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public void update(Category category) throws DBException{
        if (category == null) {
            return;
        }

        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update categorydb set Name = ?" +
                            "where CategoryID = ?");
            preparedStatement.setString(1, category.getName());
            preparedStatement.setLong(2, category.getCategoryId());
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute CategoryDAOImpl.update()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public List<Category> getAll() throws DBException{
        List<Category> categories = new ArrayList<Category>();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from categorydb");

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Category category = new Category();
                category.setCategoryId(resultSet.getLong("CategoryID"));
                category.setName(resultSet.getString("Name"));
                categories.add(category);
            }
        } catch (Throwable e) {
            System.out.println("Exception while getting customer list CategoryDAOImpl.getList()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
        return categories;
    }
}
