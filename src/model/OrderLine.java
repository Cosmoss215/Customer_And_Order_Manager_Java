package model;

public class OrderLine {
    private final Order order;
    private final Product product;
    private final Integer quantity;
    private final Double allTaxesIncludedPrice;
    private final Boolean hasDiscount;
    private final Double percentageDiscount;

    public OrderLine(Order order, Product product, int quantity, double allTaxesIncludedPrice, boolean hasDiscount, double percentageDiscount) {
        this.order = order;
        this.product = product;
        this.quantity = quantity;
        this.allTaxesIncludedPrice = allTaxesIncludedPrice;
        this.hasDiscount = hasDiscount;
        this.percentageDiscount = percentageDiscount;
    }

}
