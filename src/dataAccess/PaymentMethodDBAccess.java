package dataAccess;

import exception.QuerySelectException;
import model.OrderLine;
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
    public ArrayList<PaymentMethod> getAllPaymentMethods() throws QuerySelectException {
        ArrayList<PaymentMethod> allPaymentMethods= new ArrayList<>();
        //Accès à la base de données
        return allPaymentMethods;
    }
}
