package business;

import dataAccess.PaymentMethodDataAccess;
import dataAccess.PaymentMethodDBAccess;
import exception.QuerySelectException;
import model.Customer;
import model.PaymentMethod;

import java.net.ConnectException;
import java.util.ArrayList;

public class PaymentMethodManager {
    private PaymentMethodDataAccess dao;

    public PaymentMethodManager() throws ConnectException {
        setDao(new PaymentMethodDBAccess());
    }

    public void setDao(PaymentMethodDataAccess dao) {
        this.dao = dao;
    }

    public ArrayList<PaymentMethod> getAllPaymentMethods()throws QuerySelectException {
        ArrayList<PaymentMethod> paymentMethodArrayList = dao.getAllPaymentMethods();
        //Traitements éventuels sur la liste de livres
        return paymentMethodArrayList;
    }
}
