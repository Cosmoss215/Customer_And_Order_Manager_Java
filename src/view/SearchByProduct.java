package view;

import controller.ApplicationController;
import exception.ConnectionException;
import exception.NullException;
import exception.SelectQueryException;
import model.CustomerByProduct;
import model.Product;
import view.tableModel.AllCustomersByProductModel;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SearchByProduct extends JFrame {
    private final JLabel jLabelProduct;
    private final JScrollPane jScrollPane1;
    private final JTable jTableCustomersByProduct;
    private final JComboBox<String> jTextFieldFindProduct;
    private final JPanel panelSearchBar;
    private final JPanel panelTableByProduct;
    private ArrayList<Product> products;


    public SearchByProduct() throws SelectQueryException, ConnectionException, NullException {
        super("Search by product");
        this.setResizable(false);
        panelSearchBar = new JPanel();
        jLabelProduct = new JLabel();
        panelTableByProduct = new JPanel();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        jLabelProduct.setFont(new Font("Tahoma", 0, 18));
        jLabelProduct.setText("Product");

        ApplicationController getProductByWording = new ApplicationController();
        products = getProductByWording.getAllProducts();

        int i = 0;
        String [] pattern = new String[products.size()];
        for (Product p : products){
            pattern[i] = p.getWording();
            i++;
        }

        jTextFieldFindProduct = new JComboBox<>(pattern);
        jTextFieldFindProduct.setFont(new Font("Tahoma", 0, 16));

        ArrayList<CustomerByProduct> customersByProduct = getProductByWording.getProductByWording(jTextFieldFindProduct.getSelectedItem().toString());
        AllCustomersByProductModel customersByProductModel = new AllCustomersByProductModel(customersByProduct);
        jTableCustomersByProduct = new JTable(customersByProductModel);
        jTableCustomersByProduct.setAutoCreateRowSorter(true);
        jScrollPane1 = new JScrollPane(jTableCustomersByProduct);
        jScrollPane1.setViewportView(jTableCustomersByProduct);

        jTextFieldFindProduct.addActionListener(evt -> {
            try {
                ApplicationController getProductByWording1 = new ApplicationController();
                ArrayList<CustomerByProduct> customersByProduct1;
                customersByProduct1 = getProductByWording1.getProductByWording(jTextFieldFindProduct.getSelectedItem().toString());
                AllCustomersByProductModel customersByProductModel1 = new AllCustomersByProductModel(customersByProduct1);
                jTableCustomersByProduct.setModel(customersByProductModel1);
            } catch (ConnectionException | SelectQueryException | NullException exception) {
                JOptionPane.showMessageDialog(null,exception.getMessage(), exception.getTypeError(), JOptionPane.WARNING_MESSAGE);
            }
        });

        WindowFormattingCode();

        pack();
    }
    private void WindowFormattingCode(){
        GroupLayout panelSearchBarLayout = new GroupLayout(panelSearchBar);
        panelSearchBar.setLayout(panelSearchBarLayout);
        panelSearchBarLayout.setHorizontalGroup(
                panelSearchBarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelSearchBarLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelProduct)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldFindProduct, GroupLayout.PREFERRED_SIZE, 444, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addContainerGap(31, Short.MAX_VALUE))
        );
        panelSearchBarLayout.setVerticalGroup(
                panelSearchBarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelSearchBarLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(panelSearchBarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelProduct)
                                        .addComponent(jTextFieldFindProduct, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GroupLayout panelTableByProductLayout = new GroupLayout(panelTableByProduct);
        panelTableByProduct.setLayout(panelTableByProductLayout);
        panelTableByProductLayout.setHorizontalGroup(
                panelTableByProductLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelTableByProductLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 629, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(21, Short.MAX_VALUE))
        );
        panelTableByProductLayout.setVerticalGroup(
                panelTableByProductLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelTableByProductLayout.createSequentialGroup()
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 563, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 21, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(panelSearchBar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(panelTableByProduct, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(panelSearchBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(590, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 66, Short.MAX_VALUE)
                                        .addComponent(panelTableByProduct, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        );

    }

}
