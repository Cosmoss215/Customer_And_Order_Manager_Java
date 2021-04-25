package business;

import dataAccess.ProductDataAccess;
import dataAccess.ProductDBAccess;
import exception.ConnectionException;
import exception.QuerySelectException;
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

    public ArrayList<Product> getAllProducts()throws QuerySelectException {
        ArrayList<Product> productArrayList = dao.getAllProducts();
        //Traitements éventuels sur la liste de livres
        return productArrayList;
    }
}
