package business;

import dataAccess.LocalityDataAccess;
import dataAccess.LocalityDBAccess;
import exception.ConnectionException;
import exception.SelectQueryException;
import model.Locality;
import java.util.ArrayList;

public class LocalityManager {
    private LocalityDataAccess dao;

    public LocalityManager() throws ConnectionException {
        setDao(new LocalityDBAccess());
    }

    public void setDao(LocalityDataAccess dao) {
        this.dao = dao;
    }

    public ArrayList<Locality> getAllLocalities()throws SelectQueryException {
        ArrayList<Locality> localityArrayList = dao.getAllLocalities();
        //Traitements éventuels sur la liste de livres
        return localityArrayList;
    }
}
