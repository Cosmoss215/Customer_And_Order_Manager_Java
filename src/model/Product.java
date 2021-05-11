package model;

public class Product {
    private Integer reference;
    private String wording;
    private Double unitPrice;
    private Integer stockQuantity;
    private String description;
    private VAT vat;

    public Product(Integer reference, String wording, Double unitPrice, Integer stockQuantity, String description, VAT vat) {
        this.reference = reference;
        this.wording = wording;
        setUnitPrice(unitPrice);
        setStockQuantity(stockQuantity);
        this.description = description;
        this.vat = vat;
    }
    //region getter
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
    //endregion
    //region setter
    private void setUnitPrice(Double unitPrice) {
        //>= 0 car un produit pourrai être un échantillions gratuit
        if (unitPrice >= 0){
            this.unitPrice = unitPrice;
        }
    }
    private void setStockQuantity(Integer stockQuantity) {
        if (stockQuantity >= 0) {
            this.stockQuantity = stockQuantity;
        }
    }
    //endregion
}
