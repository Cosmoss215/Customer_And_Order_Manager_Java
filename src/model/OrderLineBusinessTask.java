package model;

import java.util.GregorianCalendar;

public class OrderLineBusinessTask {
    private Integer productReference;
    private String productWording;
    private Integer quantity;
    private Double priceSold;
    private Boolean hasDiscount;
    private Double percentageDiscount;

    public OrderLineBusinessTask(Integer productReference, String productWording, Integer quantity, Double priceSold, Boolean hasDiscount, Double percentageDiscount) {
        this.productReference = productReference;
        this.productWording = productWording;
        this.quantity = quantity;
        this.priceSold = priceSold;
        this.hasDiscount = hasDiscount;
        this.percentageDiscount = percentageDiscount;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Boolean getHasDiscount() {
        return hasDiscount;
    }

    public Double getPriceSold() {
        return priceSold;
    }

    public Double getPercentageDiscount() {
        return percentageDiscount;
    }

    public Integer getProductReference() {
        return productReference;
    }

    public String getProductWording() {
        return productWording;
    }
}
