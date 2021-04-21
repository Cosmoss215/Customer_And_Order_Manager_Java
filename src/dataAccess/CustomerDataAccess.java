package dataAccess;

import exception.QueryException;

import model.Customer;

import java.util.ArrayList;

public interface CustomerDataAccess {
    ArrayList<Customer> getAllCustomers() throws QueryException;
}
