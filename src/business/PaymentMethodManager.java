package business;

import dataAccess.PaymentMethodDataAccess;
import dataAccess.PaymentMethodDBAccess;
import exception.ConnectionException;
import exception.SelectQueryException;
import model.PaymentMethod;
import java.util.ArrayList;

public class PaymentMethodManager {
    private PaymentMethodDataAccess dao;

    public PaymentMethodManager() throws ConnectionException {
        setDao(new PaymentMethodDBAccess());
    }

    public void setDao(PaymentMethodDataAccess dao) {
        this.dao = dao;
    }

    public ArrayList<PaymentMethod> getAllPaymentMethods()throws SelectQueryException {
        ArrayList<PaymentMethod> paymentMethodArrayList = dao.getAllPaymentMethods();
        //Traitements éventuels sur la liste de livres
        return paymentMethodArrayList;
    }
}
