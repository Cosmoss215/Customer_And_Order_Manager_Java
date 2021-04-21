package dataAccess;

import model.Customer;

import java.net.ConnectException;
import java.sql.Connection;

public class CustomerDBAccess implements CustomerDataAccess{

    private Connection connection;

    public CustomerDBAccess()throws ConnectException {
        this.connection = SingletonConnection.getInstance();
    }
}
