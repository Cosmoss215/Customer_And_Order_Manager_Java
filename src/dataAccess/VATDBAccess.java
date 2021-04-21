package dataAccess;

import exception.QuerySelectException;
import model.Product;
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
    public ArrayList<VAT> getAllVAT() throws QuerySelectException {
        ArrayList<VAT> allAllVAT = new ArrayList<>();
        //Accès à la base de données
        return allAllVAT;
    }
}
