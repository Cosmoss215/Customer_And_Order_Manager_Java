package dataAccess;

import exception.QueryException;
import model.Product;

import java.net.ConnectException;
import java.sql.Connection;
import java.util.ArrayList;

public class ProductDBAccess implements ProductDataAccess{
    private Connection connection;

    public ProductDBAccess()throws ConnectException {
        this.connection = SingletonConnection.getInstance();
    }

    @Override
    public ArrayList<Product> getAllProduct() throws QueryException {
        return null;
    }
}
