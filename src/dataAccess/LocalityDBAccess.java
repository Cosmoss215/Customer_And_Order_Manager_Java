package dataAccess;

import model.Locality;

import java.net.ConnectException;
import java.sql.Connection;

public class LocalityDBAccess implements LocalityDataAccess{
    private Connection connection;

    public LocalityDBAccess()throws ConnectException {
        this.connection = SingletonConnection.getInstance();
    }
}
