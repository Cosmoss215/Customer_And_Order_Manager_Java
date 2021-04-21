package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchOrderListing extends JFrame {

    private javax.swing.JFormattedTextField jFormattedTextFieldDateEnd;
    private javax.swing.JFormattedTextField jFormattedTextFieldStartDate;
    private javax.swing.JLabel jLabelCustomerAddress;
    private javax.swing.JLabel jLabelCustomerName;
    private javax.swing.JLabel jLabelFrom;
    private javax.swing.JLabel jLabelTo;
    private javax.swing.JScrollPane jScrollTableOrderList;
    private javax.swing.JTable jTableOrderList;
    private javax.swing.JTextField jTextFieldSearchBar;
    private javax.swing.JPanel panelSearchBar;
    private javax.swing.JPanel panelTableOrderList;

    public SearchOrderListing(){
        panelSearchBar = new javax.swing.JPanel();
        jLabelCustomerName = new javax.swing.JLabel();
        jLabelCustomerAddress = new javax.swing.JLabel();
        jTextFieldSearchBar = new javax.swing.JTextField();
        jFormattedTextFieldStartDate = new javax.swing.JFormattedTextField();
        jLabelFrom = new javax.swing.JLabel();
        jFormattedTextFieldDateEnd = new javax.swing.JFormattedTextField();
        jLabelTo = new javax.swing.JLabel();
        panelTableOrderList = new javax.swing.JPanel();
        jScrollTableOrderList = new javax.swing.JScrollPane();
        jTableOrderList = new javax.swing.JTable();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        jLabelCustomerName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelCustomerName.setText("Customer's name");

        jLabelCustomerAddress.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabelCustomerAddress.setText("Address");

        jTextFieldSearchBar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTextFieldSearchBar.setText("Find order with customer's name");
        jTextFieldSearchBar.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextFieldSearchBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //jTextFieldSearchBarActionPerformed(evt);
            }
        });

        jFormattedTextFieldStartDate.setText("DD/MM/YYY");
        jFormattedTextFieldStartDate.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jFormattedTextFieldStartDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //jFormattedTextFieldStartDateActionPerformed(evt);
            }
        });

        jLabelFrom.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabelFrom.setText("From");

        jFormattedTextFieldDateEnd.setText("DD/MM/YYY");
        jFormattedTextFieldDateEnd.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jFormattedTextFieldDateEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //jFormattedTextFieldDateEndActionPerformed(evt);
            }
        });

        jLabelTo.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabelTo.setText("to");

        javax.swing.GroupLayout panelSearchBarLayout = new javax.swing.GroupLayout(panelSearchBar);
        panelSearchBar.setLayout(panelSearchBarLayout);
        panelSearchBarLayout.setHorizontalGroup(
                panelSearchBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelSearchBarLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabelCustomerName)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelCustomerAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextFieldSearchBar, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelFrom)
                                .addGap(18, 18, 18)
                                .addComponent(jFormattedTextFieldStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelTo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jFormattedTextFieldDateEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(169, 169, 169))
        );
        panelSearchBarLayout.setVerticalGroup(
                panelSearchBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelSearchBarLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panelSearchBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelSearchBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabelTo)
                                                .addComponent(jFormattedTextFieldDateEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jFormattedTextFieldStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabelFrom)
                                                .addComponent(jTextFieldSearchBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSearchBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabelCustomerAddress)
                                                .addComponent(jLabelCustomerName)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelTableOrderListLayout = new javax.swing.GroupLayout(panelTableOrderList);
        panelTableOrderList.setLayout(panelTableOrderListLayout);
        panelTableOrderListLayout.setHorizontalGroup(
                panelTableOrderListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 1222, Short.MAX_VALUE)
        );
        panelTableOrderListLayout.setVerticalGroup(
                panelTableOrderListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 572, Short.MAX_VALUE)
        );

        jTableOrderList.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null}
                },
                new String [] {
                        "Order number", "Date order", "Price", "Payment method", "Payment deadline"
                }
        ) {
            Class[] types = new Class [] {
                    java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                    false, false, true, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollTableOrderList.setViewportView(jTableOrderList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(panelSearchBar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jScrollTableOrderList, javax.swing.GroupLayout.PREFERRED_SIZE, 1207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(19, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(panelTableOrderList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(18, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(panelSearchBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollTableOrderList, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(21, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addContainerGap(67, Short.MAX_VALUE)
                                        .addComponent(panelTableOrderList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap()))
        );

        pack();
    }
}
