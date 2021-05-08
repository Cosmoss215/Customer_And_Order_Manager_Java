package view.tableModel;

import model.CustomerByProduct;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class AllCustomersByProductModel extends AbstractTableModel {
    private ArrayList<String> columnNames;
    private ArrayList<CustomerByProduct> content;

    public AllCustomersByProductModel(ArrayList<CustomerByProduct> customers) {
        content = customers;
        columnNames = new ArrayList<>();
        columnNames.add("Customer name");
        columnNames.add("Quantity");
        columnNames.add("Payment Method");
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
        CustomerByProduct customerByProduct = content.get(rowIndex);
        switch(columnIndex) {
            case 0 : return customerByProduct.getFirstName()+" "+customerByProduct.getLastName();
            case 1 : return customerByProduct.getQuantity();
            case 2 : return customerByProduct.getWordingPaymentMethod();
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
            case 0: c = String.class;
                break;
            case 1: c = Integer.class;
                break;
            case 2: c = String.class;
                break;
            default: c = String.class;
        }
        return c;
    }
}