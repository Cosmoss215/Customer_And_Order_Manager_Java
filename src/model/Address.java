package model;

import util.Verification;

public class Address {
    private Integer id;
    private String streetName;
    private Integer streetNumber;
    private String box;
    private Locality locality;

    public Address(Integer id, String streetName, Integer streetNumber, String box, Locality locality) {
        this.id = id;
        this.streetName = streetName;
        setStreetNumber(streetNumber);
        setBox(box);
        this.locality = locality;
    }
    //region overload constructor
    public Address(String streetName, Integer streetNumber, String box, Locality locality) {
        this(null, streetName, streetNumber, box, locality);
        setBox(box);
    }
    public Address() {
        this(null, null, null, null, null);
    }
    //endregion
    //region getter
    public Integer getId(){
        return id;
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
    //endregion
    //region setter
    public void setStreetNumber(Integer streetNumber){
        if (streetNumber > 0){
            this.streetNumber = streetNumber;
        }

    }

    public void setBox(String box){
        if (Verification.isAlphabeticCharacters(box)){
            this.box = box;
        }
    }
    //endregion
    //region Display
    @Override
    public String toString() {
        return  getStreetName() + " n°" + getStreetNumber() +
                ((getBox()!=null)?getBox():"") + ", " +
                getLocality().getPostalCode() + " " + getLocality().getName();
    }
    //endregion
}
