package business;

import dataAccess.ProductDataAccess;
import dataAccess.ProductDBAccess;
import exception.ConnectionException;
import exception.NullException;
import exception.SelectQueryException;
import model.CustomerByProduct;
import model.Product;
import java.util.ArrayList;

public class ProductManager {
    private ProductDataAccess dao;

    public ProductManager() throws ConnectionException {
        setDao(new ProductDBAccess());
    }

    public void setDao(ProductDataAccess dao) {
        this.dao = dao;
    }

    public ArrayList<Product> getAllProducts()throws SelectQueryException {
        ArrayList<Product> productArrayList = dao.getAllProducts();
        return productArrayList;
    }

    public ArrayList<CustomerByProduct> getProductByReference(Integer reference) throws SelectQueryException, NullException {
        if (reference == null){
            throw new NullException("Reference cannot be null");
        }
        ArrayList<CustomerByProduct> productArrayList = dao.getProductByReference(reference);
        return productArrayList;
    }
}
