package dataAccess;

import exception.QueryException;
import model.PaymentMethod;

import java.util.ArrayList;

public interface PaymentMethodDataAccess {
    ArrayList<PaymentMethod> getAllPaymentMethods() throws QueryException;
}
