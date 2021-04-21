package business;

import dataAccess.OrderDataAccess;
import dataAccess.OrderDBAccess;
import model.Order;

import java.net.ConnectException;

public class OrderManager {
    private OrderDataAccess dao;

    public OrderManager(OrderDataAccess dao) throws ConnectException {
        setDao(new OrderDBAccess());
    }

    public void setDao(OrderDataAccess dao) {
        this.dao = dao;
    }
}
