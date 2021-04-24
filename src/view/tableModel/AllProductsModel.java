package view.tableModel;

import model.Product;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class AllProductsModel extends AbstractTableModel {
    private ArrayList<String> columnNames;
    private ArrayList<Product> contents;

    public AllProductsModel(ArrayList<Product> products)
    {
        contents = products;
        columnNames = new ArrayList<>();
        columnNames.add("Reference");
        columnNames.add("Wording");
        columnNames.add("Unit price");
        columnNames.add("Stock quantity");
        columnNames.add("Description");
        columnNames.add("VAT");
    }

    @Override
    public int getRowCount() {
        return contents.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Product product = contents.get(rowIndex);
        switch(columnIndex)
        { case 0 : return product.getReference();
            case 1 : return product.getWording();
            case 2: return product.getUnitPrice();
            case 3: return product.getStockQuantity();
            case 4: return product.getDescription();
            case 5:return product.getVat();
            default : return null;
        }
    }
    public String getColumnName(int column) { return columnNames.get(column); }

    public Class getColumnClass (int column)
    { Class c;
        switch (column)
        { case 0: c = Integer.class;
            break;
            case 1: c = String.class;
                break;
            case 2: c = Double.class;
                break;
            case 3: c = Integer.class;
                break;
            case 4: c = String.class;
                break;
            case 5: c = String.class;
                break;
            default: c = String.class;
        }
        return c;
    }

}
