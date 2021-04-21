package dataAccess;

import exception.QuerySelectException;
import model.Customer;
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
    public ArrayList<Locality> getAllLocalities() throws QuerySelectException {
        ArrayList<Locality> allLocalities = new ArrayList<>();
        //Accès à la base de données
        return allLocalities;
    }
}
