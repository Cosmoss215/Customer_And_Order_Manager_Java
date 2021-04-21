package model;

public class Product {
    private final Integer reference;
    private final String wording;
    private final Double unitPrice;
    private final Integer stockQuantity;
    private final String description;
    private final VAT vat;

    public Product(int reference, String wording, double unitPrice, int stockQuantity, String description, VAT vat) {
        this.reference = reference;
        this.wording = wording;
        this.unitPrice = unitPrice;
        this.stockQuantity = stockQuantity;
        this.description = description;
        this.vat = vat;
    }
}
