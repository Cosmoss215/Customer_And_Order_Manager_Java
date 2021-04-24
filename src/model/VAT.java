package model;

public class VAT {
    private final String category;
    private final Double rate;

    public VAT(String category, Double rate) {
        this.category = category;
        this.rate = rate;
    }
    public VAT(String category)
    {
        this.category = category;
        this.rate = 0.00;
    }

    public String getCategory() {
        return category;
    }
}
