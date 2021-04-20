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
}
