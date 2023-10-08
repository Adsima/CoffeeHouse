package dao;

import exception.DaoException;
import model.event.*;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

public class EventDao {

    private static final EventDao INSTANCE = new EventDao();

    private static final String REGISTERED_EVENT_SQL = """
            INSERT INTO ch_events (order_id, client_id,
            employee_id, expected_time, product_id,
            price, date_time)
            VALUES (?, ?, ?, ?, ?, ?, ?);
            """;

    private static final String CANCELLED_EVENT_SQL = """
            INSERT INTO ch_events (order_id, employee_id, reason, date_time)
            VALUES(?, ?, ?, ?);
            """;

    private static final String STARTED_EVENT_SQL = """
            INSERT INTO ch_events (order_id, employee_id, date_time)
            VALUES(?, ?, ?);
            """;

    private static final String READY_EVENT_SQL = """
            INSERT INTO ch_events (order_id, employee_id, date_time)
            VALUES(?, ?, ?);
            """;

    private static final String COMPLETED_EVENT_SQL = """
            INSERT INTO ch_events (order_id, employee_id, date_time)
            VALUES(?, ?, ?);
            """;

    public void saveRegisteredEvent(OrderRegisteredEvent registeredEvent) {
        try (var connection = ConnectionManager.getConnection();
             var prepareStatement = connection
                     .prepareStatement(REGISTERED_EVENT_SQL, Statement.RETURN_GENERATED_KEYS)) {

            prepareStatement.setLong(1, registeredEvent.getOrder().getOrderId());
            prepareStatement.setLong(2, registeredEvent.getClientId());
            prepareStatement.setLong(3, registeredEvent.getEmployeeId());
            prepareStatement.setTimestamp(4, Timestamp.valueOf(registeredEvent.getExecutedTime()));
            prepareStatement.setLong(5, registeredEvent.getProductId());
            prepareStatement.setBigDecimal(6, registeredEvent.getProductCost());
            prepareStatement.setTimestamp(7, Timestamp.valueOf(registeredEvent.getTime()));

            prepareStatement.executeUpdate();

        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public void saveCancelledEvent(OrderCancelledEvent cancelledEvent) {
        try (var connection = ConnectionManager.getConnection();
             var prepareStatement = connection
                     .prepareStatement(CANCELLED_EVENT_SQL, Statement.RETURN_GENERATED_KEYS)) {

            prepareStatement.setLong(1, cancelledEvent.getOrder().getOrderId());
            prepareStatement.setLong(2, cancelledEvent.getEmployeeId());
            prepareStatement.setString(3, cancelledEvent.getReason());
            prepareStatement.setTimestamp(4, Timestamp.valueOf(cancelledEvent.getTime()));

            prepareStatement.executeUpdate();

        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public void saveStartedEvent (OrderStartedEvent startedEvent) {
        try (var connection = ConnectionManager.getConnection();
             var prepareStatement = connection
                     .prepareStatement(STARTED_EVENT_SQL, Statement.RETURN_GENERATED_KEYS)) {

            prepareStatement.setLong(1, startedEvent.getOrder().getOrderId());
            prepareStatement.setLong(2, startedEvent.getEmployeeId());
            prepareStatement.setTimestamp(3, Timestamp.valueOf(startedEvent.getTime()));

            prepareStatement.executeUpdate();

        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public void saveReadyEvent(OrderReadyEvent readyEvent) {
        try (var connection = ConnectionManager.getConnection();
             var prepareStatement = connection
                     .prepareStatement(READY_EVENT_SQL, Statement.RETURN_GENERATED_KEYS)) {

            prepareStatement.setLong(1, readyEvent.getOrder().getOrderId());
            prepareStatement.setLong(2, readyEvent.getEmployeeId());
            prepareStatement.setTimestamp(3, Timestamp.valueOf(readyEvent.getTime()));

            prepareStatement.executeUpdate();

        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public void saveCompletedEvent(OrderCompletedEvent completedEvent) {
        try (var connection = ConnectionManager.getConnection();
             var prepareStatement = connection
                     .prepareStatement(COMPLETED_EVENT_SQL, Statement.RETURN_GENERATED_KEYS)) {

            prepareStatement.setLong(1, completedEvent.getOrder().getOrderId());
            prepareStatement.setLong(2, completedEvent.getEmployeeId());
            prepareStatement.setTimestamp(3, Timestamp.valueOf(completedEvent.getTime()));

            prepareStatement.executeUpdate();

        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public static EventDao getInstance() {
        return INSTANCE;
    }
}
