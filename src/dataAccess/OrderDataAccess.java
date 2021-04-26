package dataAccess;

import exception.SelectQueryException;
import model.Order;

import java.util.ArrayList;

public interface OrderDataAccess{
    ArrayList<Order> getAllOrders() throws SelectQueryException;

    boolean addCustomer(Order order);
    Order getCustomerById(Integer id);
    boolean update(Order order);
    boolean delete(Order order);
}
