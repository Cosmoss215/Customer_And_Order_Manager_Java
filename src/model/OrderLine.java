package model;

public class OrderLine {
    private Order order;
    private Product product;
    private Integer quantity;
    private Double allTaxesIncludedPrice;
    private Boolean hasDiscount;
    private Double percentageDiscount;

    public OrderLine(Order order, Product product, int quantity, double allTaxesIncludedPrice, boolean hasDiscount, double percentageDiscount) {
        this.order = order;
        this.product = product;
        setQuantity(quantity);
        setAllTaxesIncludedPrice(allTaxesIncludedPrice);
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
    public void setAllTaxesIncludedPrice(Double allTaxesIncludedPrice) {
        if (allTaxesIncludedPrice > 0){
            this.allTaxesIncludedPrice = allTaxesIncludedPrice;
        }
    }
    public void setPercentageDiscount(Double percentageDiscount) {
        if (percentageDiscount > 0) {
            this.percentageDiscount = percentageDiscount;
        }
    }
    //endregion
}
