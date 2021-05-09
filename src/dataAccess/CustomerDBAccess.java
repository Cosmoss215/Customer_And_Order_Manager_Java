package dataAccess;

import exception.*;
import model.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class CustomerDBAccess implements CustomerDataAccess {

    private Connection connection;

    public CustomerDBAccess() throws ConnectionException {
        this.connection = SingletonConnection.getInstance();
    }

    public ArrayList<Customer> getCustomers(String sqlWhereClause) throws SelectQueryException {
        ArrayList<Customer> customers = new ArrayList<>();
        try {
            String sqlInstruction = "SELECT c.*, a.*, l.*, co.* " +
                    "FROM customer c " +
                    "JOIN address a ON c.address = a.id " +
                    "JOIN locality l ON l.name = a.locality AND l.postal_code = a.postal_code " +
                    "JOIN country co ON l.country = co.code " +
                    sqlWhereClause + ";";

            PreparedStatement preparedStatement = connection.prepareStatement(sqlInstruction);
            ResultSet data = preparedStatement.executeQuery();

            Customer customer;
            Address address;
            Locality locality;
            Country country;

            while (data.next()) {
                GregorianCalendar registrationDate = new GregorianCalendar();
                Date registrationDateSQL =  data.getDate("registration_date");
                registrationDate.setTime(registrationDateSQL);

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

                String nickname =  data.getString("nickname");
                if (!data.wasNull()) {
                    customer.setNickname(nickname);
                }
                Integer phoneNumber =  data.getInt("phone_number");
                if (!data.wasNull()) {
                    customer.setPhoneNumber(phoneNumber);
                }
                String email = data.getString("email");
                if(!data.wasNull()) {
                    customer.setEmail(email);
                }
                Integer vatNumber = data.getInt("vat_number");
                if(!data.wasNull()) {
                    customer.setVatNumber(vatNumber);
                }
                String iban = data.getString("iban");
                if(!data.wasNull()) {
                    customer.setVatNumber(vatNumber);
                }
                String bic = data.getString("bic");
                if(!data.wasNull()) {
                    customer.setBic(bic);
                }

                customers.add(customer);
            }

        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
            throw new SelectQueryException();
        }

        return customers;
    }

    @Override
    public ArrayList<Customer> getAllCustomers() throws SelectQueryException {
        return getCustomers("");
    }

    @Override
    public ArrayList<Customer> getCustomersByCountry(String countrySearched) throws SelectQueryException {
        String sqlWhereClause = "WHERE co.name IN (\'" + countrySearched + "\')";
        return getCustomers(sqlWhereClause);
    }

    @Override
    public ArrayList<Customer> getCustomersByNickname(String nickname) throws SelectQueryException {
        String sqlWhereClause = "WHERE c.nickname LIKE (\'%" + nickname + "%\')";
        return getCustomers(sqlWhereClause);
    }

    @Override
    public ArrayList<Customer> getCustomersByName(String name) throws SelectQueryException {
        String sqlWhereClause = "WHERE c.first_name LIKE (\'%" + name + "%\') OR c.last_name LIKE (\'%" + name + "%\')";
        return getCustomers(sqlWhereClause);
    }

    @Override
    public boolean addCustomer(Customer customer) throws CreateQueryException {
        int affectedRowsNb;
        String sqlInstruction = "INSERT INTO customer (" +
                    "first_name," +
                    "last_name," +
                    "registration_date," +
                    "is_vip," +
                    "nickname," +
                    "phone_number," +
                    "email," +
                    "vat_number," +
                    "iban," +
                    "bic," +
                    "address) " +
                "VALUES(?,?,?,?,?,?,?,?,?,?,?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInstruction);
            setPreparedWritingStatement(preparedStatement, customer);

            affectedRowsNb = preparedStatement.executeUpdate();
        } catch (SQLException sqlException){
            System.out.println(sqlException.getMessage());
            throw new CreateQueryException();
        }
        return affectedRowsNb != 0;
    }

    @Override
    public boolean update(Customer customer) throws UpdateQueryException {
        int affectedRowsNb;
        String sqlInstruction =
                "UPDATE customer " +
                "SET first_name = ?, " +
                    "last_name = ?, " +
                    "is_vip = ?, " +
                    "nickname = ?, " +
                    "phone_number = ?, " +
                    "email = ?, " +
                    "vat_number = ?, " +
                    "iban = ?, " +
                    "bic = ?, " +
                    "address = ? " +
                "WHERE customer.id = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInstruction);
            setPreparedWritingStatement(preparedStatement, customer);
            preparedStatement.setInt(11, customer.getId());

            affectedRowsNb = preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
            throw new UpdateQueryException();
        }
        return affectedRowsNb != 0;
    }

    /** Use this method to set the params of a PreparedStatement instance which will be used to access the DB in the WRITE mode.
     * @param preparedStatement needs to be initialized before being given to this method.
     * @param customer WARNING ! If you use this method in a CREATE or UPDATE statement, you have to use id as following :
     *                 CREATE : no need to add something else : the DB will auto-increment the customer's id
     *                 UPDATE : you will need to add a setInt() instruction in order to get the customer's id which already exists
     * @throws SQLException needs to be caught with a catch() instruction in another method.
     */
    private void setPreparedWritingStatement(PreparedStatement preparedStatement, Customer customer) throws SQLException {
        preparedStatement.setString(1, customer.getFirstName());
        preparedStatement.setString(2, customer.getLastName());
        preparedStatement.setByte(3, (customer.getVip() ? (byte) 1 : (byte) 0));
        preparedStatement.setString(4, customer.getNickname());
        preparedStatement.setInt(5, customer.getPhoneNumber());
        preparedStatement.setString(6, customer.getEmail());
        preparedStatement.setInt(7, customer.getVatNumber());
        preparedStatement.setString(8, customer.getIban());
        preparedStatement.setString(9, customer.getBic());
        preparedStatement.setInt(10, customer.getAddress().getId());
    }

    @Override
    public boolean delete(Customer customer) throws DeleteQueryException {
        int affectedRowsNb;
        String sqlInstruction = "DELETE FROM customer WHERE customer.id = ?;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInstruction);
            preparedStatement.setInt(1,customer.getId());

            affectedRowsNb = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new DeleteQueryException();
        }
        return affectedRowsNb != 0;
    }
}
