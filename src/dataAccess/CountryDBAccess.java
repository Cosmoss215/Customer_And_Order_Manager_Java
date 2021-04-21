package dataAccess;

import model.Country;

import java.net.ConnectException;
import java.sql.Connection;

public class CountryDBAccess implements CountryDataAccess {

    private Connection connection;

    public CountryDBAccess()throws ConnectException {
        this.connection = SingletonConnection.getInstance();
    }
}
