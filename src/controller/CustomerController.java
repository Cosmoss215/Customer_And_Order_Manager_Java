package controller;

import business.CustomerManager;
import exception.QuerySelectException;
import model.Customer;

import java.net.ConnectException;
import java.util.ArrayList;

public class CustomerController {
    private CustomerManager customerManager;

    public CustomerController() throws ConnectException {
        setCustomerManager(new CustomerManager());
    }

    public void setCustomerManager(CustomerManager customerManager) {
        this.customerManager = customerManager;
    }

    public ArrayList<Customer> getAllCustomers()throws QuerySelectException {
        return customerManager.getAllCustomers();
    }

}
