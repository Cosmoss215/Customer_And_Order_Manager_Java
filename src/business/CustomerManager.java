package business;

import dataAccess.CustomerDataAccess;
import dataAccess.CustomerDBAccess;
import exception.ConnectionException;
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
        //Traitements éventuels sur la liste de livres
        return customerArrayList;
    }
}
