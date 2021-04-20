package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchByProduct extends JFrame {
    private final JButton jButton1;
    private final JLabel jLabelProduct;
    private final JPanel jPanelSearchByProduct;
    private final JScrollPane jScrollPane1;
    private final JTable jTable1;
    private final JTextField jTextFieldFindProduct;

    public SearchByProduct()
    {
        jPanelSearchByProduct = new JPanel();
        jLabelProduct = new JLabel();
        jTextFieldFindProduct = new JTextField();
        jButton1 = new JButton();
        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        jLabelProduct.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        jLabelProduct.setText("Product");

        jTextFieldFindProduct.setFont(new Font("Tahoma", 0, 16)); // NOI18N
        jTextFieldFindProduct.setText("Find product");
        jTextFieldFindProduct.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
               // jTextFieldFindProductActionPerformed(evt);
            }
        });

        jButton1.setBackground(new Color(0, 204, 204));
        jButton1.setFont(new Font("Tahoma", 0, 16)); // NOI18N
        jButton1.setText("Search");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String [] {
                        "Customer name", "Order number", "Quantity", "Payment method"
                }
        ) {
            final Class[] types = new Class [] {
                    java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };
            final boolean[] canEdit = new boolean [] {
                    false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        GroupLayout jPanelSearchByProductLayout = new GroupLayout(jPanelSearchByProduct);
        jPanelSearchByProduct.setLayout(jPanelSearchByProductLayout);
        jPanelSearchByProductLayout.setHorizontalGroup(
                jPanelSearchByProductLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelSearchByProductLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanelSearchByProductLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanelSearchByProductLayout.createSequentialGroup()
                                                .addComponent(jLabelProduct)
                                                .addGap(18, 18, 18)
                                                .addComponent(jTextFieldFindProduct)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton1))
                                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 619, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanelSearchByProductLayout.setVerticalGroup(
                jPanelSearchByProductLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelSearchByProductLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanelSearchByProductLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelProduct)
                                        .addComponent(jTextFieldFindProduct, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton1))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 556, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(21, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanelSearchByProduct, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanelSearchByProduct, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }
}
