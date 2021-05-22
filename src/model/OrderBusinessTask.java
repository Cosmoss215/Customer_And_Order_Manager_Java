package model;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class OrderBusinessTask {
    private Integer OrderNumber;
    private GregorianCalendar creationDate;
    private GregorianCalendar paymentDeadline;
    private String orderState;
    private Integer customerId;
    private String customerName;
    private ArrayList<OrderLineBusinessTask> ordersLines;

    public OrderBusinessTask(Integer orderNumber, GregorianCalendar creationDate, GregorianCalendar paymentDeadline, String orderState, Integer customerId, String customerName, ArrayList<OrderLineBusinessTask> ordersLines) {
        OrderNumber = orderNumber;
        this.creationDate = creationDate;
        this.paymentDeadline = paymentDeadline;
        this.orderState = orderState;
        this.customerId = customerId;
        this.customerName = customerName;
        this.ordersLines = ordersLines;
    }

    public GregorianCalendar getCreationDate() {
        return creationDate;
    }

    public GregorianCalendar getPaymentDeadline() {
        return paymentDeadline;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public Integer getOrderNumber() {
        return OrderNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getOrderState() {
        return orderState;
    }
}
