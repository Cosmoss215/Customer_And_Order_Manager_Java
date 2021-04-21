package business;

import dataAccess.CustomerDataAccess;
import dataAccess.CustomerDBAccess;
import model.Customer;

import java.net.ConnectException;

public class CustomerManager {
    private CustomerDataAccess dao;

    public CustomerManager() throws ConnectException {
        setDao(new CustomerDBAccess());
    }

    public void setDao(CustomerDataAccess dao) {
        this.dao = dao;
    }
}
