package dataAccess;

import exception.QueryException;
import model.OrderLine;

import java.net.ConnectException;
import java.sql.Connection;
import java.util.ArrayList;

public class OrderLineDBAccess implements OrderLineDataAccess{

    private Connection connection;

    public OrderLineDBAccess()throws ConnectException {
        this.connection = SingletonConnection.getInstance();
    }

    @Override
    public ArrayList<OrderLine> getAllOrderLine() throws QueryException {
        return null;
    }
}
