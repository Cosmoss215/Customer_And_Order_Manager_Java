package model;

public class Locality {
    private String name;
    private Integer postalCode;
    private String region;
    private Country country;

    public Locality(String name, Integer postalCode, String region, Country country) {
        setName(name);
        setPostalCode(postalCode);
        setRegion(region);
        setCountry(country);
    }
    public Locality(){
        this(null,null,null,null);
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

    public void setName(String name) {
        this.name = name;
    }

    public void setPostalCode(Integer postalCode){
        this.postalCode = postalCode;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setCountry(Country country) {
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
