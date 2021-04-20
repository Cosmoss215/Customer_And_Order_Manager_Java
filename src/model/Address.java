package model;

public class Address {
    private final String streetName;
    private final Integer streetNumber;
    private final char box;
    private final Locality locality;

    public Address(String streetName, int streetNumber, char box, Locality locality) {
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.box = box;
        this.locality = locality;
    }
}
