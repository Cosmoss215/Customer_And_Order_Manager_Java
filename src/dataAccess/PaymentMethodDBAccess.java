package dataAccess;

import model.PaymentMethod;

import java.net.ConnectException;
import java.sql.Connection;

public class PaymentMethodDBAccess implements PaymentMethodDataAccess{
    private Connection connection;

    public PaymentMethodDBAccess()throws ConnectException {
        this.connection = SingletonConnection.getInstance();
    }
}
