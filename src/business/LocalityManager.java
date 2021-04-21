package business;

import dataAccess.LocalityDataAccess;
import dataAccess.LocalityDBAccess;
import exception.QuerySelectException;
import model.Customer;
import model.Locality;

import java.net.ConnectException;
import java.util.ArrayList;

public class LocalityManager {
    private LocalityDataAccess dao;

    public LocalityManager() throws ConnectException {
        setDao(new LocalityDBAccess());
    }

    public void setDao(LocalityDataAccess dao) {
        this.dao = dao;
    }

    public ArrayList<Locality> getAllLocalities()throws QuerySelectException {
        ArrayList<Locality> localityArrayList = dao.getAllLocalities();
        //Traitements éventuels sur la liste de livres
        return localityArrayList;
    }
}
