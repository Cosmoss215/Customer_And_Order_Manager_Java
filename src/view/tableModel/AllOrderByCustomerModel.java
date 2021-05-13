package view.tableModel;

import model.Customer;
import model.OrderByCustomer;
import model.PaymentMethod;

import javax.swing.table.AbstractTableModel;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

public class AllOrderByCustomerModel extends AbstractTableModel {
    private ArrayList<String> columnNames;
    private ArrayList<OrderByCustomer> content;

    public AllOrderByCustomerModel(ArrayList<OrderByCustomer> customers) {
        content = customers;
        columnNames = new ArrayList<>();
        columnNames.add("Order number");
        columnNames.add("Date Order");
        columnNames.add("Total price");
        columnNames.add("Payment method");
        columnNames.add("Payment deadline");
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
            case 1 : return orderByCustomer.getCreationDate();
            case 2 : return orderByCustomer.getPrice();
            case 3 : return orderByCustomer.getPaymentMethod();
            case 4 : return orderByCustomer.getPaymentDeadline();
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
            case 1: c = LocalDate.class;
                break;
            case 2: c = Integer.class;
                break;
            case 3: c = String.class;
                break;
            case 4: c = LocalDate.class;
                break;
            default: c = String.class;
        }
        return c;
    }
}
