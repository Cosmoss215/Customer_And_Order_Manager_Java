package business;

import dataAccess.AddressDataAccess;
import dataAccess.AddressDBAccess;
import exception.ConnectionException;
import exception.QuerySelectException;
import model.Address;
import java.util.ArrayList;

public class AddressManager {
    private AddressDataAccess dao;

    public AddressManager() throws ConnectionException {
        setDao(new AddressDBAccess());
    }

    public void setDao(AddressDataAccess dao) {
        this.dao = dao;
    }

    public ArrayList<Address> getAllAddresses()throws QuerySelectException {
        ArrayList<Address> addressArrayList = dao.getAllAddresses();
//Traitements éventuels sur la liste de livres
        return addressArrayList;
    }
}
