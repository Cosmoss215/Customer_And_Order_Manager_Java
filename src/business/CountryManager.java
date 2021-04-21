package business;

import dataAccess.CountryDBAccess;
import dataAccess.CountryDataAccess;
import exception.QueryException;
import model.Country;

import java.net.ConnectException;
import java.util.ArrayList;

public class CountryManager {
    private CountryDataAccess dao;

    public CountryManager() throws ConnectException {
       setDoa(new CountryDBAccess());
    }

    public void setDoa(CountryDataAccess dao) {
        this.dao = dao;
    }

    public ArrayList<Country> getAllCountry()throws QueryException{
        return dao.getAllCountries();
    }
}
