package business;

import dataAccess.OrderDataAccess;
import dataAccess.OrderDBAccess;
import exception.ConnectionException;
import exception.SelectQueryException;
import model.Order;
import java.util.ArrayList;

public class OrderManager {
    private OrderDataAccess dao;

    public OrderManager() throws ConnectionException {
        setDao(new OrderDBAccess());
    }

    public void setDao(OrderDataAccess dao) {
        this.dao = dao;
    }

    public ArrayList<Order> getAllOrders()throws SelectQueryException {
        ArrayList<Order> orderArrayList = dao.getAllOrders();
        //Traitements éventuels sur la liste de livres
        return orderArrayList;
    }
}
