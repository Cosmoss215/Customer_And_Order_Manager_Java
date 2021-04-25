package view;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerList extends JFrame {
    private javax.swing.JButton jButtonCreateCustomer;
    private javax.swing.JButton jButtonDeleteCustomer;
    private javax.swing.JButton jButtonReadCustomer;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JButton jButtonUpdateCustomer;
    private javax.swing.JLabel jLabelCustomerName;
    private javax.swing.JLabel jLabelNickname;
    private javax.swing.JScrollPane jScrollCustomerTable;
    private javax.swing.JTable jTableCustomerList;
    private javax.swing.JTextField jTextFieldSearchBar;
    private javax.swing.JTextField jTextFieldSearchBar1;
    private javax.swing.JPanel panelButtonCRUD;
    private javax.swing.JPanel panelCustomerTable;
    private javax.swing.JPanel panelSearchBar;

    public CustomerList(){
        panelSearchBar = new javax.swing.JPanel();
        jButtonSearch = new javax.swing.JButton();
        jTextFieldSearchBar = new javax.swing.JTextField();
        jLabelCustomerName = new javax.swing.JLabel();
        jLabelNickname = new javax.swing.JLabel();
        jTextFieldSearchBar1 = new javax.swing.JTextField();
        panelCustomerTable = new javax.swing.JPanel();
        jScrollCustomerTable = new javax.swing.JScrollPane();
        jTableCustomerList = new javax.swing.JTable();
        panelButtonCRUD = new javax.swing.JPanel();
        jButtonCreateCustomer = new javax.swing.JButton();
        jButtonReadCustomer = new javax.swing.JButton();
        jButtonUpdateCustomer = new javax.swing.JButton();
        jButtonDeleteCustomer = new javax.swing.JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        jButtonSearch.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonSearch.setText("Search");

        jTextFieldSearchBar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextFieldSearchBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //jTextFieldSearchBarActionPerformed(evt);
            }
        });

        jLabelCustomerName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelCustomerName.setText("Customer name");

        jLabelNickname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelNickname.setText("Nickname");

        jTextFieldSearchBar1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextFieldSearchBar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //jTextFieldSearchBar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelSearchBarLayout = new javax.swing.GroupLayout(panelSearchBar);
        panelSearchBar.setLayout(panelSearchBarLayout);
        panelSearchBarLayout.setHorizontalGroup(
                panelSearchBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSearchBarLayout.createSequentialGroup()
                                .addGap(142, 142, 142)
                                .addComponent(jLabelCustomerName)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldSearchBar, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelNickname)
                                .addGap(32, 32, 32)
                                .addComponent(jTextFieldSearchBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonSearch)
                                .addGap(26, 26, 26))
        );
        panelSearchBarLayout.setVerticalGroup(
                panelSearchBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelSearchBarLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(panelSearchBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextFieldSearchBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButtonSearch)
                                        .addComponent(jLabelCustomerName)
                                        .addComponent(jLabelNickname)
                                        .addComponent(jTextFieldSearchBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(31, Short.MAX_VALUE))
        );

        //Expemple de comment productList à été fait
        //ApplicationController allProducts = new ApplicationController();
        //
        //        ArrayList<Product> all = allProducts.getAllProducts();
        //
        //        AllProductsModel productsModel = new AllProductsModel(all);
        //
        //
        //        jTable1 = new JTable(productsModel);
        //
        //        jScrollPane1 = new JScrollPane(jTable1);















        /*
        jTableCustomerList.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null, null}
                },
                new String [] {
                        "Id", "Customer", "Registration date", "Address", "Phone number", "Email", "VAT number", "IBAN", "BIC", "Is VIP"
                }
        ) {
            Class[] types = new Class [] {
                    java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                    false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        */
        jTableCustomerList.getTableHeader().setReorderingAllowed(false);
        jScrollCustomerTable.setViewportView(jTableCustomerList);

        javax.swing.GroupLayout panelCustomerTableLayout = new javax.swing.GroupLayout(panelCustomerTable);
        panelCustomerTable.setLayout(panelCustomerTableLayout);
        panelCustomerTableLayout.setHorizontalGroup(
                panelCustomerTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelCustomerTableLayout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jScrollCustomerTable, javax.swing.GroupLayout.DEFAULT_SIZE, 1219, Short.MAX_VALUE)
                                .addGap(16, 16, 16))
        );
        panelCustomerTableLayout.setVerticalGroup(
                panelCustomerTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCustomerTableLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollCustomerTable, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60))
        );

        jButtonCreateCustomer.setBackground(new java.awt.Color(0, 204, 0));
        jButtonCreateCustomer.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonCreateCustomer.setText("Create customer");

        jButtonReadCustomer.setBackground(new java.awt.Color(204, 255, 102));
        jButtonReadCustomer.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonReadCustomer.setText("Read customer");

        jButtonUpdateCustomer.setBackground(new java.awt.Color(0, 153, 153));
        jButtonUpdateCustomer.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonUpdateCustomer.setText("Update customer");

        jButtonDeleteCustomer.setBackground(new java.awt.Color(255, 102, 102));
        jButtonDeleteCustomer.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonDeleteCustomer.setText("Delete customer");

        javax.swing.GroupLayout panelButtonCRUDLayout = new javax.swing.GroupLayout(panelButtonCRUD);
        panelButtonCRUD.setLayout(panelButtonCRUDLayout);
        panelButtonCRUDLayout.setHorizontalGroup(
                panelButtonCRUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelButtonCRUDLayout.createSequentialGroup()
                                .addGap(271, 271, 271)
                                .addComponent(jButtonCreateCustomer)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonReadCustomer)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonUpdateCustomer)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonDeleteCustomer)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelButtonCRUDLayout.setVerticalGroup(
                panelButtonCRUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelButtonCRUDLayout.createSequentialGroup()
                                .addGroup(panelButtonCRUDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButtonCreateCustomer)
                                        .addComponent(jButtonReadCustomer)
                                        .addComponent(jButtonUpdateCustomer)
                                        .addComponent(jButtonDeleteCustomer))
                                .addGap(0, 26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelSearchBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelCustomerTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelButtonCRUD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(panelSearchBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panelCustomerTable, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panelButtonCRUD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }
}
