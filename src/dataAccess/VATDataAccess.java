package dataAccess;

import exception.SelectQueryException;
import model.VAT;

import java.util.ArrayList;

public interface VATDataAccess {
    ArrayList<VAT> getAllVAT() throws SelectQueryException;
}
