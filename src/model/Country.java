package model;

public class Country {
    private String code;
    private String name;

    public Country(String code, String name) {
        this.code = code;
        this.name = name;
    }
    //region overload constructor
    public Country(String code) {
        this(code,null);
    }
    //endregion
    //region setter
    public String getName() {
        return name;
    }
    public String getCode() {
        return code;
    }
    //endregion
    //region Display
    @Override
    public String toString() {
        return code + " " + name;
    }
    //endregion
}
