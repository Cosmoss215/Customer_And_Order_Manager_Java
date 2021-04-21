package controller;

import business.CountryManager;
import exception.QuerySelectException;
import model.Country;

import java.net.ConnectException;
import java.util.ArrayList;

public class CountryController {
    private CountryManager countryManager;

    public CountryController() throws ConnectException {
        setCountryManager(new CountryManager());
    }

    public void setCountryManager(CountryManager countryManager) {
        this.countryManager = countryManager;
    }

    public ArrayList<Country> getAllCountries()throws QuerySelectException {
        return countryManager.getAllCountries();
    }
}
