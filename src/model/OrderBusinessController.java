package model;

import exception.OrderBusinessControllerException;

public class OrderBusinessController {
    private Double unitPrice;
    private Integer quantity;
    private Double percentageDiscount;
    private boolean hasDiscount;
    private Double totalPrice;

    public OrderBusinessController(Double unitPrice, Integer quantity, Double percentageDiscount, boolean hasDiscount, Double totalPrice) {
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.percentageDiscount = percentageDiscount;
        this.hasDiscount = hasDiscount;
        this.totalPrice = totalPrice;
    }

    public double price() throws OrderBusinessControllerException {
        if (quantity < 0) {
            throw new OrderBusinessControllerException("Quantity is inferior to 0");
        }
        if (percentageDiscount < 0) {
            throw new OrderBusinessControllerException("Percentage discount is inferior to 0");
        }

        Double price = (unitPrice * quantity);
        if (percentageDiscount == 0) {
            return price;
        }

        return price - (price * percentageDiscount);
    }

    public boolean hasDiscount() {
        return hasDiscount && percentageDiscount > 0;
    }

    public double getPourcatageAmount() throws OrderBusinessControllerException {
        if (percentageDiscount < 0) {
            throw new OrderBusinessControllerException("Percentage discount is inferior to 0");
        }
        return (unitPrice*quantity) * percentageDiscount;
    }
}
