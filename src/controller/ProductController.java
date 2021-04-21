package controller;

import business.ProductManager;
import exception.QuerySelectException;
import model.Product;

import java.net.ConnectException;
import java.util.ArrayList;

public class ProductController {
    private ProductManager productManager;

    public ProductController() throws ConnectException {
        setProductManager(new ProductManager());
    }

    public void setProductManager(ProductManager productManager) {
        this.productManager = productManager;
    }
    public ArrayList<Product> getAllProducts()throws QuerySelectException {
        return productManager.getAllProducts();
    }
}
