package lv.javaguru.java2.database.jdbc;

        import lv.javaguru.java2.database.DBException;
        import lv.javaguru.java2.database.OrderDAO;
        import lv.javaguru.java2.domain.Order;
        import lv.javaguru.java2.domain.OrderBuilder;
        import org.springframework.stereotype.Component;

        import java.sql.Connection;
        import java.sql.PreparedStatement;
        import java.sql.ResultSet;
        import java.util.List;

/**
 * Order DAO
 * Logic of adding order to Data Base
 *
 */
@Component
public class OrderDAOImpl extends DAOImpl implements OrderDAO {

    public Order save(OrderBuilder order) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("insert into ORDERS values (default, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, order.getProductID());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()){
                order.setProdPackID(rs.getInt(1));
            }
        } catch (Throwable e) {
            System.out.println("Exception while execute orderDAOImpl.save()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }

        return order;
    }

    public void delete(Long id) throws DBException {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from USERS where UserID = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute UserDAOImpl.delete()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

//    Communication with DB for updates
    public void update(Order order) throws DBException {
        if (order == null) {
            return;
        }

        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update USERS ORDER set ProductID = ?, Quantity = ? " +
                            "where ProdpackID = ?");
            preparedStatement.setInt(1, order.getProdpackID());
            preparedStatement.setInt(2, order.getProductID());
            preparedStatement.setInt(3, order.getQuantity());
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute UserDAOImpl.update()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }
}
