package dataAccess;

import exception.SelectQueryException;
import model.OrderLine;

import java.util.ArrayList;

public interface OrderLineDataAccess {
    ArrayList<OrderLine> getAllOrderLine() throws SelectQueryException;
}
