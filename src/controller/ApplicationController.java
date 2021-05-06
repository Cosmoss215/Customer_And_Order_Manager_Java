package controller;

import business.*;
import exception.ConnectionException;
import exception.SelectQueryException;
import model.*;

import java.util.ArrayList;

public class ApplicationController {
    private AddressManager addressManager;
    private CountryManager countryManager;
    private CustomerManager customerManager;
    private LocalityManager localityManager;
    private OrderManager orderManager;
    private OrderLineManager orderLineManager;
    private PaymentMethodManager paymentMethodManager;
    private ProductManager productManager;
    private VATManager vatManager;

    public ApplicationController() throws ConnectionException {
        addressManager = new AddressManager();
        countryManager = new CountryManager();
        customerManager = new CustomerManager();
        localityManager = new LocalityManager();
        orderManager = new OrderManager();
        orderLineManager = new OrderLineManager();
        paymentMethodManager = new PaymentMethodManager();
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

}
