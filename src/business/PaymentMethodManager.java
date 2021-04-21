package business;

import dataAccess.PaymentMethodDataAccess;
import dataAccess.PaymentMethodDBAccess;
import exception.QueryException;
import model.Customer;
import model.PaymentMethod;

import java.net.ConnectException;
import java.util.ArrayList;

public class PaymentMethodManager {
    private PaymentMethodDataAccess dao;

    public PaymentMethodManager(PaymentMethodDataAccess dao) throws ConnectException {
        setDao(new PaymentMethodDBAccess());
    }

    public void setDao(PaymentMethodDataAccess dao) {
        this.dao = dao;
    }

    public ArrayList<PaymentMethod> getAllPaymentMethods()throws QueryException {
        return dao.getAllPaymentMethods();
    }
}
