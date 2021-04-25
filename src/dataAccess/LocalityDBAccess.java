package dataAccess;

import exception.ConnectionException;
import exception.QuerySelectException;
import model.Locality;
import java.sql.Connection;
import java.util.ArrayList;

public class LocalityDBAccess implements LocalityDataAccess{
    private Connection connection;

    public LocalityDBAccess()throws ConnectionException {
        this.connection = SingletonConnection.getInstance();
    }

    @Override
    public ArrayList<Locality> getAllLocalities() throws QuerySelectException {
        ArrayList<Locality> allLocalities = new ArrayList<>();
        //Accès à la base de données
        return allLocalities;
    }
}
