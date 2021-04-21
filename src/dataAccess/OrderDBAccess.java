package dataAccess;

import model.Order;

import java.net.ConnectException;
import java.sql.Connection;

public class OrderDBAccess implements OrderDataAccess{

    private Connection connection;

    public OrderDBAccess()throws ConnectException {
        this.connection = SingletonConnection.getInstance();
    }
}
