package dataAccess;

import model.VAT;

import java.net.ConnectException;
import java.sql.Connection;

public class VATDBAccess implements VATDataAccess{

    private Connection connection;

    public VATDBAccess()throws ConnectException {
        this.connection = SingletonConnection.getInstance();
    }
}
