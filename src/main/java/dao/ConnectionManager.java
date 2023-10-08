package dao;

import exception.DaoException;
import util.PropertiesUtil;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public final class ConnectionManager {
    public static final String DB_URL = "db.url";
    public static final String DB_USERNAME = "db.username";
    public static final String DB_PASSWORD = "db.password";
    public static final String DB_POOL_SIZE = "db.pool.size";

    private static final Integer DEFAULT_POOL_SIZE = 10;
    private static BlockingQueue<Connection> pool;
    private static List<Connection> sourceConnections;

    private ConnectionManager() {}

    /*  Создает пул соединений, который хранит соединения в виде Proxy.
        Также возвращает их обратно и добавляет в pool, если соединения будут
        закрываться после выполнения, через метод close().

        sourceConnections список всех соединения, которые можно закрыть
        при необходимости через метод closePool.
     */
    static {
        var poolSize = PropertiesUtil.get(DB_POOL_SIZE);
        var size = poolSize == null ?
                DEFAULT_POOL_SIZE : Integer.parseInt(poolSize);
        pool = new ArrayBlockingQueue<>(Integer.valueOf(size));
        sourceConnections = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            var connection = getConnection();
            var proxyConnection = (Connection) Proxy.newProxyInstance(
                    ConnectionManager.class.getClassLoader(),
                    new Class[]{Connection.class},
                    (proxy, method, args) -> method.getName().equals("close") ?
                            pool.add(connection) :
                            method.invoke(connection, args));
            pool.add(proxyConnection);
            sourceConnections.add(connection);
        }
    }

    public static Connection getConnection() {
        try {
            return pool.take();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static Connection openConnection() {
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

    // Закрывает все Connection
    public static void closePoll() {
        try {
            for (Connection sourceConnection : sourceConnections) {
                sourceConnection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
