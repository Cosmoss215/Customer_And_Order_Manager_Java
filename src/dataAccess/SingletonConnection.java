package dataAccess;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnection {
    private static Connection connection = null;
    private static String url = "jdbc:mysql://localhost:3306/library";
    private static String id = " root";
    private static String password = "Manil93Manderlier97";

    private SingletonConnection() throws ConnectException{
        try{
            connection = DriverManager.getConnection(url,id,password);
        } catch (SQLException troubles) {
            throw new ConnectException();
        }
    }

    public static Connection getInstance() throws ConnectException{
        if (connection == null){
            new SingletonConnection();
        }
        return connection;
    }

}
