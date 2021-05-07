package dataAccess;

import exception.ConnectionException;
import exception.SelectQueryException;
import model.*;

import java.sql.*;
import java.util.ArrayList;

public class ProductDBAccess implements ProductDataAccess {
    private Connection connection;

    public ProductDBAccess() throws ConnectionException {
        this.connection = SingletonConnection.getInstance();
    }

    @Override
    public ArrayList<Product> getAllProducts() throws SelectQueryException {
        ArrayList<Product> allProducts = new ArrayList<>();

        String sqlInstruction = "SELECT p.reference, p.wording, p.unit_price, p.stock_quantity, p.description, p.vat_code, v.rate " +
                                "FROM product p " +
                                "JOIN vat v ON p.vat_code = v.category;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInstruction);
            ResultSet data = preparedStatement.executeQuery();

            Product product;
            VAT vat;

            while (data.next()) {
                vat = new VAT(
                        data.getString("vat_code"),
                        data.getDouble("rate")
                );

                product = new Product(
                        data.getInt("reference"),
                        data.getString("wording"),
                        data.getDouble("unit_price"),
                        data.getInt("stock_quantity"),
                        data.getString("description"),
                        vat
                );

                allProducts.add(product);

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new SelectQueryException();
        }

        return allProducts;
    }

    @Override
    public ArrayList<CustomerByProduct> getProductByReference(Integer reference) throws SelectQueryException {
        ArrayList<CustomerByProduct> productByReference = new ArrayList<>();

        String sqlInstruction = "SELECT cu.last_name, cu.first_name, ol.quantity,pm.wording " +
                "from product p " +
                "JOIN order_line ol ON p.reference = ol.product " +
                "JOIN `order` o ON o.number = ol.`order` " +
                "JOIN customer cu ON cu.id = o.customer " +
                "JOIN payment_method pm ON pm.wording = o.payment_method " +
                "WHERE p.reference = "+reference+";";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInstruction);
            ResultSet data = preparedStatement.executeQuery();

            CustomerByProduct customerByProduct;

            while (data.next()) {
                customerByProduct = new CustomerByProduct(
                        data.getString("last_name"),
                        data.getString("first_name"),
                        data.getInt("quantity"),
                        data.getString("wording")
                );
                productByReference.add(customerByProduct);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new SelectQueryException();
        }

        return productByReference;
    }
}
