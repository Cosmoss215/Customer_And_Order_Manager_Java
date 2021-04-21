package dataAccess;

import exception.QueryException;
import model.Locality;

import java.net.ConnectException;
import java.sql.Connection;
import java.util.ArrayList;

public class LocalityDBAccess implements LocalityDataAccess{
    private Connection connection;

    public LocalityDBAccess()throws ConnectException {
        this.connection = SingletonConnection.getInstance();
    }

    @Override
    public ArrayList<Locality> getAllLocalities() throws QueryException {
        return null;
    }
}
