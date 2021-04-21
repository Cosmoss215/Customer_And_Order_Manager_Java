package dataAccess;

import exception.QueryException;
import model.Order;

import java.util.ArrayList;

public interface OrderDataAccess{
    ArrayList<Order> getAllOrder() throws QueryException;
}
