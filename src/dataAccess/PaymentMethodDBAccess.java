package dataAccess;

import exception.QueryException;
import model.PaymentMethod;

import java.net.ConnectException;
import java.sql.Connection;
import java.util.ArrayList;

public class PaymentMethodDBAccess implements PaymentMethodDataAccess{
    private Connection connection;

    public PaymentMethodDBAccess()throws ConnectException {
        this.connection = SingletonConnection.getInstance();
    }

    @Override
    public ArrayList<PaymentMethod> getAllPaymentMethod() throws QueryException {
        return null;
    }
}
