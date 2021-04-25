package controller;

import business.*;
import exception.ConnectionException;
import exception.QuerySelectException;
import model.*;

import java.util.ArrayList;

public class ApplicationController  {
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

    public ArrayList<Address> getAllAddresses()throws QuerySelectException {
        return addressManager.getAllAddresses();
    }


    public ArrayList<Country> getAllCountries()throws QuerySelectException {
        return countryManager.getAllCountries();
    }

    public ArrayList<Customer> getAllCustomers()throws QuerySelectException {
        return customerManager.getAllCustomers();
    }


    public ArrayList<Locality> getAllLocalities()throws QuerySelectException {
        return localityManager.getAllLocalities();
    }


    public ArrayList<Order> getAllOrders()throws QuerySelectException {
        return orderManager.getAllOrders();
    }


    public ArrayList<OrderLine> getAllOrderLine()throws QuerySelectException {
        return orderLineManager.getAllOrderLine();
    }


    public ArrayList<PaymentMethod> getAllPaymentMethods()throws QuerySelectException {
        return paymentMethodManager.getAllPaymentMethods();
    }

    public ArrayList<Product> getAllProducts()throws QuerySelectException {
        return productManager.getAllProducts();
    }

    public ArrayList<VAT> getAllVAT()throws QuerySelectException {
        return vatManager.getAllVAT();
    }
}
