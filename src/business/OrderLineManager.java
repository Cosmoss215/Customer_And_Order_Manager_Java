package business;

import dataAccess.OrderDBAccess;
import dataAccess.OrderDataAccess;
import dataAccess.OrderLineDBAccess;
import dataAccess.OrderLineDataAccess;
import exception.QuerySelectException;
import model.Customer;
import model.Order;
import model.OrderLine;

import java.net.ConnectException;
import java.util.ArrayList;

public class OrderLineManager {
    private OrderLineDataAccess dao;

    public OrderLineManager() throws ConnectException {
        setDao(new OrderLineDBAccess());
    }

    public void setDao(OrderLineDataAccess dao) {
        this.dao = dao;
    }

    public ArrayList<OrderLine> getAllOrderLine()throws QuerySelectException {
        ArrayList<OrderLine> orderLineArrayList = dao.getAllOrderLine();
        //Traitements éventuels sur la liste de livres
        return orderLineArrayList;
    }
}
