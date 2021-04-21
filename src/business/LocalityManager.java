package business;

import dataAccess.LocalityDataAccess;
import dataAccess.LocalityDBAccess;
import exception.QueryException;
import model.Locality;

import java.net.ConnectException;
import java.util.ArrayList;

public class LocalityManager {
    private LocalityDataAccess dao;

    public LocalityManager(LocalityDataAccess dao) throws ConnectException {
        setDao(new LocalityDBAccess());
    }

    public void setDao(LocalityDataAccess dao) {
        this.dao = dao;
    }

    public ArrayList<Locality> getAllLocalities()throws QueryException {
        return dao.getAllLocalities();
    }
}
