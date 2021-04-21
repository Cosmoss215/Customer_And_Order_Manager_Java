package controller;

import business.OrderManager;
import exception.QuerySelectException;
import model.Order;

import java.net.ConnectException;
import java.util.ArrayList;

public class OrderController {
    private OrderManager orderManager;

    public OrderController() throws ConnectException {
        setOrderManager(new OrderManager());
    }

    public void setOrderManager(OrderManager orderManager) {
        this.orderManager = orderManager;
    }

    public ArrayList<Order> getAllOrders()throws QuerySelectException {
        return orderManager.getAllOrders();
    }
}
