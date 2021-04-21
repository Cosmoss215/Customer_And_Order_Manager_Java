package business;

import dataAccess.ProductDataAccess;
import dataAccess.ProductDBAccess;
import exception.QueryException;
import model.PaymentMethod;
import model.Product;

import java.net.ConnectException;
import java.util.ArrayList;

public class ProductManager {
    private ProductDataAccess dao;

    public ProductManager(ProductDataAccess dao) throws ConnectException {
        setDao(new ProductDBAccess());
    }

    public void setDao(ProductDataAccess dao) {
        this.dao = dao;
    }

    public ArrayList<Product> getAllProducts()throws QueryException {
        return dao.getAllProducts();
    }
}
