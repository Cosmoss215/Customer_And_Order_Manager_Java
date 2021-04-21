package dataAccess;

import exception.QueryException;
import model.Locality;

import java.util.ArrayList;

public interface LocalityDataAccess {
    ArrayList<Locality> getAllLocality() throws QueryException;
}
