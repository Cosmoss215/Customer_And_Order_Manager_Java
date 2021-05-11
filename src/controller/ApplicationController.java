package controller;

import business.*;
import exception.*;
import model.*;

import java.util.ArrayList;

public class ApplicationController {
    private CountryManager countryManager;
    private CustomerManager customerManager;
    private LocalityManager localityManager;
    private OrderManager orderManager;
    private OrderLineManager orderLineManager;
    private ProductManager productManager;

    public ApplicationController() throws ConnectionException {
        countryManager = new CountryManager();
        customerManager = new CustomerManager();
        localityManager = new LocalityManager();
        orderManager = new OrderManager();
        orderLineManager = new OrderLineManager();
        productManager = new ProductManager();
    }

    //region Customer
    public ArrayList<Customer> getAllCustomers() throws SelectQueryException {
        return customerManager.getAllCustomers();
    }
    public ArrayList<Customer> getCustomersByCountry(String countrySearched) throws SelectQueryException, NullException {
        if (countrySearched == null) {
            throw new NullException(countrySearched.getClass().getName());
        }
        return customerManager.getCustomersByCountry(countrySearched);
    }
    public boolean addCustomer(Customer customer) throws CreateQueryException, NullException {
        if (customer == null){
            throw new NullException(customer.getClass().getName());
        }
        return customerManager.addCustomer(customer);
    }
    public boolean update(Customer customer) throws UpdateQueryException, NullException {
        if (customer == null){
            throw new NullException(customer.getClass().getName());
        }
        return customerManager.update(customer);
    }
    public boolean delete(Customer customer)throws DeleteQueryException {
        if (customer == null){
            throw new NullPointerException();
        }
        return  customerManager.delete(customer);
    }
    //endregion
    //region Product
    public ArrayList<CustomerByProduct> getProductByReference(Integer reference) throws SelectQueryException, NullException {
        if (reference == null){
            throw new NullException(reference.getClass().getName());
        }
        return productManager.getProductByReference(reference);
    }
    public ArrayList<Product> getAllProducts() throws SelectQueryException {
        return productManager.getAllProducts();
    }
    //endregion
    //region Country
    public ArrayList<Country> getAllCountries()throws SelectQueryException {
        ArrayList<Country> countryArrayList = countryManager.getAllCountries();
        return countryArrayList;
    }
    //endregion
    //region locality
    public ArrayList<Locality> getAllLocalities()throws SelectQueryException {
        ArrayList<Locality> localityArrayList = localityManager.getAllLocalities();
        return localityArrayList;
    }
    //endregion

}
