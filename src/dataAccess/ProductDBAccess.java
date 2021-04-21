package dataAccess;

import exception.QuerySelectException;
import model.PaymentMethod;
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
    public ArrayList<Product> getAllProducts() throws QuerySelectException {
        ArrayList<Product> allProducts = new ArrayList<>();
        //Accès à la base de données
        return allProducts;
    }

    @Override
    public ArrayList<Product> getProductsByReference() throws QuerySelectException {
        return null;
    }
}
