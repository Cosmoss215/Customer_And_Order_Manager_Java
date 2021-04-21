package controller;

import business.PaymentMethodManager;
import exception.QuerySelectException;
import model.PaymentMethod;

import java.net.ConnectException;
import java.util.ArrayList;

public class PaymentMethodController {
    private PaymentMethodManager paymentMethodManager;

    public PaymentMethodController() throws ConnectException {
        setPaymentMethodManager(new PaymentMethodManager());
    }

    public void setPaymentMethodManager(PaymentMethodManager paymentMethodManager) {
        this.paymentMethodManager = paymentMethodManager;
    }
    public ArrayList<PaymentMethod> getAllPaymentMethods()throws QuerySelectException {
        return paymentMethodManager.getAllPaymentMethods();
    }
}
