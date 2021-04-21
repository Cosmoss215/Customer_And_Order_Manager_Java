package dataAccess;

import exception.DBQueryException;
import java.util.ArrayList;
import model.Address;

public interface AddressDataAccess {
    ArrayList<Address> getAllCities() throws DBQueryException;
}
