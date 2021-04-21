package dataAccess;

import exception.QueryException;
import model.OrderLine;

import java.util.ArrayList;

public interface OrderLineDataAccess {
    ArrayList<OrderLine> getAllOrderLine() throws QueryException;
}
