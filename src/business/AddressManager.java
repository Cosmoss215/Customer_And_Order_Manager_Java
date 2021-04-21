package business;

import dataAccess.AddressDataAccess;
import dataAccess.AddressDBAccess;
import model.Address;

import java.net.ConnectException;

public class AddressManager {
    private AddressDataAccess dao;

    public AddressManager() throws ConnectException {
        setDao(new AddressDBAccess());
    }

    public void setDao(AddressDataAccess dao) {
        this.dao = dao;
    }
}
