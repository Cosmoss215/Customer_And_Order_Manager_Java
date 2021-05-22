package dataAccess;

import exception.SelectQueryException;
import model.OrderLine;
import model.OrderLineBusinessTask;

import java.util.ArrayList;

public interface OrderLineDataAccess {
    ArrayList<OrderLineBusinessTask> getAllOrderLine(String sqlWhereClause) throws SelectQueryException;
}
