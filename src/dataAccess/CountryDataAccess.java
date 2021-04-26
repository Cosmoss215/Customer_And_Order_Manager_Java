package dataAccess;

import exception.SelectQueryException;
import model.Country;
import java.util.ArrayList;

public interface CountryDataAccess {

    ArrayList<Country> getAllCountries() throws SelectQueryException;
}
