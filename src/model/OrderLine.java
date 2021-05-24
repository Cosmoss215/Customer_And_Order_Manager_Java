package model;

public class OrderLine {
    private Order order;
    private Product product;
    private Integer quantity;
    private Double priceSold;
    private Boolean hasDiscount;
    private Double percentageDiscount;

    public OrderLine(Order order, Product product, int quantity, double priceSold, boolean hasDiscount, double percentageDiscount) {
        this.order = order;
        this.product = product;
        setQuantity(quantity);
        setPriceSold(priceSold);
        this.hasDiscount = hasDiscount;
        setPercentageDiscount(percentageDiscount);
    }
    //region getter
    public Order getOrder() { return order; }
    public Product getProduct() { return product; }
    //endregion
    //region setter
    public void setQuantity(Integer quantity) {
        if (quantity > 0){
            this.quantity = quantity;
        }

    }
    public void setPriceSold(Double priceSold) {
        if (priceSold > 0){
            this.priceSold = priceSold;
        }
    }
    public void setPercentageDiscount(Double percentageDiscount) {
        if (percentageDiscount > 0) {
            this.percentageDiscount = percentageDiscount;
        }
    }
    //endregion

}
