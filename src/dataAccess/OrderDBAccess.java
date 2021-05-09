package dataAccess;

import exception.ConnectionException;
import exception.SelectQueryException;
import model.*;

import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class OrderDBAccess implements OrderDataAccess {

    private Connection connection;

    public OrderDBAccess() throws ConnectionException {
        this.connection = SingletonConnection.getInstance();
    }

    public ArrayList<Order> getOrders(String sqlWhereClause) throws SelectQueryException {
        ArrayList<Order> allOrders = new ArrayList<>();
        try {
            String sqlInstruction = "SELECT o.*, p.*, c.*, a.*, l.*, co.* " +
                    "FROM order o " +
                    "JOIN payment_method on o.payment_method = p.wording " +
                    "JOIN customer c ON o.customer = c.id " +
                    "JOIN address a ON c.address = a.id " +
                    "JOIN locality l ON l.name = a.locality AND l.postal_code = a.postal_code " +
                    "JOIN country co ON l.country = co.code +" +
                    sqlWhereClause + ";";

            PreparedStatement preparedStatement = connection.prepareStatement(sqlInstruction);
            ResultSet data = preparedStatement.executeQuery();

            Order order;
            Customer customer;
            Address address;
            Locality locality;
            Country country;

            while (data.next()) {
                // créer une classe Util.Format (package Util) ayant comme méthode static setDate(dateJava, "column_label") qui renvoie un GregorianCalendar?
                GregorianCalendar registrationDate = new GregorianCalendar();
                Date registrationDateSQL = data.getDate("registration_date");
                registrationDate.setTime(registrationDateSQL);

                GregorianCalendar creationDate = new GregorianCalendar();
                Date creationDateSQL = data.getDate("creation_date");
                creationDate.setTime(creationDateSQL);

                GregorianCalendar paymentDeadline = new GregorianCalendar();
                Date paymentDeadlineSQL = data.getDate("payment_deadline");
                paymentDeadline.setTime(paymentDeadlineSQL);

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
                        data.getString("iban"),
                        data.getString("bic"),
                        address
                );

                PaymentMethod paymentMethod = new PaymentMethod(
                        data.getString("wording"),
                        data.getString("iban"),
                        data.getString("bic")
                );

                order = new Order(
                        data.getInt("id"),
                        creationDate,
                        paymentDeadline,
                        data.getString("state"),
                        customer,
                        paymentMethod
                );

                String nickname = data.getString("nickname");
                if (!data.wasNull()) {
                    customer.setNickname(nickname);
                }
                Integer phoneNumber = data.getInt("phone_number");
                if (!data.wasNull()) {
                    customer.setPhoneNumber(phoneNumber);
                }
                String email = data.getString("email");
                if (!data.wasNull()) {
                    customer.setEmail(email);
                }
                Integer vatNumber = data.getInt("vat_number");
                if (!data.wasNull()) {
                    customer.setVatNumber(vatNumber);
                }
                String iban = data.getString("iban");
                if (!data.wasNull()) {
                    customer.setVatNumber(vatNumber);
                }
                String bic = data.getString("bic");
                if (!data.wasNull()) {
                    customer.setBic(bic);
                }

                allOrders.add(order);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new SelectQueryException();
        }
        return allOrders;
    }

    @Override
    public ArrayList<Order> getAllOrders() throws SelectQueryException{
        return getOrders("");
    }

    @Override
    public ArrayList<Order> getOrdersByCustomer(Customer customer, GregorianCalendar startDate, GregorianCalendar endDate) throws SelectQueryException {
        String sqlWhereClause = "WHERE o.creation_date " +
                "BETWEEN " +
                    "STR_TO_DATE(\'" + startDate.get(Calendar.DAY_OF_MONTH) + "/" +
                    startDate.get(Calendar.MONTH+1) + "/" +
                    startDate.get(Calendar.YEAR) + "\', '%d/%m/%y') " +
                    "AND " +
                    "STR_TO_DATE(\'" + endDate.get(Calendar.DAY_OF_MONTH) + "/" +
                    endDate.get(Calendar.MONTH+1) + "/" +
                    endDate.get(Calendar.YEAR) + "\', '%d/%m/%y') " +
                "AND c.id IN(\'" + customer.getId() + "\');";

        return getOrders(sqlWhereClause);
    }

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
