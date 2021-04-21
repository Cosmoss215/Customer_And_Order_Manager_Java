package dataAccess;

import model.Product;

import java.net.ConnectException;
import java.sql.Connection;

public class ProductDBAccess implements ProductDataAccess{
    private Connection connection;

    public ProductDBAccess()throws ConnectException {
        this.connection = SingletonConnection.getInstance();
    }
}
