package business;

import dataAccess.LocalityDataAccess;
import dataAccess.LocalityDBAccess;
import model.Locality;

import java.net.ConnectException;

public class LocalityManager {
    private LocalityDataAccess dao;

    public LocalityManager(LocalityDataAccess dao) throws ConnectException {
        setDao(new LocalityDBAccess());
    }

    public void setDao(LocalityDataAccess dao) {
        this.dao = dao;
    }
}
