package dataAccess;

import exception.ConnectionException;
import exception.SelectQueryException;
import model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderLineDBAccess implements OrderLineDataAccess{

    private Connection connection;

    public OrderLineDBAccess()throws ConnectionException {
        this.connection = SingletonConnection.getInstance();
    }

    public ArrayList<OrderLine> getOrderLines(String sqlWhereClause) throws SelectQueryException{
        ArrayList<OrderLine> allOrderLine = new ArrayList<>();
        try {
            String sqlInstruction = "SELECT DISTINCT ol.*, o.*, pr.*, v.*, pm.*, c.*, a.*, l.*, co.* " +
                    "FROM order_line ol " +
                    "JOIN order o ON ol.order = o.number " +
                    "JOIN payment_method pm ON o.payment_method = p.wording " +
                    "JOIN customer c ON o.customer = c.id " +
                    "JOIN address a ON c.address = a.id " +
                    "JOIN locality l ON l.name = a.locality AND l.postal_code = a.postal_code " +
                    "JOIN country co ON l.country = co.code +" +
                    sqlWhereClause + ";";

            PreparedStatement preparedStatement = connection.prepareStatement(sqlInstruction);
            ResultSet data = preparedStatement.executeQuery();

            OrderLine orderLine;
            Order order;
            Customer customer;
            Address address;
            Locality locality;
            Country country;

        } catch (SQLException e) {
            throw new SelectQueryException();
        }

        return allOrderLine;
    }

    @Override
    public ArrayList<OrderLine> getAllOrderLine() throws SelectQueryException {
        return getOrderLines("");
    }
}
