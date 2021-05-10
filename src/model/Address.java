package model;

public class Address {
    private Integer id;
    private String streetName;
    private Integer streetNumber;
    private String box;
    private Locality locality;

    public Address(Integer id, String streetName, Integer streetNumber, String box, Locality locality) {
        setId(id);
        setStreetName(streetName);
        setStreetNumber(streetNumber);
        setBox(box);
        setLocality(locality);
    }
    public Address(String streetName, Integer streetNumber, String box, Locality locality) {
        this(null, streetName, streetNumber, box, locality);
        setBox(box);
    }
    public Address() {
        this(null, null, null, null, null);
    }

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

    public void setStreetName(String streetName){
        this.streetName = streetName;
    }

    public void setStreetNumber(Integer streetNumber) {
        this.streetNumber = streetNumber;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public void setBox(String box) {
        if(box != null)
            this.box = box;
        else
            this.box = null;
    }

    public void setLocality(Locality locality){
        this.locality = locality;
    }

    @Override
    public String toString() {
        return  getStreetName() + " n°" + getStreetNumber() +
                ((getBox()!=null)?getBox():"") + ", " +
                getLocality().getPostalCode() + " " + getLocality().getName();
    }
}
