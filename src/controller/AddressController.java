package controller;

import business.AddressManager;
import exception.QuerySelectException;
import model.Address;

import java.net.ConnectException;
import java.util.ArrayList;

public class AddressController {
    private AddressManager addressManager;

    public AddressController() throws ConnectException {
        setAddressManager(new AddressManager());
    }

    public void setAddressManager(AddressManager addressManager) {
        this.addressManager = addressManager;
    }
    public ArrayList<Address> getAllAddresses()throws QuerySelectException {
        return addressManager.getAllAddresses();
    }


    public AddressManager getAddressManager() {
        return addressManager;
    }
}
