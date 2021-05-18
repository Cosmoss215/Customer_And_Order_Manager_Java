package dataAccess;

import exception.ConnectionException;
import exception.SelectQueryException;
import model.Country;
import model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CountryDBAccess implements CountryDataAccess {

    private final Connection connection;

    public CountryDBAccess()throws ConnectionException {
        this.connection = SingletonConnection.getInstance();
    }

    @Override
    public ArrayList<Country> getAllCountries() throws SelectQueryException {
        ArrayList<Country> allCountries = new ArrayList<>();
        try {
            String sqlSelectCountry = "SELECT name FROM country;";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlSelectCountry);
            ResultSet data = preparedStatement.executeQuery();
            Country country;

            while (data.next()){
                country = new Country(
                        data.getString("code"),
                        data.getString("name")
                );
                allCountries.add(country);
            }

    } catch (SQLException exception) {
            throw new SelectQueryException(exception.getMessage());
        }
        return allCountries;
    }
}
