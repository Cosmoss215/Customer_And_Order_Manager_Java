package dataAccess;

import exception.*;
import model.Product;

import java.util.ArrayList;

public interface ProductDataAccess {
    ArrayList<Product> getAllProducts() throws SelectQueryException;

    ArrayList<Product> getProductsByReference() throws SelectQueryException;
}
