package model;

public class Country {
    private String code;
    private String name;

    public Country(String code, String name) {
        setCode(code);
        setName(name);
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code){
        this.code = code;
    }

    public void setName(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return code + " " + name;
    }
}
