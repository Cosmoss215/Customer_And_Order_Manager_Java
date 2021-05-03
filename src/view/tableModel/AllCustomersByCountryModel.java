package view.tableModel;

import model.Customer;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class AllCustomersByCountryModel extends AbstractTableModel {
    private ArrayList<String> columnNames;
    private ArrayList<Customer> content;

    public AllCustomersByCountryModel(ArrayList<Customer> customers) {
        content = customers;
        columnNames = new ArrayList<>();
        columnNames.add("Customer name");
        columnNames.add("Address");
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
        Customer customers = content.get(rowIndex);
        switch(columnIndex) {
            case 0 : return customers.getFirstName()+" "+customers.getLastName();
            case 1 : return customers.getAddress();
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
            case 1: c = String.class;
                break;
            default: c = String.class;
        }
        return c;
    }
}