package dataAccess;

import exception.ConnectionException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnection {
    private static Connection connection = null;
    private static String url = "jdbc:mysql://localhost:3306/library"; //"jdbc:mysql://localhost:3306/library?useSSL=false"
    private static String id = "DBAdmin"; //"root"
    private static String password = "sinderilIG2B"; //"Manil93Manderlier97"

    private SingletonConnection() throws ConnectionException {
        try{
            connection = DriverManager.getConnection(url, id, password);
        } catch (SQLException troubles) {
            System.out.println(troubles.getMessage());
            throw new ConnectionException();
        }
    }

    public static Connection getInstance() throws ConnectionException {
        if (connection == null) {
            new SingletonConnection();
        }
        return connection;
    }

}
