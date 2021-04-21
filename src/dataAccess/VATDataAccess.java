package dataAccess;

import exception.QuerySelectException;
import model.VAT;

import java.util.ArrayList;

public interface VATDataAccess {
    ArrayList<VAT> getAllVAT() throws QuerySelectException;
}
