package business;

import dataAccess.ProductDataAccess;
import dataAccess.ProductDBAccess;
import model.Product;

import java.net.ConnectException;

public class ProductManager {
    private ProductDataAccess dao;

    public ProductManager(ProductDataAccess dao) throws ConnectException {
        setDao(new ProductDBAccess());
    }

    public void setDao(ProductDataAccess dao) {
        this.dao = dao;
    }
}
