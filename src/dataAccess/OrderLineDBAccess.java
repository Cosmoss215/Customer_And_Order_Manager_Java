package dataAccess;

import controller.ApplicationController;
import exception.ConnectionException;
import exception.SelectQueryException;
import model.*;
import util.DateFormater;

import java.sql.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class OrderLineDBAccess implements OrderLineDataAccess {

    private final Connection connection;

    public OrderLineDBAccess()throws ConnectionException {
        this.connection = SingletonConnection.getInstance();
    }

    public ArrayList<OrderLineBusinessTask> getAllOrderLine(String sqlWhereClause) throws SelectQueryException{
        ArrayList<OrderLineBusinessTask> allOrderLine = new ArrayList<>();
        try {
            String sqlInstruction = "SELECT ol.*, p.* "+
            "FROM order_line ol "+
            "JOIN product p on p.reference = ol.product "+
                    sqlWhereClause+";";

            PreparedStatement preparedStatement = connection.prepareStatement(sqlInstruction);
            ResultSet data = preparedStatement.executeQuery();

            OrderLineBusinessTask orderLine;

            while (data.next()) {
                orderLine = new OrderLineBusinessTask(
                        data.getInt("reference"),
                        data.getString("wording"),
                        data.getInt("quantity"),
                        data.getDouble("all_taxes_included_price"),
                        data.getBoolean("has_discount"),
                        data.getDouble("percentage_discount")
                );
                allOrderLine.add(orderLine);
            }
        } catch (SQLException exception) {
            throw new SelectQueryException(exception.getMessage());
        }

        return allOrderLine;
    }

}
