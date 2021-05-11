package model;

public class Locality {
    private String name;
    private Integer postalCode;
    private String region;
    private Country country;

    public Locality(String name, Integer postalCode, String region, Country country) {
        this.name = name;
        setPostalCode(postalCode);
        this.region = region;
        this.country = country;
    }
    //region getter
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
    //endregion
    //region setter
    public void setPostalCode(Integer postalCode){
        if (postalCode >= 1000 && postalCode <= 999999999) {
            this.postalCode = postalCode;
        }
    }
    //endregion
    //region Display
    @Override
    public String toString() {
        return name + " " + postalCode + " " + region;
    }
    //endregion
}
