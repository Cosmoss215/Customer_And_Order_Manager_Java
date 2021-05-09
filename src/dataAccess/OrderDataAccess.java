package dataAccess;

import exception.SelectQueryException;
import model.Customer;
import model.Order;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public interface OrderDataAccess{
    ArrayList<Order> getAllOrders() throws SelectQueryException;
    ArrayList<Order> getOrdersByCustomer(Customer customer, GregorianCalendar startDate, GregorianCalendar endDate) throws SelectQueryException;

    boolean addOrder(Order order);
    Order getOrderById(Integer id);
    boolean update(Order order);
    boolean delete(Order order);
}
