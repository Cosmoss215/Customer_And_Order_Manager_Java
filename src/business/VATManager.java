package business;

import dataAccess.VATDataAccess;
import dataAccess.VATDBAccess;
import model.VAT;

import java.net.ConnectException;


public class VATManager {
    private VATDataAccess dao;

    public VATManager(VATDataAccess dao) throws ConnectException {
        setDao(new VATDBAccess());
    }

    public void setDao(VATDataAccess dao) {
        this.dao = dao;
    }
}
