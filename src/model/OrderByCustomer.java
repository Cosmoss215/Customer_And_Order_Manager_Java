package model;

import java.util.GregorianCalendar;

public class OrderByCustomer {
    private Integer number;
    private GregorianCalendar creationDate;
    private GregorianCalendar paymentDeadline;
    private Double price;
    private Customer customer;
    private PaymentMethod paymentMethod;

    public OrderByCustomer(Integer number, GregorianCalendar creationDate, GregorianCalendar paymentDeadline, Double price, Customer customer, PaymentMethod paymentMethod) {
        this.number = number;
        this.creationDate = creationDate;
        this.paymentDeadline = paymentDeadline;
        this.price = price;
        this.customer = customer;
        this.paymentMethod = paymentMethod;
    }

    public Integer getNumber() {
        return number;
    }

    public GregorianCalendar getCreationDate() {
        return creationDate;
    }

    public GregorianCalendar getPaymentDeadline() {
        return paymentDeadline;
    }

    public Double getPrice() {
        return price;
    }

    public Customer getCustomer() {
        return customer;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

}
