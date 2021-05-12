package model;

import exception.OrderStateException;

import java.time.LocalDate;
import java.util.GregorianCalendar;

public class Order {
    private Integer number;
    private GregorianCalendar creationDate;
    private GregorianCalendar PaymentDeadline;
    private String state;
    private Customer customer;
    private PaymentMethod paymentMethod;
    public static final String [] states = { "pending", "payed", "delivered" };
    public static final int STATES_NUMBER = 3;

    //region Constructors
    /** Full constructor
    */
    public Order(Integer number, GregorianCalendar creationDate, GregorianCalendar paymentDeadline, String state, Customer customer, PaymentMethod paymentMethod) {
        setNumber(number);
        setCreationDate(creationDate);
        setPaymentDeadline(paymentDeadline);
        setState(state);
        this.customer = customer;
        this.paymentMethod = paymentMethod;
    }
    //region overload constructor
     /**  SQL DB constructor (auto_incremented ID)
     * Use this constructor if you want to create an order that already exists (FROM VIEW) to put in the DB (which will create a proper ID)
     * */
    public Order(GregorianCalendar creationDate, GregorianCalendar paymentDeadline, String state, Customer customer, PaymentMethod paymentMethod) {
        this(null, creationDate, paymentDeadline, state, customer, paymentMethod);
    }
    /** Light constructor
    * It will let DB set the ID, the default creation date will be set to today() and the default state will be set to "pending"
    */
    public Order(GregorianCalendar paymentDeadline, Customer customer, PaymentMethod paymentMethod) {
        this(null, null, paymentDeadline, "pending", customer, paymentMethod);
        setState();
        setCreationDate();
    }
    //endregion
    //endregion
    //region getter
    public Integer getNumber() {
        return number;
    }

    public GregorianCalendar getCreationDate() {
        return creationDate;
    }

    public GregorianCalendar getPaymentDeadline() {
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
    //endregion
    //region setter
    private void setNumber(Integer number) {
        if(number > 0){
            this.number = number;
        }
    }
    private void setCreationDate(GregorianCalendar creationDate) {
        this.creationDate = creationDate;
    }
    private void setCreationDate(){
        LocalDate today = LocalDate.now();
        GregorianCalendar creationDate = new GregorianCalendar(today.getYear(), today.getMonthValue() - 1, today.getDayOfMonth());
        setCreationDate(creationDate);
    }
    private void setPaymentDeadline(GregorianCalendar paymentDeadline) {
        PaymentDeadline = paymentDeadline;
    }
    private void setState(String state) { // throws OrderStateException ?

        if(state.equals(states[0]) || state.equals(states[1]) || state.equals(states[2])){
            this.state = state;
        }
        else {
            this.state = states[0];
        }
    }
    private void setState(){
        setState("pending");
    }
   //endregion
}
