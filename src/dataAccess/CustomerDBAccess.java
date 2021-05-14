package dataAccess;

import exception.*;
import model.*;
import util.DateFormater;

import java.sql.*;
import java.time.LocalDate;
import java.util.*;

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
                java.sql.Date registrationDateSQL =  data.getDate("registration_date");
                registrationDate.setTime(registrationDateSQL);
                // Redondance de code ?
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

                customers.add(customer);
            }

        } catch (SQLException sqlException) {
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
        String sqlWhereClause = "WHERE co.name IN ('" + countrySearched + "')";
        return getCustomers(sqlWhereClause);
    }

    @Override
    public ArrayList<Customer> getCustomersByNickname(String nickname) throws SelectQueryException {
        String sqlWhereClause = "WHERE c.nickname LIKE ('%" + nickname + "%')";
        return getCustomers(sqlWhereClause);
    }

    @Override
    public ArrayList<Customer> getCustomersByName(String name) throws SelectQueryException {
        String sqlWhereClause = "WHERE c.first_name LIKE ('%" + name + "%') OR c.last_name LIKE ('%" + name + "%')";
        return getCustomers(sqlWhereClause);
    }

    @Override
    public boolean addCustomer(Customer customer) throws CreateQueryException {
        int affectedRowsNbCustomer = 0;
        int addressId;
        try {

                String sqlInstruction = "SELECT `name`,postal_code FROM locality WHERE `name` = \'%" + customer.getAddress().getLocality().getName() + "%\';";
                PreparedStatement preparedStatementSelectLocality = connection.prepareStatement(sqlInstruction);

                if (!preparedStatementSelectLocality.execute()){
                    Country country;
                    String sqlInstructionLocality = "INSERT INTO locality (`name`, postal_code, region, country) VALUES (?,?,?,?)";
                    Locality locality = customer.getAddress().getLocality();
                    PreparedStatement preparedStatementLocality = connection.prepareStatement(sqlInstructionLocality);
                    setPreparedWritingStatementForLocality(preparedStatementLocality,locality);
                    preparedStatementLocality.executeUpdate();
                }
                //Add address
                String sqlInstructionAddress = "INSERT INTO address (street_name, street_number, box, locality, postal_code) VALUES(?,?,?,?,?)";
                Address address = customer.getAddress();
                PreparedStatement preparedStatementAddress = connection.prepareStatement(sqlInstructionAddress);

                setPreparedWritingStatementForAddress(preparedStatementAddress,address);

                preparedStatementAddress.executeUpdate();

                String sqlSelect = "SELECT id  FROM address WHERE street_name IN (\'" + customer.getAddress().getStreetName() + "\') AND street_number IN (\'" + customer.getAddress().getStreetNumber() + "\')";
                PreparedStatement preparedStatementSelectAddress = connection.prepareStatement(sqlSelect);
                ResultSet dataAddress = preparedStatementSelectAddress.executeQuery();

                while (dataAddress.next()){
                    addressId = dataAddress.getInt("id");
                    customer.getAddress().setId(addressId);
                }

                String sqlInstructionCustomer = "INSERT INTO customer (" +
                        "first_name, " +
                        "last_name, " +
                        "registration_date, " +
                        "is_vip, " +
                        "nickname, " +
                        "phone_number, " +
                        "email, " +
                        "vat_number, " +
                        "iban, " +
                        "bic, " +
                        "address) " +
                        "VALUES(?,?,?,?,?,?,?,?,?,?,?);";

                PreparedStatement preparedStatementCustomer = connection.prepareStatement(sqlInstructionCustomer);
                setPreparedWritingStatementForCustomer(preparedStatementCustomer, customer);
                affectedRowsNbCustomer = preparedStatementCustomer.executeUpdate();
            }catch (SQLException throwables) {
                throw  new CreateQueryException(throwables.getMessage());
            }

        return affectedRowsNbCustomer != 0;
    }

    @Override
    public boolean update(Customer customer) throws UpdateQueryException {
        int affectedRowsNb = 0;
        try {
            String sqlSelectInstruction = "SELECT `name`,postal_code FROM locality WHERE `name` = \'%" + customer.getAddress().getLocality().getName() + "%\';";
            PreparedStatement preparedStatementSelectLocality = connection.prepareStatement(sqlSelectInstruction);

            if (!preparedStatementSelectLocality.execute()) {
                //Locality was changed
                String sqlInstructionLocality = "UPDATE locality SET `name` = ?, postal_code = ?, region = ?, country = ?";
                Locality locality = customer.getAddress().getLocality();
                PreparedStatement preparedStatementLocality = connection.prepareStatement(sqlInstructionLocality);
                setPreparedWritingStatementForLocality(preparedStatementLocality,locality);
                preparedStatementLocality.executeUpdate();
            }
        } catch (SQLException exception) {
            System.out.println("Locality error");
            exception.printStackTrace();
        }

        try {
            //Add address
            String sqlInstructionAddress = "UPDATE address SET street_name = ?, street_number = ?, box = ?, locality = ?, postal_code = ? WHERE id = ?;";

            Address address = customer.getAddress();
            PreparedStatement preparedStatementAddress = connection.prepareStatement(sqlInstructionAddress);


                setPreparedWritingStatementForAddress(preparedStatementAddress,address);
                preparedStatementAddress.executeUpdate();

                String sqlSelect = "SELECT id  FROM address WHERE street_name IN (\'" + customer.getAddress().getStreetName() + "\') AND street_number IN (\'" + customer.getAddress().getStreetNumber() + "\')";
                PreparedStatement preparedStatementSelectAddress = connection.prepareStatement(sqlSelect);
                ResultSet dataAddress = preparedStatementSelectAddress.executeQuery();

                while (dataAddress.next()) {
                    int addressId = dataAddress.getInt("id");
                    customer.getAddress().setId(addressId);
                }
        } catch (SQLException exception) {
            System.out.println("Addresse error");
            exception.printStackTrace();
        }
        try {
            System.out.println("Customer go ");
        String sqlInstruction =
                    "UPDATE customer " +
                    "SET first_name = ?, " +
                        "last_name = ?, " +
                        "registration_date = ?, " +
                        "is_vip = ?, " +
                        "nickname = ?, " +
                        "phone_number = ?, " +
                        "email = ?, " +
                        "vat_number = ?, " +
                        "iban = ?, " +
                        "bic = ?, " +
                        "address = ? " +
                    "WHERE customer.id = ?;";

                PreparedStatement preparedStatement = connection.prepareStatement(sqlInstruction);
                setPreparedWritingStatementForCustomer(preparedStatement, customer);
                preparedStatement.setInt(12, customer.getId());
                affectedRowsNb = preparedStatement.executeUpdate();

            } catch (SQLException sqlException) {
                throw  new UpdateQueryException(sqlException.getMessage());
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
    private void setPreparedWritingStatementForCustomer(PreparedStatement preparedStatement, Customer customer) throws SQLException {
        preparedStatement.setString(1, customer.getFirstName());
        preparedStatement.setString(2, customer.getLastName());
        preparedStatement.setDate(3, DateFormater.fromJavaToSqlDate(customer.getRegistrationDate()));
        preparedStatement.setByte(4, (customer.getVip() ? (byte) 1 : (byte) 0));
        preparedStatement.setString(5, customer.getNickname());
        preparedStatement.setInt(6, customer.getPhoneNumber());
        preparedStatement.setString(7, customer.getEmail());
        preparedStatement.setInt(8, customer.getVatNumber());
        preparedStatement.setString(9, customer.getIban());
        preparedStatement.setString(10, customer.getBic());
        preparedStatement.setInt(11, customer.getAddress().getId());
    }

    private void setPreparedWritingStatementForAddress(PreparedStatement preparedStatementAddress, Address address) throws SQLException {

        preparedStatementAddress.setString(1, address.getStreetName());
        preparedStatementAddress.setInt(2, address.getStreetNumber());
        preparedStatementAddress.setString(3, address.getBox());
        preparedStatementAddress.setString(4, address.getLocality().getName());
        preparedStatementAddress.setInt(5, address.getLocality().getPostalCode());
        preparedStatementAddress.setInt(6, address.getId());
    }
    private void setPreparedWritingStatementForLocality(PreparedStatement preparedStatementLocality, Locality locality) throws SQLException {

        preparedStatementLocality.setString(1, locality.getName());
        preparedStatementLocality.setInt(2, locality.getPostalCode());
        preparedStatementLocality.setString(3, locality.getRegion());
        Country country = locality.getCountry();
        preparedStatementLocality.setString(4, country.getCode());
    }

    @Override
    public boolean delete(Customer customer) throws DeleteQueryException, UpdateQueryException {
        int affectedRowsNb;
        String sqlUpdateInstruction = "UPDATE `order` SET `order`.customer = 0 WHERE `order`.customer = ? ;";

        try {
            PreparedStatement preparedUpdateStatement = connection.prepareStatement(sqlUpdateInstruction);
            preparedUpdateStatement.setInt(1,customer.getId());

            affectedRowsNb = preparedUpdateStatement.executeUpdate();

            if(affectedRowsNb != 0) {
                String sqlDeleteInstruction = "DELETE FROM customer WHERE customer.id = ?;";
                try {
                    PreparedStatement preparedDeleteStatement = connection.prepareStatement(sqlDeleteInstruction);
                    preparedDeleteStatement.setInt(1, customer.getId());

                    affectedRowsNb = preparedDeleteStatement.executeUpdate();
                    if(affectedRowsNb == 0) {
                        connection.prepareStatement("ROLLBACK;").executeUpdate();
                    }
                } catch (SQLException exception) {
                    throw new DeleteQueryException(exception.getMessage());
                }
            }
        } catch (SQLException exception) {
            throw new UpdateQueryException(exception.getMessage());
        }
        return affectedRowsNb != 0;
    }
}
