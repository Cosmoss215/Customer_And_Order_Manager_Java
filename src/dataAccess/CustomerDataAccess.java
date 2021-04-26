package dataAccess;

import exception.*;
import model.*;

import java.util.ArrayList;

public interface CustomerDataAccess {
    ArrayList<Customer> getAllCustomers() throws SelectQueryException;

    ArrayList<Customer> getCustomers(ArrayList<Customer> customers, String sqlWhereClause) throws SelectQueryException;
    ArrayList<Customer> getCustomersByCountry(String countrySearched) throws SelectQueryException;
    boolean addCustomer(Customer customer);
    ArrayList<Customer> getCustomersByNickname(String nickname) throws SelectQueryException;
    ArrayList<Customer> getCustomersByName(String name) throws SelectQueryException;
    boolean update(Customer customer) throws UpdateQueryException;
    boolean delete(Customer customer) throws DeleteQueryException;
}


