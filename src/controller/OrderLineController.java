package controller;

import business.OrderLineManager;
import exception.QuerySelectException;
import model.OrderLine;

import java.net.ConnectException;
import java.util.ArrayList;

public class OrderLineController {
    private OrderLineManager orderLineManager;

    public OrderLineController() throws ConnectException {
        setOrderLineManager(new OrderLineManager());
    }

    public void setOrderLineManager(OrderLineManager orderLineManager) {
        this.orderLineManager = orderLineManager;
    }

    public ArrayList<OrderLine> getAllOrderLine()throws QuerySelectException {
        return orderLineManager.getAllOrderLine();
    }
}
