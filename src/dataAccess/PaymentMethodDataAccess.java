package dataAccess;

import exception.QuerySelectException;
import model.PaymentMethod;

import java.util.ArrayList;

public interface PaymentMethodDataAccess {
    ArrayList<PaymentMethod> getAllPaymentMethods() throws QuerySelectException;
}
