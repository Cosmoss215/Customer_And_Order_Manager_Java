package dataAccess;

import exception.QuerySelectException;
import model.Product;

import java.util.ArrayList;

public interface ProductDataAccess {
    ArrayList<Product> getAllProducts() throws QuerySelectException;

    ArrayList<Product> getProductsByReference() throws QuerySelectException;
}
