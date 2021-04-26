package dataAccess;

import exception.SelectQueryException;
import java.util.ArrayList;
import model.Address;

public interface AddressDataAccess {
    ArrayList<Address> getAllAddresses() throws SelectQueryException;
}
