package business;

import dataAccess.OrderDataAccess;
import dataAccess.OrderDBAccess;
import exception.ConnectionException;
import exception.NullException;
import exception.SelectQueryException;
import model.Customer;
import model.Order;
import model.OrderByCustomer;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class OrderManager {
    private OrderDataAccess dao;

    public OrderManager() throws ConnectionException {
        setDao(new OrderDBAccess());
    }

    public void setDao(OrderDataAccess dao) {
        this.dao = dao;
    }

    public ArrayList<OrderByCustomer> getAllOrders()throws SelectQueryException {
        ArrayList<OrderByCustomer> orderArrayList = dao.getAllOrders();
        return orderArrayList;
    }

    public ArrayList<OrderByCustomer> getOrdersByCustomer(int customerId, GregorianCalendar startDate, GregorianCalendar endDate) throws SelectQueryException, NullException {
        if (customerId < 0 || startDate == null || endDate == null){
            throw new NullException("Customer id or date are null were they shouldn't be" );
        }
        ArrayList<OrderByCustomer> orderByCustomer = dao.getOrdersByCustomer(customerId, startDate, endDate);
        return orderByCustomer;

    }

    public ArrayList<OrderByCustomer> getOrdersByCustomer(int customerId) throws SelectQueryException, NullException {
        if (customerId < 0){
            throw new NullException("Customer id is null were it shouldn't be" );
        }
        ArrayList<OrderByCustomer> orderByCustomers = dao.getOrdersByCustomer(customerId);
        return orderByCustomers;
    }
}
