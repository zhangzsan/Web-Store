package lv.javaguru.java2.database.jdbc;

        import lv.javaguru.java2.database.DBException;
        import lv.javaguru.java2.database.OrderDAO;
        import lv.javaguru.java2.domain.Order;
        import lv.javaguru.java2.domain.OrderBuilder;
        import org.springframework.stereotype.Component;

        import java.sql.Connection;
        import java.sql.PreparedStatement;
        import java.sql.ResultSet;
        import java.util.ArrayList;
        import java.util.List;
        import java.util.Optional;

/**
 * Order DAO
 * Logic of adding order to Data Base
 *
 */
@Component
public class OrderDAOImpl extends DAOImpl implements OrderDAO {

    public Order save(OrderBuilder Order) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("insert into ORDERS values (default, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, order.getproductid());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()){
                order.setOrderId(rs.getLong(1));
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

    public Optional<Order> getById(Long id) throws DBException {
        Connection connection = null; //** Open connection with DB

        try { //**
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from orderS where orderID = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Order order = null;
            if (resultSet.next()) {
                order = new Order();
                order.setUserId(resultSet.getLong("UserID"));
                order.setOrderID(resultSet.getLong("Order ID"));
                order.setLastName(resultSet.getString("LastName"));
            }
            return Optional.ofNullable(order);
        } catch (Throwable e) {
            System.out.println("Exception while execute UserDAOImpl.getById()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    public List<Order> getAll() throws DBException {
        List<Order> orders = new ArrayList<Order>();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from ORDERS");

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Order order = new Order();
                order.setUserId(resultSet.getLong("UserID"));
                order.setProdPackID(resultSet.getInt("ProdPackID"));
                order.setLastName(resultSet.getString("LastName"));
                orders.add(order);
            }
        } catch (Throwable e) {
            System.out.println("Exception while getting customer list UserDAOImpl.getList()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
        return orders;
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
            preparedStatement.setString(1, order.getProdpackID());
            preparedStatement.setString(2, order.getProductID());
            preparedStatement.setString(3, order.getQuantity());
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
