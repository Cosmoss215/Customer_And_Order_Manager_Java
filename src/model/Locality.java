package model;

public class Locality {
    private String name;
    private Integer postalCode;
    private String region;
    private Country country;

    public Locality(String name, int postalCode, String region, Country country) {
        setName(name);
        setPostalCode(postalCode);
        setRegion(region);
        setCountry(country);
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

    private void setName(String name) {
        this.name = name;
    }

    private void setPostalCode(Integer postalCode){
        this.postalCode = postalCode;
    }

    private void setRegion(String region) {
        this.region = region;
    }

    private void setCountry(Country country) {
        this.country = country;
    }

    public String display() {
        return "Locality{" +
                "name='" + name + '\'' +
                ", postalCode=" + postalCode +
                ", region='" + region + '\'' +
                ", country=" + country +
                '}';
    }

    @Override
    public String toString() {
        return name + " " + postalCode + " " + region;
    }
}
