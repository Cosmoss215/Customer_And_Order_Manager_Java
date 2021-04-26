package view;

import controller.ApplicationController;
import exception.ConnectionException;
import exception.SelectQueryException;
import model.Product;
import view.tableModel.AllProductsModel;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

import java.util.ArrayList;

public class ProductList extends JFrame {
    private JButton jButtonSearch;
    private JLabel jLabelProductList;
    private JScrollPane jScrollPane1;
    private JTable jTable1;
    private JTextField jTextFieldSearch;
    private JPanel panelAllProducts;
    private JPanel panelSearchBar;

    public ProductList() throws ConnectionException, SelectQueryException {
        panelSearchBar = new JPanel();
        jTextFieldSearch = new JTextField();
        jLabelProductList = new JLabel();
        jButtonSearch = new JButton();
        panelAllProducts = new JPanel();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        jTextFieldSearch.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabelProductList.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelProductList.setText("Product list");

        jButtonSearch.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonSearch.setText("Search");

        GroupLayout panelSearchBarLayout = new GroupLayout(panelSearchBar);
        panelSearchBar.setLayout(panelSearchBarLayout);
        panelSearchBarLayout.setHorizontalGroup(
                panelSearchBarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, panelSearchBarLayout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(jLabelProductList)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldSearch)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonSearch)
                                .addGap(32, 32, 32))
        );
        panelSearchBarLayout.setVerticalGroup(
                panelSearchBarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelSearchBarLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(panelSearchBarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextFieldSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButtonSearch)
                                        .addComponent(jLabelProductList))
                                .addContainerGap(34, Short.MAX_VALUE))
        );

        // Création des colonnes d'affichage
        ApplicationController allProducts = new ApplicationController();

        ArrayList<Product> all = allProducts.getAllProducts();

        AllProductsModel productsModel = new AllProductsModel(all);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        jTable1 = new JTable(productsModel);
        jTable1.setAutoCreateRowSorter(true);
        jTable1.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        jTable1.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        jTable1.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        jTable1.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
        jTable1.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
        jScrollPane1 = new JScrollPane(jTable1);


        jScrollPane1.setViewportView(jTable1);
        //-------------------------------------------------------------------------------------



        GroupLayout panelAllProductsLayout = new GroupLayout(panelAllProducts);
        panelAllProducts.setLayout(panelAllProductsLayout);
        panelAllProductsLayout.setHorizontalGroup(
                panelAllProductsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelAllProductsLayout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 1185, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(30, Short.MAX_VALUE))
        );
        panelAllProductsLayout.setVerticalGroup(
                panelAllProductsLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelAllProductsLayout.createSequentialGroup()
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 523, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 32, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(panelSearchBar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelAllProducts, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(panelSearchBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(panelAllProducts, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }
}
