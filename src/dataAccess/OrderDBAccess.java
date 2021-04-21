package dataAccess;

import exception.QueryException;
import model.Order;

import java.net.ConnectException;
import java.sql.Connection;
import java.util.ArrayList;

public class OrderDBAccess implements OrderDataAccess{

    private Connection connection;

    public OrderDBAccess()throws ConnectException {
        this.connection = SingletonConnection.getInstance();
    }

    @Override
    public ArrayList<Order> getAllOrders() throws QueryException {
        return null;
    }
}
