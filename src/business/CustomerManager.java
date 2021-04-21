package business;

import dataAccess.CustomerDataAccess;
import dataAccess.CustomerDBAccess;
import exception.QuerySelectException;
import model.Country;
import model.Customer;

import java.net.ConnectException;
import java.util.ArrayList;

public class CustomerManager {
    private CustomerDataAccess dao;

    public CustomerManager() throws ConnectException {
        setDao(new CustomerDBAccess());
    }

    public void setDao(CustomerDataAccess dao) {
        this.dao = dao;
    }

    public ArrayList<Customer> getAllCustomers()throws QuerySelectException {
        ArrayList<Customer> customerArrayList = dao.getAllCustomers();
        //Traitements éventuels sur la liste de livres
        return customerArrayList;
    }
}
