package dataAccess;

import exception.ConnectionException;
import exception.QuerySelectException;
import model.Product;
import model.VAT;

import java.sql.*;
import java.util.ArrayList;

public class ProductDBAccess implements ProductDataAccess{
    private Connection connection;

    public ProductDBAccess()throws ConnectionException {
        this.connection = SingletonConnection.getInstance();
    }

    @Override
    public ArrayList<Product> getAllProducts() throws QuerySelectException {
        ArrayList<Product> allProducts = new ArrayList<>();
        String sqlInstruction = "SELECT * FROM Product";

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?useSSL=false", "root", "Manil93Manderlier97");
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInstruction);
            ResultSet data = preparedStatement.executeQuery();

            Product product;
            VAT vatCode;

            while (data.next()) {
                vatCode = new VAT(data.getString("vat_code"));

                product = new Product(
                        data.getInt("reference"),
                        data.getString("wording"),
                        data.getDouble("unit_price"),
                        data.getInt("stock_quantity"),
                        data.getString("description"),
                        vatCode.getCategory()
                );

                allProducts.add(product);

            }

        } catch (SQLException throwables) {
            throw new QuerySelectException();
        }

        return allProducts;
    }

    @Override
    public ArrayList<Product> getProductsByReference() throws QuerySelectException {
        return null;
    }
}
