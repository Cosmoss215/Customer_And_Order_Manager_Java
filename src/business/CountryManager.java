package business;

import dataAccess.CountryDBAccess;
import dataAccess.CountryDataAccess;
import model.Country;

import java.net.ConnectException;

public class CountryManager {
    private CountryDataAccess dao;

    public CountryManager() throws ConnectException {
       setDoa(new CountryDBAccess());
    }

    public void setDoa(CountryDataAccess dao) {
        this.dao = dao;
    }
}
