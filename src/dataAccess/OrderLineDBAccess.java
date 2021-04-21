package dataAccess;

import exception.QuerySelectException;
import model.Order;
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
    public ArrayList<OrderLine> getAllOrderLine() throws QuerySelectException {
        ArrayList<OrderLine> allOrderLine = new ArrayList<>();
        //Accès à la base de données
        return allOrderLine;
    }
}
