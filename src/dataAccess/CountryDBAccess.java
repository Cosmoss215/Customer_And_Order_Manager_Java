package dataAccess;

import exception.QueryException;
import model.Country;

import java.net.ConnectException;
import java.sql.Connection;
import java.util.ArrayList;

public class CountryDBAccess implements CountryDataAccess {

    private Connection connection;

    public CountryDBAccess()throws ConnectException {
        this.connection = SingletonConnection.getInstance();
    }

    @Override
    public ArrayList<Country> getAllCountry() throws QueryException {
        return null;
    }
}
