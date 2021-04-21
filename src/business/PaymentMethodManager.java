package business;

import dataAccess.PaymentMethodDataAccess;
import dataAccess.PaymentMethodDBAccess;
import model.PaymentMethod;

import java.net.ConnectException;

public class PaymentMethodManager {
    private PaymentMethodDataAccess dao;

    public PaymentMethodManager(PaymentMethodDataAccess dao) throws ConnectException {
        setDao(new PaymentMethodDBAccess());
    }

    public void setDao(PaymentMethodDataAccess dao) {
        this.dao = dao;
    }
}
