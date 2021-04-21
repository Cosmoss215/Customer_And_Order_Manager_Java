package dataAccess;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnection {
    private static Connection connection = null;
    private static String url = "https://databases.000webhost.com/db_sql.php?db=id15012105_orderandinvoicedb";
    private static String id = " id15012105_orderandinvoice";
    private static String passeword = "Manil93Manderlier97%";

    private SingletonConnection() throws ConnectException{
        try{
            connection = DriverManager.getConnection(url,id,passeword);
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
