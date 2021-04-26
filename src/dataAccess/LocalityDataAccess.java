package dataAccess;

import exception.SelectQueryException;
import model.Locality;

import java.util.ArrayList;

public interface LocalityDataAccess {
    ArrayList<Locality> getAllLocalities() throws SelectQueryException;
}
