package business;

import dataAccess.OrderDataAccess;
import dataAccess.OrderDBAccess;
import exception.QueryException;
import model.Order;

import java.net.ConnectException;
import java.util.ArrayList;

public class OrderManager {
    private OrderDataAccess dao;

    public OrderManager(OrderDataAccess dao) throws ConnectException {
        setDao(new OrderDBAccess());
    }

    public void setDao(OrderDataAccess dao) {
        this.dao = dao;
    }

    public ArrayList<Order> getAllOrders()throws QueryException {
        return dao.getAllOrders();
    }
}
