package dataAccess;

import exception.QueryException;
import model.VAT;

import java.net.ConnectException;
import java.sql.Connection;
import java.util.ArrayList;

public class VATDBAccess implements VATDataAccess{

    private Connection connection;

    public VATDBAccess()throws ConnectException {
        this.connection = SingletonConnection.getInstance();
    }

    @Override
    public ArrayList<VAT> getAllVAT() throws QueryException {
        return null;
    }
}
