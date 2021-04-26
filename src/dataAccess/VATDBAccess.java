package dataAccess;

import exception.ConnectionException;
import exception.SelectQueryException;
import model.VAT;
import java.sql.Connection;
import java.util.ArrayList;

public class VATDBAccess implements VATDataAccess{

    private Connection connection;

    public VATDBAccess()throws ConnectionException {
        this.connection = SingletonConnection.getInstance();
    }

    @Override
    public ArrayList<VAT> getAllVAT() throws SelectQueryException {
        ArrayList<VAT> allAllVAT = new ArrayList<>();
        //Accès à la base de données
        return allAllVAT;
    }
}
