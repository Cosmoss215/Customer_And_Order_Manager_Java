package dataAccess;

import exception.QuerySelectException;
import model.Customer;
import model.Order;

import java.util.ArrayList;

public interface OrderDataAccess{
    ArrayList<Order> getAllOrders() throws QuerySelectException;

    boolean addCustomer(Order order);
    Order getCustomerById(Integer id);
    boolean update(Order order);
    boolean delete(Order order);
}
