package model;

public class Product {
    private final Integer reference;
    private final String wording;
    private final Double unitPrice;
    private final Integer stockQuantity;
    private final String description;
    private final String vat;

    public Product(int reference, String wording, double unitPrice, int stockQuantity, String description, String vat) {
        this.reference = reference;
        this.wording = wording;
        this.unitPrice = unitPrice;
        this.stockQuantity = stockQuantity;
        this.description = description;
        this.vat = vat;
    }

    public Integer getReference() {
        return reference;
    }

    public String getWording() {
        return wording;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public String getDescription() {
        return description;
    }

    public String getVat() {
        return vat;
    }
}
