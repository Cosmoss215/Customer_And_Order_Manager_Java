package view;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerList extends JFrame {
    private final JButton jButtonCreateCustomer;
    private final JButton jButtonDeleteCustomer;
    private final JButton jButtonReadCustomer;
    private final JButton jButtonSearch;
    private final JButton jButtonUpdateCustomer;
    private final JLabel jLabelCustomerList;
    private final JPanel jPanelButton;
    private final JPanel jPanelCustomerTable;
    private final JPanel jPanelSearch;
    private final JScrollPane jScrollPane1;
    private final JTable jTable1;
    private final JTextField jTextFieldSearchBar;

    public CustomerList(){
        jPanelSearch = new JPanel();
        jButtonSearch = new JButton();
        jLabelCustomerList = new JLabel();
        jTextFieldSearchBar = new JTextField();
        jPanelCustomerTable = new JPanel();
        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();
        jPanelButton = new JPanel();
        jButtonCreateCustomer = new JButton();
        jButtonReadCustomer = new JButton();
        jButtonUpdateCustomer = new JButton();
        jButtonDeleteCustomer = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        jButtonSearch.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        jButtonSearch.setText("Search");

        jLabelCustomerList.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        jLabelCustomerList.setText("Customer list");

        jTextFieldSearchBar.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        jTextFieldSearchBar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //jTextFieldSearchBarActionPerformed(evt);
            }
        });

        GroupLayout jPanelSearchLayout = new GroupLayout(jPanelSearch);
        jPanelSearch.setLayout(jPanelSearchLayout);
        jPanelSearchLayout.setHorizontalGroup(
                jPanelSearchLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanelSearchLayout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelCustomerList)
                                .addGap(421, 421, 421)
                                .addComponent(jTextFieldSearchBar, GroupLayout.PREFERRED_SIZE, 421, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonSearch)
                                .addGap(31, 31, 31))
        );
        jPanelSearchLayout.setVerticalGroup(
                jPanelSearchLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelSearchLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(jPanelSearchLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelCustomerList)
                                        .addComponent(jTextFieldSearchBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButtonSearch))
                                .addContainerGap(31, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
            final Class[] types = new Class [] {
                    java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Boolean.class
            };
            final boolean[] canEdit = new boolean [] {
                    false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        GroupLayout jPanelCustomerTableLayout = new GroupLayout(jPanelCustomerTable);
        jPanelCustomerTable.setLayout(jPanelCustomerTableLayout);
        jPanelCustomerTableLayout.setHorizontalGroup(
                jPanelCustomerTableLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelCustomerTableLayout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 1069, Short.MAX_VALUE)
                                .addGap(16, 16, 16))
        );
        jPanelCustomerTableLayout.setVerticalGroup(
                jPanelCustomerTableLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanelCustomerTableLayout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 473, GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60))
        );

        jButtonCreateCustomer.setBackground(new Color(0, 204, 0));
        jButtonCreateCustomer.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        jButtonCreateCustomer.setText("Create customer");

        jButtonReadCustomer.setBackground(new Color(204, 255, 102));
        jButtonReadCustomer.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        jButtonReadCustomer.setText("Read customer");

        jButtonUpdateCustomer.setBackground(new Color(0, 153, 153));
        jButtonUpdateCustomer.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        jButtonUpdateCustomer.setText("Update customer");

        jButtonDeleteCustomer.setBackground(new Color(255, 102, 102));
        jButtonDeleteCustomer.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        jButtonDeleteCustomer.setText("Delete customer");

        GroupLayout jPanelButtonLayout = new GroupLayout(jPanelButton);
        jPanelButton.setLayout(jPanelButtonLayout);
        jPanelButtonLayout.setHorizontalGroup(
                jPanelButtonLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanelButtonLayout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonCreateCustomer)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonReadCustomer)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonUpdateCustomer)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonDeleteCustomer)
                                .addGap(201, 201, 201))
        );
        jPanelButtonLayout.setVerticalGroup(
                jPanelButtonLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelButtonLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanelButtonLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButtonCreateCustomer)
                                        .addComponent(jButtonReadCustomer)
                                        .addComponent(jButtonUpdateCustomer)
                                        .addComponent(jButtonDeleteCustomer))
                                .addContainerGap(25, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanelSearch, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanelCustomerTable, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanelButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanelSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanelCustomerTable, GroupLayout.PREFERRED_SIZE, 495, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanelButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pack();
    }
}
