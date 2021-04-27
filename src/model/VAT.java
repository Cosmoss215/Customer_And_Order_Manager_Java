package model;

public class VAT {
    private String category;
    private Double rate;

    public VAT(String category, Double rate) {
        setCategory(category);
        setRate(rate);
    }

    public String getCategory() {
        return category;
    }

    public Double getRate() {
        return rate;
    }

    private void setCategory(String category){
        this.category = category;
    }

    private void setRate(Double rate){
        this.rate = rate;
    }
}
