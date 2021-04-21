package business;

import dataAccess.AddressDataAccess;
import dataAccess.AddressDBAccess;
import exception.QueryException;
import model.Address;

import java.net.ConnectException;
import java.util.ArrayList;

public class AddressManager {
    private AddressDataAccess dao;

    public AddressManager() throws ConnectException {
        setDao(new AddressDBAccess());
    }

    public void setDao(AddressDataAccess dao) {
        this.dao = dao;
    }

    public ArrayList<Address> getAllAddress()throws QueryException{
        return dao.getAllAddress();
    }
}
