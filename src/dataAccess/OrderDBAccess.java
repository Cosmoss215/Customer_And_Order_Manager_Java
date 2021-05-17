package dataAccess;

import exception.ConnectionException;
import exception.SelectQueryException;
import model.*;
import util.DateFormater;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class OrderDBAccess implements OrderDataAccess {

    private Connection connection;

    public OrderDBAccess() throws ConnectionException {
        this.connection = SingletonConnection.getInstance();
    }

    public ArrayList<OrderByCustomer> getOrders(String sqlWhereClause) throws SelectQueryException {
        ArrayList<OrderByCustomer> arrayOfOrdersByCustomer = new ArrayList<>();
        try {
            String sqlInstruction = "SELECT o.*, p.*, c.*, a.*, l.*, co.*, sum(ol.all_taxes_included_price * ol.quantity) as 'sum' " +
                    "FROM `order` o " +
                    "JOIN order_line ol ON ol.order = o.number " +
                    "JOIN payment_method p ON o.payment_method = p.wording " +
                    "JOIN customer c ON o.customer = c.id " +
                    "JOIN address a ON c.address = a.id " +
                    "JOIN locality l ON l.name = a.locality AND l.postal_code = a.postal_code " +
                    "JOIN country co ON l.country = co.code " +
                    sqlWhereClause + ";";

            PreparedStatement preparedStatement = connection.prepareStatement(sqlInstruction);
            ResultSet data = preparedStatement.executeQuery();

            OrderByCustomer orderByCustomer;
            Customer customer;
            Address address;
            Locality locality;
            Country country;

            while (data.next()) {
                java.sql.Date registrationDateSQL =  data.getDate("registration_date");
                GregorianCalendar registrationDate = DateFormater.fromSqlToGregorianDate(registrationDateSQL);

                Date creationDateSQL = data.getDate("creation_date");
                GregorianCalendar creationDate = DateFormater.fromSqlToGregorianDate(creationDateSQL);

                Date paymentDeadlineSQL = data.getDate("payment_deadline");
                GregorianCalendar paymentDeadline = DateFormater.fromSqlToGregorianDate(paymentDeadlineSQL);

                country = new Country(
                        data.getString("code"),
                        data.getString("name")
                );
                locality = new Locality(
                        data.getString("name"),
                        data.getInt("postal_code"),
                        data.getString("region"),
                        country
                );
                address = new Address(
                        data.getInt("id"),
                        data.getString("street_name"),
                        data.getInt("street_number"),
                        data.getString("box"),
                        locality
                );
                customer = new Customer(
                        data.getInt("id"),
                        data.getString("first_name"),
                        data.getString("last_name"),
                        registrationDate,
                        data.getByte("is_vip") == 1,
                        data.getString("nickname"),
                        data.getInt("phone_number"),
                        data.getString("email"),
                        data.getInt("vat_number"),
                        data.getString("iban"),
                        data.getString("bic"),
                        address
                );

                PaymentMethod paymentMethod = new PaymentMethod(
                        data.getString("wording"),
                        data.getString("iban"),
                        data.getString("bic")
                );


                orderByCustomer = new OrderByCustomer(
                        data.getInt("id"),
                        creationDate,
                        paymentDeadline,
                        data.getDouble("sum"),
                        customer,
                        paymentMethod.getWording()
                );
                arrayOfOrdersByCustomer.add(orderByCustomer);
            }
        } catch (SQLException exception) {
            throw new SelectQueryException(exception.getMessage());
        }
        return arrayOfOrdersByCustomer;
    }


    @Override
    public ArrayList<OrderByCustomer> getAllOrders() throws SelectQueryException{
        return getOrders("");
    }

    @Override
    public ArrayList<OrderByCustomer> getOrdersByCustomer(int customerId, GregorianCalendar startDate, GregorianCalendar endDate) throws SelectQueryException {
        String sqlWhereClause = "WHERE o.creation_date " +
                "BETWEEN " +
                    "STR_TO_DATE('" + startDate.get(Calendar.DAY_OF_MONTH) + "/" +
                    startDate.get(Calendar.MONTH+1) + "/" +
                    startDate.get(Calendar.YEAR) + "', '%d/%m/%Y') " +
                    "AND " +
                    "STR_TO_DATE('" + endDate.get(Calendar.DAY_OF_MONTH) + "/" +
                    endDate.get(Calendar.MONTH+1) + "/" +
                    endDate.get(Calendar.YEAR) + "', '%d/%m/%Y') " +
                "AND c.id = " + customerId + ";";

        return getOrders(sqlWhereClause);
    }

    /* Work in progress : returning only the detailed order lines related to a specified order (via its order number)
        and also the total price of each order line (via a select sum())
    private ArrayList<OrderLine> getOrderLines(int orderNumber) throws SelectQueryException {
        ArrayList<OrderLine> orderLines = new ArrayList<>();
        try {
            String sqlInstruction = "SELECT DISTINCT o.*, ol.*, sum(ol.allTaxesIncludedPrice * ol.quantity) as 'sum' " +
                                    "FROM order o " +
                                    "JOIN order_line ol ON o.number = ol.order " +
                                    "WHERE o.number =" + orderNumber + ";";

            PreparedStatement preparedStatement = connection.prepareStatement(sqlInstruction);
            ResultSet data = preparedStatement.executeQuery();

            Order order;

        }
        catch (SQLException exception){
            throw new SelectQueryException(exception.getMessage());
        }
        return orderLines;
    }
     */

    @Override
    public boolean addOrder(Order order) {
        return false;
    }

    @Override
    public Order getOrderById(Integer id) {
        return null;
    }

    @Override
    public boolean update(Order order) {
        return false;
    }

    @Override
    public boolean delete(Order order) {
        return false;
    }
}
