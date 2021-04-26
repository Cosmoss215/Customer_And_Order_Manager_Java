package dataAccess;

import exception.SelectQueryException;
import model.PaymentMethod;

import java.util.ArrayList;

public interface PaymentMethodDataAccess {
    ArrayList<PaymentMethod> getAllPaymentMethods() throws SelectQueryException;
}
