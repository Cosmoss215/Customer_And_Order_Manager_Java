package dataAccess;

import exception.ConnectionException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnection {
    private static Connection connection = null;
    private static String url = "jdbc:mysql://localhost:3306/library";
    private static String id = "root";
    private static String password = "****";

    private SingletonConnection() throws ConnectionException {
        try{
            connection = DriverManager.getConnection(url, id, password);
        } catch (SQLException exception) {
            throw new ConnectionException(exception.getMessage());
        }
    }
    public static Connection getInstance() throws ConnectionException {
        if (connection == null) {
            new SingletonConnection();
        }
        return connection;
    }

}
