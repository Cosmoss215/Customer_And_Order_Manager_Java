package dataAccess;

import exception.ConnectionException;
import exception.QuerySelectException;
import model.Address;
import java.sql.Connection;
import java.util.ArrayList;

public class AddressDBAccess implements AddressDataAccess{
    private Connection connection;

    public AddressDBAccess()throws ConnectionException {
        this.connection = SingletonConnection.getInstance();
    }

    @Override
    public ArrayList<Address> getAllAddresses() throws QuerySelectException {
        ArrayList<Address> allAddresses = new ArrayList<>();
        //Accès à la base de données
        return allAddresses;
    }

}
