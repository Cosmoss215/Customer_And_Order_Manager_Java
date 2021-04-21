package dataAccess;

import exception.QueryException;
import model.Address;
import java.net.ConnectException;
import java.sql.Connection;
import java.util.ArrayList;

public class AddressDBAccess implements AddressDataAccess{
    private Connection connection;

    public AddressDBAccess()throws ConnectException{
        this.connection = SingletonConnection.getInstance();
    }

    @Override
    public ArrayList<Address> getAllAddress() throws QueryException {
        return null;
    }

}
