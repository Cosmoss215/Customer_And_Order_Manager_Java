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

    public ArrayList<CustomerByProduct> getProductByReference(String wording) throws SelectQueryException, NullException {
        if (wording == null){
            throw new NullException("Reference cannot be null");
        }
        ArrayList<CustomerByProduct> productArrayList = dao.getProductByReference(wording);
        return productArrayList;
    }
    /** This method returns the total value of the products that are currently stored into the stocks
     */
    public double getStockValue (ArrayList<Product> products){
        double sum = 0;
        for(Product p : products){
            sum += p.getUnitPrice() * p.getStockQuantity();
        }
        return sum;
    }
}
