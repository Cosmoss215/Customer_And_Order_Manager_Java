package dataAccess;

import exception.QueryException;
import model.VAT;

import java.util.ArrayList;

public interface VATDataAccess {
    ArrayList<VAT> getAllVAT() throws QueryException;
}
