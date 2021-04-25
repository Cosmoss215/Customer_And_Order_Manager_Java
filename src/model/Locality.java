package model;

public class Locality {
    private final String name;
    private final Integer postalCode;
    private final String region;
    private final Country country;

    public Locality(String name, int postalCode, String region, Country country) {
        this.name = name;
        this.postalCode = postalCode;
        this.region = region;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public Country getCountry() {
        return country;
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    public String getRegion() {
        return region;
    }

    @Override
    public String toString() {
        return "Locality{" +
                "name='" + name + '\'' +
                ", postalCode=" + postalCode +
                ", region='" + region + '\'' +
                ", country=" + country +
                '}';
    }
}
