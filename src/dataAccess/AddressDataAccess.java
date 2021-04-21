package dataAccess;

import exception.QueryException;
import java.util.ArrayList;
import model.Address;

public interface AddressDataAccess {
    ArrayList<Address> getAllAddress() throws QueryException;
}
