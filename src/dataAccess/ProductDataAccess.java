package dataAccess;

import exception.QueryException;
import model.Product;

import java.util.ArrayList;

public interface ProductDataAccess {
    ArrayList<Product> getAllProducts() throws QueryException;
}
