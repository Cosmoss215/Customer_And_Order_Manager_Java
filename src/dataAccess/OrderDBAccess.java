package dataAccess;

import exception.ConnectionException;
import exception.SelectQueryException;
import model.Order;
import java.sql.Connection;
import java.util.ArrayList;

public class OrderDBAccess implements OrderDataAccess{

    private Connection connection;

    public OrderDBAccess()throws ConnectionException {
        this.connection = SingletonConnection.getInstance();
    }

    @Override
    public ArrayList<Order> getAllOrders() throws SelectQueryException {
        ArrayList<Order> allOrders = new ArrayList<>();
        //Accès à la base de données
        return allOrders;
    }

    @Override
    public boolean addCustomer(Order order) {
        return false;
    }

    @Override
    public Order getCustomerById(Integer id) {
        return null;
    }

    @Override
    public boolean update(Order order) {
        return false;
    }

    @Override
    public boolean delete(Order order) {
        return false;
    }
}
