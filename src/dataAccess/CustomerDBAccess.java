package dataAccess;

import exception.QuerySelectException;
import model.Country;
import model.Customer;

import java.net.ConnectException;
import java.sql.Connection;
import java.util.ArrayList;

public class CustomerDBAccess implements CustomerDataAccess{

    private Connection connection;

    public CustomerDBAccess()throws ConnectException {
        this.connection = SingletonConnection.getInstance();
    }

    @Override
    public ArrayList<Customer> getAllCustomers() throws QuerySelectException {
        ArrayList<Customer> allCustomers = new ArrayList<>();
        //Accès à la base de données
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
