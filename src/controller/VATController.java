package controller;

import business.VATManager;
import exception.QuerySelectException;
import model.VAT;

import java.net.ConnectException;
import java.util.ArrayList;

public class VATController {
    private VATManager vatManager;

    public VATController() throws ConnectException {
        setVatManager(new VATManager());
    }

    public void setVatManager(VATManager vatManager) {
        this.vatManager = vatManager;
    }
    public ArrayList<VAT> getAllVAT()throws QuerySelectException {
        return vatManager.getAllVAT();
    }
}
