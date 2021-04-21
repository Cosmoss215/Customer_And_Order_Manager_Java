package business;

import dataAccess.OrderDataAccess;
import dataAccess.OrderDBAccess;
import exception.QuerySelectException;
import model.Customer;
import model.Order;

import java.net.ConnectException;
import java.util.ArrayList;

public class OrderManager {
    private OrderDataAccess dao;

    public OrderManager() throws ConnectException {
        setDao(new OrderDBAccess());
    }

    public void setDao(OrderDataAccess dao) {
        this.dao = dao;
    }

    public ArrayList<Order> getAllOrders()throws QuerySelectException {
        ArrayList<Order> orderArrayList = dao.getAllOrders();
        //Traitements éventuels sur la liste de livres
        return orderArrayList;
    }
}
