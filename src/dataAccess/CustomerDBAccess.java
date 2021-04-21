package dataAccess;

import exception.QueryException;
import model.Customer;

import java.net.ConnectException;
import java.sql.Connection;
import java.util.ArrayList;

public class CustomerDBAccess implements CustomerDataAccess{

    private Connection connection;

    public CustomerDBAccess()throws ConnectException {
        this.connection = SingletonConnection.getInstance();
    }

    @Override
    public ArrayList<Customer> getAllCustomers() throws QueryException {
        return null;
    }
}
