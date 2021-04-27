package model;

import exception.OrderStateException;

import java.time.LocalDate;

public class Order {
    private Integer number;
    private LocalDate creationDate;
    private LocalDate PaymentDeadline;
    private String state;
    private Customer customer;
    private PaymentMethod paymentMethod;
    public final static String [] states = { "pending", "payed", "delivered" };
    public final static Integer statesNumbers = 3; // this is the number of the different valid states values.

    // CONSTRUCTORS
    /* Full constructor
    Use this constructor to get an order from de DB
    */
    public Order(Integer number, LocalDate creationDate, LocalDate paymentDeadline, Integer stateNumber, Customer customer, PaymentMethod paymentMethod) {
        setNumber(number); // DB AUTO_INCREMENT !
        setCreationDate(creationDate);
        setPaymentDeadline(paymentDeadline);
        setState(stateNumber);
        setCustomer(customer);
        setPaymentMethod(paymentMethod);
    }
    /*  Without number (= DB id, default = AUTO_INCREMENT)
    Use this constructor if you want to create an order that already exists (FROM VIEW) to put in the DB (which will create a proper ID)
     */
    public Order(LocalDate creationDate, LocalDate paymentDeadline, Integer stateNumber, Customer customer, PaymentMethod paymentMethod) {
        this(null, creationDate, paymentDeadline, stateNumber, customer, paymentMethod);
    }
    /* Without number (= DB id, default = AUTO_INCREMENT), creationDate (default = today) and stateNumber (default = 0, corresponds to "pending")
    Use this constructor if you want to create a new order to put into the DB (which will create a proper ID)
    */
    public Order(LocalDate paymentDeadline, Customer customer, PaymentMethod paymentMethod) {
        this(null, null, paymentDeadline, 0, customer, paymentMethod);
        setState();
        setCreationDate();
    }
    // END CONSTRUCTORS

    public Integer getNumber() {
        return number;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public LocalDate getPaymentDeadline() {
        return PaymentDeadline;
    }

    public String getState() {
        return state;
    }

    public Customer getCustomer() {
        return customer;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    private void setNumber(Integer number) {
        this.number = number;
    }

    private void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }
    private void setCreationDate(){
        LocalDate today = LocalDate.now();
        setCreationDate(today);
    }

    private void setPaymentDeadline(LocalDate paymentDeadline) {
        PaymentDeadline = paymentDeadline;
    }

    private void setState(Integer stateNumber) { // throws OrderStateException ?
        switch(stateNumber){
            case 0 :
            case 1 :
            case 2 : this.state = Order.states[stateNumber]; break;
            default : this.state = Order.states[0]; break;
        }
    }
    private void setState(){
        setState(0);
    }

    private void setCustomer(Customer customer) {
        this.customer = customer;
    }

    private void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
