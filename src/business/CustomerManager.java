package business;

import dataAccess.CustomerDataAccess;
import dataAccess.CustomerDBAccess;
import exception.ConnectionException;
import exception.CreateQueryException;
import exception.NullException;
import exception.SelectQueryException;
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
    public boolean addCustomer(Customer customer) throws CreateQueryException, NullException {
            if (customer == null){
                throw new NullException();
            }
            return dao.addCustomer(customer);
    }
}
