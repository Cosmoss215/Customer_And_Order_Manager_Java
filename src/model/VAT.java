package model;

public class VAT {
    private String category;
    private Double rate;

    public VAT(String category, Double rate) {
        this.category = category;
        setRate(rate);
    }
    //region getter
    public String getCategory() {
        return category;
    }
    public Double getRate() {
        return rate;
    }
    //endregion
    //region setter
    private void setRate(Double rate){
        if (rate >= 0) {
            this.rate = rate;
        }
    }
    //endregion
}
