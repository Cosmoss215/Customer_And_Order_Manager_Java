package dataAccess;

import exception.ConnectionException;
import exception.SelectQueryException;
import model.Country;
import model.Locality;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LocalityDBAccess implements LocalityDataAccess{
    private Connection connection;

    public LocalityDBAccess()throws ConnectionException {
        this.connection = SingletonConnection.getInstance();
    }

    @Override
    public ArrayList<Locality> getAllLocalities() throws SelectQueryException {
        ArrayList<Locality> allLocalities = new ArrayList<>();
        try {
            String sqlInstruction = "SELECT l.*,c.* from locality l join country c on c.code = l.country;";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInstruction);
            ResultSet data = preparedStatement.executeQuery();
            Locality locality;
            Country country;

            while (data.next()){
                country = new Country(
                        data.getString("code"),
                        data.getString("c.name")
                );
                locality = new Locality(
                        data.getString("name"),
                        data.getInt("postal_code"),
                        data.getString("region"),
                        country
                );
                allLocalities.add(locality);
            }
        } catch (SQLException throwables) {
            throw new SelectQueryException();
        }

        return allLocalities;
    }
    public boolean localityExists(String localityName) throws SelectQueryException {
        String sqlInstruction = "SELECT name from locality where name = \'%" + localityName + "%\';";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInstruction);
            ResultSet data = preparedStatement.executeQuery();
            if(data.wasNull()){
                return false;
            }

        } catch (SQLException throwables) {
            throw new SelectQueryException();
        }
        return true;
    }
}
