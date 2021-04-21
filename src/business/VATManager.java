package business;

import dataAccess.VATDataAccess;
import dataAccess.VATDBAccess;
import exception.QuerySelectException;
import model.Customer;
import model.VAT;

import java.net.ConnectException;
import java.util.ArrayList;


public class VATManager {
    private VATDataAccess dao;

    public VATManager() throws ConnectException {
        setDao(new VATDBAccess());
    }

    public void setDao(VATDataAccess dao) {
        this.dao = dao;
    }

    public ArrayList<VAT> getAllVAT()throws QuerySelectException {
        ArrayList<VAT> vatArrayList = dao.getAllVAT();
        //Traitements éventuels sur la liste de livres
        return vatArrayList;
    }
}
