package business;

import dataAccess.CountryDBAccess;
import dataAccess.CountryDataAccess;
import exception.QuerySelectException;
import model.Address;
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

    public ArrayList<Country> getAllCountries()throws QuerySelectException {
        ArrayList<Country> countryArrayList = dao.getAllCountries();
//Traitements éventuels sur la liste de livres
        return countryArrayList;
    }
}
