package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchOrderListing extends JFrame {

    private final JFormattedTextField jFormattedTextFieldDateEnd;
    private final JFormattedTextField jFormattedTextFieldStartDate;
    private final JLabel jLabelCustomerAddress;
    private final JLabel jLabelCustomerName;
    private final JLabel jLabelFrom;
    private final JLabel jLabelTo;
    private final JPanel jPanel1;
    private final JScrollPane jScrollPane1;
    private final JTable jTableOrderList;
    private final JTextField jTextFieldSearchBar;

    public SearchOrderListing(){
        jPanel1 = new JPanel();
        jLabelCustomerName = new JLabel();
        jScrollPane1 = new JScrollPane();
        jTableOrderList = new JTable();
        jLabelCustomerAddress = new JLabel();
        jTextFieldSearchBar = new JTextField();
        jFormattedTextFieldStartDate = new JFormattedTextField();
        jLabelFrom = new JLabel();
        jFormattedTextFieldDateEnd = new JFormattedTextField();
        jLabelTo = new JLabel();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        jLabelCustomerName.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        jLabelCustomerName.setText("Customer's name");

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
            final Class[] types = new Class [] {
                    java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class
            };
            final boolean[] canEdit = new boolean [] {
                    false, false, true, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableOrderList);

        jLabelCustomerAddress.setFont(new Font("Dialog", 0, 18)); // NOI18N
        jLabelCustomerAddress.setText("Address");

        jTextFieldSearchBar.setFont(new Font("Dialog", 0, 18)); // NOI18N
        jTextFieldSearchBar.setText("Find order with customer's name");
        jTextFieldSearchBar.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        jTextFieldSearchBar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //jTextFieldSearchBarActionPerformed(evt);
            }
        });

        jFormattedTextFieldStartDate.setText("DD/MM/YYY");
        jFormattedTextFieldStartDate.setFont(new Font("Dialog", 0, 18)); // NOI18N
        jFormattedTextFieldStartDate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //jFormattedTextFieldStartDateActionPerformed(evt);
            }
        });

        jLabelFrom.setFont(new Font("Dialog", 0, 18)); // NOI18N
        jLabelFrom.setText("From");

        jFormattedTextFieldDateEnd.setText("DD/MM/YYY");
        jFormattedTextFieldDateEnd.setFont(new Font("Dialog", 0, 18)); // NOI18N
        jFormattedTextFieldDateEnd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //jFormattedTextFieldDateEndActionPerformed(evt);
            }
        });

        jLabelTo.setFont(new Font("Dialog", 0, 18)); // NOI18N
        jLabelTo.setText("to");

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jScrollPane1)
                                                .addContainerGap())
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(jLabelCustomerName)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabelCustomerAddress, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jTextFieldSearchBar, GroupLayout.PREFERRED_SIZE, 422, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabelFrom)
                                                .addGap(34, 34, 34)
                                                .addComponent(jFormattedTextFieldStartDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(30, 30, 30)
                                                .addComponent(jLabelTo)
                                                .addGap(31, 31, 31)
                                                .addComponent(jFormattedTextFieldDateEnd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(112, 112, 112))))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabelTo)
                                                .addComponent(jFormattedTextFieldDateEnd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jFormattedTextFieldStartDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabelFrom)
                                                .addComponent(jTextFieldSearchBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabelCustomerAddress)
                                                .addComponent(jLabelCustomerName)))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 529, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(10, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }
}
