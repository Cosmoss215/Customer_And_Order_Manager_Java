package model;

import java.time.LocalDate;

public class Order {
    private final Integer number;
    private final LocalDate creationDate;
    private final LocalDate PaymentDeadline;
    private final String State;
    private final Customer customer;
    private final PaymentMethod paymentMethod;

    public Order(int number, LocalDate creationDate, LocalDate paymentDeadline, String state, Customer customer, PaymentMethod paymentMethod) {
        this.number = number;
        this.creationDate = creationDate;
        PaymentDeadline = paymentDeadline;
        State = state;
        this.customer = customer;
        this.paymentMethod = paymentMethod;
    }

}
