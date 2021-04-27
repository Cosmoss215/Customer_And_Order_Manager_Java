package model;

public class OrderLine {
    private Order order;
    private Product product;
    private Integer quantity;
    private Double allTaxesIncludedPrice;
    private Boolean hasDiscount;
    private Double percentageDiscount;

    public OrderLine(Order order, Product product, int quantity, double allTaxesIncludedPrice, boolean hasDiscount, double percentageDiscount) {
        setOrder(order);
        setProduct(product);
        setQuantity(quantity);
        setAllTaxesIncludedPrice(allTaxesIncludedPrice); // A MODIFIER !!!!
        setHasDiscount(hasDiscount);
        setPercentageDiscount(percentageDiscount);
    }

    public Order getOrder() { return order; }

    public Product getProduct() { return product; }

    public Integer getQuantity() { return quantity; }

    public Double getAllTaxesIncludedPrice() { return allTaxesIncludedPrice; }

    public Boolean getHasDiscount() { return hasDiscount; }

    public Double getPercentageDiscount() { return percentageDiscount; }

    private void setOrder(Order order){ this.order = order; }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setAllTaxesIncludedPrice(Double allTaxesIncludedPrice) {
        this.allTaxesIncludedPrice = allTaxesIncludedPrice;
    }

    public void setHasDiscount(Boolean hasDiscount) {
        this.hasDiscount = hasDiscount;
    }

    public void setPercentageDiscount(Double percentageDiscount) {
        this.percentageDiscount = percentageDiscount;
    }
}
