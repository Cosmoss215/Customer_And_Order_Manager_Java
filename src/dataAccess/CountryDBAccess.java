package dataAccess;

import exception.ConnectionException;
import exception.QuerySelectException;
import model.Country;

import java.sql.Connection;
import java.util.ArrayList;

public class CountryDBAccess implements CountryDataAccess {

    private Connection connection;

    public CountryDBAccess()throws ConnectionException {
        this.connection = SingletonConnection.getInstance();
    }

    @Override
    public ArrayList<Country> getAllCountries() throws QuerySelectException {
        ArrayList<Country> allCountries = new ArrayList<>();
        //Accès à la base de données
        return allCountries;
    }
}
