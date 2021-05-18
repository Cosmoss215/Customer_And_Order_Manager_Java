package view.tableModel;

import model.Customer;
import model.OrderByCustomer;
import model.PaymentMethod;
import util.DateFormater;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class AllOrdersByCustomerModel extends AbstractTableModel {
    private ArrayList<String> columnNames;
    private ArrayList<OrderByCustomer> content;

    public AllOrdersByCustomerModel(ArrayList<OrderByCustomer> orders) {
        content = orders;
        columnNames = new ArrayList<>();
        columnNames.add("Order number");
        columnNames.add("Creation Date");
        columnNames.add("Payment deadline");
        columnNames.add("Total price");
        columnNames.add("Payment method");
    }

    @Override
    public int getRowCount() {
        return content.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        OrderByCustomer orderByCustomer = content.get(rowIndex);
        switch(columnIndex) {
            case 0 : return orderByCustomer.getNumber();
            case 1 : return DateFormater.toString(orderByCustomer.getCreationDate());
            case 2 : return DateFormater.toString(orderByCustomer.getPaymentDeadline());
            case 3 : return "€ " + orderByCustomer.getPrice();
            case 4 : return orderByCustomer.getPaymentMethod();
            default : return null;
        }
    }

    public String getColumnName(int column) {
        return columnNames.get(column);
    }

    public Class getColumnClass (int column) {
        Class c;
        switch (column)
        {
            case 0: c = Integer.class;
                break;
            case 1:
            case 2:
            case 3:
            case 4: c = String.class;
                break;
            default: c = String.class;
        }
        return c;
    }
}
