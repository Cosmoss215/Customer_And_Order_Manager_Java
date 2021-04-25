package dataAccess;

import exception.QuerySelectException;
import model.Country;
import java.util.ArrayList;

public interface CountryDataAccess {

    ArrayList<Country> getAllCountries() throws QuerySelectException;
}
