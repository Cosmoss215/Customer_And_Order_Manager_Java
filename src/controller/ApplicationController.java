package controller;

import business.*;
import exception.*;
import model.*;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class ApplicationController {
    private CustomerManager customerManager;
    private LocalityManager localityManager;
    private OrderManager orderManager;
    private OrderLineManager orderLineManager;
    private ProductManager productManager;

    public ApplicationController() throws ConnectionException {
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
    public boolean delete(Customer customer) throws DeleteQueryException, UpdateQueryException, NullException {
        if (customer == null){
            throw new NullException(customer.getClass().getName());
        }
        return  customerManager.delete(customer);
    }
    //endregion

    //region Product
    public ArrayList<CustomerByProduct> getProductByWording(String wording) throws SelectQueryException, NullException {
        if (wording == null){
            throw new NullException(wording.getClass().getName());
        }
        return productManager.getProductByWording(wording);
    }
    public ArrayList<Product> getAllProducts() throws SelectQueryException {
        return productManager.getAllProducts();
    }
    //endregion

    //region locality
    public ArrayList<Locality> getAllLocalities()throws SelectQueryException {
        ArrayList<Locality> localityArrayList = localityManager.getAllLocalities();
        return localityArrayList;
    }
    //endregion


    //region order
    public ArrayList<OrderByCustomer> getAllOrders()throws SelectQueryException {
        ArrayList<OrderByCustomer> orderArrayList = orderManager.getAllOrders();
        return orderArrayList;
    }

    public ArrayList<OrderByCustomer> getOrdersByCustomer(int customerId, GregorianCalendar startDate, GregorianCalendar endDate) throws SelectQueryException, NullException {
        if (customerId < 0 || startDate == null || endDate == null){
            throw new NullException("Customer id or date are null were they shouldn't be" );
        }
        ArrayList<OrderByCustomer> orderByCustomer = orderManager.getOrdersByCustomer(customerId, startDate, endDate);
        return orderByCustomer;
    }

    public ArrayList<OrderByCustomer> getOrdersByCustomer(int customerId) throws SelectQueryException, NullException, ConnectionException {
        if (customerId < 0){
            throw new NullException("Customer id is null were it shouldn't be" );
        }
        ArrayList<OrderByCustomer> orderByCustomers = orderManager.getOrdersByCustomer(customerId);
        return orderByCustomers;
    }

    public ArrayList<OrderBusinessTask> getAllOrderBusinessTask () throws SelectQueryException {
        ArrayList<OrderBusinessTask> orderBusinessTasks = orderManager.getAllOrderBusinessTask();
        return orderBusinessTasks;
    }

    public StatisticsModel getStatsFromAllSales (ArrayList<OrderBusinessTask> orders, String wording){
        return orderManager.getStatsFromAllSales( orders,wording);
    }
    //endregion

}
