package dataAccess;

import exception.QuerySelectException;
import model.Locality;

import java.util.ArrayList;

public interface LocalityDataAccess {
    ArrayList<Locality> getAllLocalities() throws QuerySelectException;
}
