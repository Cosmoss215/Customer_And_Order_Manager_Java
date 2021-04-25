package dataAccess;

import exception.ConnectionException;
import exception.QuerySelectException;
import model.Address;
import model.Country;
import model.Customer;
import model.Locality;

import java.sql.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class CustomerDBAccess implements CustomerDataAccess{

    private Connection connection;

    public CustomerDBAccess()throws ConnectionException {
        this.connection = SingletonConnection.getInstance();
    }

    @Override
    public ArrayList<Customer> getAllCustomers() throws QuerySelectException {
        ArrayList<Customer> allCustomers = new ArrayList<>();
        String sqlInstruction = "SELECT * FROM Customer,address,locality,country";


        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?useSSL=false", "root", "Manil93Manderlier97");
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInstruction);
            ResultSet data = preparedStatement.executeQuery();

            Customer customer;
            Address address;
            Locality locality;
            Country country;
            GregorianCalendar registrationDate = new GregorianCalendar();
            java.sql.Date registrationDateSQL =  data.getDate("registration_date");
            registrationDate.setTime(registrationDateSQL);

            while (data.next()) {
                GregorianCalendar calendar = new GregorianCalendar();
                java.sql.Date registration_date = data.getDate("registration_date");

                country = new Country(data.getString("code"),
                                      data.getString("name")
                        );
                locality = new Locality(data.getString("name"),
                                        data.getInt("postal_code"),
                                        data.getString("region"),
                                        country
                        );

                address = new Address(  data.getString("street_name"),
                                        data.getInt("street_number"),
                                        data.getString("box"),
                                        locality
                );
                customer = new Customer(
                        data.getInt("id"),
                        data.getString("first_name"),
                        data.getString("last_name"),
                        registrationDate,
                        data.getBoolean("is_vip"),
                        data.getString("nickname"),
                        data.getInt("phone_number"),
                        data.getString("email"),
                        data.getInt("vat_number"),
                        data.getString("iban"),
                        data.getString("bic"),
                        address
                );
                String nickname =  data.getString("nickname");
                if (nickname != null)
                {
                    customer.setNickname(nickname);
                }
                //Faire les autres setter pour les autres valeur pouvant être null (phonenumber, email,vatnumber,iban,bic

                allCustomers.add(customer);

            }

        } catch (SQLException throwables) {
            throw new QuerySelectException();
        }


        return allCustomers;
    }

    @Override
    public ArrayList<Customer> getCustomersByCountry() throws QuerySelectException {
        return null;
    }

    @Override
    public boolean addCustomer(Customer customer) {
        return false;
    }

    @Override
    public Customer getCustomerByNickname(String nickname) {
        return null;
    }

    @Override
    public Customer getCustomerByName(String name) {
        return null;
    }

    @Override
    public boolean update(Customer customer) {
        return false;
    }

    @Override
    public boolean delete(Customer customer) {
        return false;
    }
}
