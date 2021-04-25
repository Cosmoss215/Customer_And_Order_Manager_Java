package dataAccess;

import exception.QuerySelectException;
import java.util.ArrayList;
import model.Address;

public interface AddressDataAccess {
    ArrayList<Address> getAllAddresses() throws QuerySelectException;
}
