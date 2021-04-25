package model;

public class Address {
    private final String streetName;
    private final Integer streetNumber;
    private final String box;
    private final Locality locality;

    public Address(String streetName, Integer streetNumber, String box, Locality locality) {
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.box = box;
        this.locality = locality;
    }

    public Integer getStreetNumber() {
        return streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public Locality getLocality() {
        return locality;
    }

    public String getBox() {
        return box;
    }

    @Override
    public String toString() {
        return "Address{" +
                "streetName='" + streetName + '\'' +
                ", streetNumber=" + streetNumber +
                ", box='" + box + '\'' +
                ", locality=" + locality +
                '}';
    }
}
