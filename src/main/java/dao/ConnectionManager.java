package dao;

import exception.DaoException;
import util.PropertiesUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionManager {
    public static final String DB_URL = "db.url";
    public static final String DB_USERNAME = "db.username";
    public static final String DB_PASSWORD = "db.password";

    private ConnectionManager() {}

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    PropertiesUtil.get(DB_URL),
                    PropertiesUtil.get(DB_USERNAME),
                    PropertiesUtil.get(DB_PASSWORD)
            );
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
}
