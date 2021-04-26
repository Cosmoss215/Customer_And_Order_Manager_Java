package business;

import dataAccess.OrderLineDBAccess;
import dataAccess.OrderLineDataAccess;
import exception.ConnectionException;
import exception.SelectQueryException;
import model.OrderLine;
import java.util.ArrayList;

public class OrderLineManager {
    private OrderLineDataAccess dao;

    public OrderLineManager() throws ConnectionException {
        setDao(new OrderLineDBAccess());
    }

    public void setDao(OrderLineDataAccess dao) {
        this.dao = dao;
    }

    public ArrayList<OrderLine> getAllOrderLine()throws SelectQueryException {
        ArrayList<OrderLine> orderLineArrayList = dao.getAllOrderLine();
        //Traitements éventuels sur la liste de livres
        return orderLineArrayList;
    }
}
