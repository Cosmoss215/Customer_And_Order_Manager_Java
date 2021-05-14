package business;

import dataAccess.CustomerDataAccess;
import dataAccess.CustomerDBAccess;
import exception.*;
import model.Customer;
import java.util.ArrayList;

public class CustomerManager {
    private CustomerDataAccess dao;

    public CustomerManager() throws ConnectionException {
        setDao(new CustomerDBAccess());
    }

    public void setDao(CustomerDataAccess dao) {
        this.dao = dao;
    }

    public ArrayList<Customer> getAllCustomers()throws SelectQueryException {
        ArrayList<Customer> customerArrayList = dao.getAllCustomers();
        //Traitements éventuels
        return customerArrayList;
    }

    public ArrayList<Customer> getCustomersByCountry(String countrySearched)throws SelectQueryException {
        ArrayList<Customer> customerArrayList = dao.getCustomersByCountry(countrySearched);
        //Traitements éventuels
        return customerArrayList;
    }
    public boolean addCustomer(Customer customer) throws CreateQueryException {
            return dao.addCustomer(customer);
    }
    public boolean update(Customer customer) throws UpdateQueryException{
        return dao.update(customer);
    }
    public boolean delete(Customer customer)throws DeleteQueryException, UpdateQueryException{
        if (customer == null){
            throw new NullPointerException();
        }
        return  dao.delete(customer);
    }
}
