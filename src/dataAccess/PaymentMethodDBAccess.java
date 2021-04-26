package dataAccess;

import exception.ConnectionException;
import exception.SelectQueryException;
import model.PaymentMethod;
import java.sql.Connection;
import java.util.ArrayList;

public class PaymentMethodDBAccess implements PaymentMethodDataAccess{
    private Connection connection;

    public PaymentMethodDBAccess()throws ConnectionException {
        this.connection = SingletonConnection.getInstance();
    }

    @Override
    public ArrayList<PaymentMethod> getAllPaymentMethods() throws SelectQueryException {
        ArrayList<PaymentMethod> allPaymentMethods= new ArrayList<>();
        //Accès à la base de données
        return allPaymentMethods;
    }
}
