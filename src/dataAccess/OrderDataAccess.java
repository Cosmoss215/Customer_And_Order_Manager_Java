package dataAccess;

import exception.ConnectionException;
import exception.SelectQueryException;
import model.Customer;
import model.Order;
import model.OrderBusinessTask;
import model.OrderByCustomer;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public interface OrderDataAccess{
    ArrayList<OrderByCustomer> getAllOrders() throws SelectQueryException;
    ArrayList<OrderByCustomer> getOrdersByCustomer(int customerId, GregorianCalendar startDate, GregorianCalendar endDate) throws SelectQueryException;
    ArrayList<OrderByCustomer> getOrdersByCustomer(int customerId) throws SelectQueryException, ConnectionException;
    ArrayList<OrderBusinessTask> getAllOrderBusinessTask () throws SelectQueryException;

}
