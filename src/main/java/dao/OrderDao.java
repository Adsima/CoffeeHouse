package dao;

import exception.DaoException;
import model.Order;
import model.status.OrderStatus;

import java.sql.*;
import java.time.LocalDateTime;

public class OrderDao {

    private static final OrderDao INSTANCE = new OrderDao();

    private OrderDao() {}

    private static final String SAVE_ORDER = """
            INSERT INTO ch_orders (order_status, order_time)
            VALUES (?, ?);
            """;

    public Order saveOrder(Order order) {
        try (var connection = ConnectionManager.getConnection();
        var prepareStatement = connection
                .prepareStatement(SAVE_ORDER, Statement.RETURN_GENERATED_KEYS)) {

            prepareStatement.setString(1, order.getStatus().toString());
            prepareStatement.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now()));

            prepareStatement.executeUpdate();
            setOrderId(order, prepareStatement);

            return order;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    private void setOrderId(Order order, PreparedStatement prepareStatement) throws SQLException {
        ResultSet generatedKeys = prepareStatement.getGeneratedKeys();

        if (generatedKeys.next()) {
            order.setOrderId(generatedKeys.getLong("id"));
        }
    }

    

}
