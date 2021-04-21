package dataAccess;

import model.OrderLine;

import java.net.ConnectException;
import java.sql.Connection;

public class OrderLineDBAccess implements OrderDataAccess{

    private Connection connection;

    public OrderLineDBAccess()throws ConnectException {
        this.connection = SingletonConnection.getInstance();
    }
}
