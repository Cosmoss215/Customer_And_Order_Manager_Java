package view.tableModel;

import model.Customer;
import javax.swing.table.AbstractTableModel;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import util.*;

public class AllCustomersModel extends AbstractTableModel {
    private ArrayList<String> columnNames;
    private ArrayList<Customer> content;

    public AllCustomersModel(ArrayList<Customer> customers) {
        content = customers;
        columnNames = new ArrayList<>();
        columnNames.add("Id");
        columnNames.add("Full Name");
        columnNames.add("Nickname");
        columnNames.add("Registration date");
        columnNames.add("Address");
        columnNames.add("Country");
        columnNames.add("Phone number");
        columnNames.add("Email");
        columnNames.add("VAT number");
        columnNames.add("IBAN");
        columnNames.add("BIC");
        columnNames.add("isVIP");
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
            case 0 : return customers.getId();
            case 1 : return customers.getFirstName()+" "+customers.getLastName();
            case 2 : return customers.getNickname();
            case 3 : return DateFormater.toString(customers.getRegistrationDate());
            case 4 : return customers.getAddress();
            case 5 : return customers.getAddress().getLocality().getCountry();
            case 6 : return customers.getPhoneNumber();
            case 7 : return customers.getEmail();
            case 8 : return customers.getVatNumber();
            case 9 : return customers.getIban();
            case 10 : return customers.getBic();
            case 11: return customers.getVip();
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
            case 1: c = String.class;
                break;
            case 2: c = String.class;
                break;
            case 3: c = GregorianCalendar.class;
                break;
            case 4: c = String.class;
                break;
            case 5: c = String.class;
                break;
            case 6: c = Integer.class;
                break;
            case 7: c = String.class;
                break;
            case 8: c = Integer.class;
                break;
            case 9: c = String.class;
                break;
            case 10: c = String.class;
                break;
            case 11: c = Boolean.class;
                break;

            default: c = String.class;
        }
        return c;
    }
    public Customer getRow(int indexRow){
        return content.get(indexRow);
    }

}