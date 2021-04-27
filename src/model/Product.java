package model;

public class Product {
    private Integer reference;
    private String wording;
    private Double unitPrice;
    private Integer stockQuantity;
    private String description;
    private VAT vat;

    public Product(Integer reference, String wording, Double unitPrice, Integer stockQuantity, String description, VAT vat) {
        setReference(reference);
        setWording(wording);
        setUnitPrice(unitPrice);
        setStockQuantity(stockQuantity);
        setDescription(description);
        setVat(vat);
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

    public VAT getVat() {
        return vat;
    }

    private void setReference(Integer reference) {
        this.reference = reference;
    }

    private void setWording(String wording) {
        this.wording = wording;
    }

    private void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    private void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    public void setVat(VAT vat) {
        this.vat = vat;
    }
}
