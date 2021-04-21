package controller;

import business.LocalityManager;
import exception.QuerySelectException;
import model.Locality;

import java.net.ConnectException;
import java.util.ArrayList;

public class LocalityController {
    private LocalityManager localityManager;

    public LocalityController() throws ConnectException {
        setLocalityManager(new LocalityManager());
    }

    public void setLocalityManager(LocalityManager localityManager) {
        this.localityManager = localityManager;
    }

    public ArrayList<Locality> getAllLocalities()throws QuerySelectException {
        return localityManager.getAllLocalities();
    }

}
