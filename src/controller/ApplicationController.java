package controller;

import business.*;
import exception.ConnectionException;
import exception.CreateQueryException;
import exception.NullException;
import exception.SelectQueryException;
import model.*;

import java.util.ArrayList;

public class ApplicationController {
    private CountryManager countryManager;
    private CustomerManager customerManager;
    private LocalityManager localityManager;
    private OrderManager orderManager;
    private OrderLineManager orderLineManager;
    private ProductManager productManager;
    private VATManager vatManager;

    public ApplicationController() throws ConnectionException {
        countryManager = new CountryManager();
        customerManager = new CustomerManager();
        localityManager = new LocalityManager();
        orderManager = new OrderManager();
        orderLineManager = new OrderLineManager();
        productManager = new ProductManager();
        vatManager = new VATManager();
    }

    public ArrayList<Customer> getAllCustomers() throws SelectQueryException {
        return customerManager.getAllCustomers();
    }

    public ArrayList<Product> getAllProducts() throws SelectQueryException {
        return productManager.getAllProducts();
    }

    public ArrayList<Customer> getCustomersByCountry(String countrySearched) throws SelectQueryException {
        return customerManager.getCustomersByCountry(countrySearched);
    }

    public ArrayList<CustomerByProduct> getProductByReference(Integer reference) throws SelectQueryException {
        return productManager.getProductByReference(reference);
    }
    public boolean addCustomer(Customer customer) throws CreateQueryException, NullException {
        if (customer == null){
            throw new NullException();
        }
        return customerManager.addCustomer(customer);
    }
    public ArrayList<Country> getAllCountries()throws SelectQueryException {
        ArrayList<Country> countryArrayList = countryManager.getAllCountries();
        return countryArrayList;
    }

}
