package dataAccess;

import exception.QueryException;
import model.Country;
import java.util.ArrayList;

public interface CountryDataAccess {

    ArrayList<Country> getAllCountry() throws QueryException;
}
