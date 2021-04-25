package dataAccess;

import exception.QuerySelectException;
import model.OrderLine;

import java.util.ArrayList;

public interface OrderLineDataAccess {
    ArrayList<OrderLine> getAllOrderLine() throws QuerySelectException;
}
