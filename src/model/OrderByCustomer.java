package model;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class OrderByCustomer {
    private Integer number;
    private GregorianCalendar creationDate;
    private GregorianCalendar paymentDeadline;
    private Double price;
    private Customer customer;
    private String paymentMethod;

    public OrderByCustomer(Integer number, GregorianCalendar creationDate, GregorianCalendar paymentDeadline, Double price, Customer customer, String paymentMethod) {
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

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public String displayCreationDate(){
        return creationDate.get(Calendar.DAY_OF_MONTH) + "/" + ((creationDate.get(Calendar.MONTH) + 1)<10?"0":"") + (creationDate.get(Calendar.MONTH) + 1) + "/" + creationDate.get(Calendar.YEAR);
    }

    public String displayPaymentDeadline(){
        return paymentDeadline.get(Calendar.DAY_OF_MONTH) + "/" + ((paymentDeadline.get(Calendar.MONTH) + 1)<10?"0":"") + (paymentDeadline.get(Calendar.MONTH) + 1) + "/" + paymentDeadline.get(Calendar.YEAR);
    }
    @Override
    public String toString() {
        return "OrderByCustomer{" +
                "number=" + number +
                ", creationDate=" + creationDate +
                ", paymentDeadline=" + paymentDeadline +
                ", price=" + price +
                ", customer=" + customer +
                ", paymentMethod=" + paymentMethod +
                '}';
    }
}
