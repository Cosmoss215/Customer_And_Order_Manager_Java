package dataAccess;

import exception.QuerySelectException;

import model.Customer;

import java.util.ArrayList;

public interface CustomerDataAccess {
    ArrayList<Customer> getAllCustomers() throws QuerySelectException;

    ArrayList<Customer> getCustomersByCountry() throws QuerySelectException;

    boolean addCustomer(Customer customer);
    Customer getCustomerByNickname(String nickname);
    Customer getCustomerByName(String name);
    boolean update(Customer customer);
    boolean delete(Customer customer);
}


