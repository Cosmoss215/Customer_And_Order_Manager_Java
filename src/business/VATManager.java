package business;

import dataAccess.VATDataAccess;
import dataAccess.VATDBAccess;
import exception.QueryException;
import model.Product;
import model.VAT;

import java.net.ConnectException;
import java.util.ArrayList;


public class VATManager {
    private VATDataAccess dao;

    public VATManager(VATDataAccess dao) throws ConnectException {
        setDao(new VATDBAccess());
    }

    public void setDao(VATDataAccess dao) {
        this.dao = dao;
    }

    public ArrayList<VAT> getAllVAT()throws QueryException {
        return dao.getAllVAT();
    }
}
