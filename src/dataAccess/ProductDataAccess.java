package dataAccess;

import exception.*;
import model.CustomerByProduct;
import model.Product;

import java.util.ArrayList;

public interface ProductDataAccess {
    ArrayList<Product> getAllProducts() throws SelectQueryException;

    ArrayList<CustomerByProduct> getProductByWording(String wording) throws SelectQueryException;
}
