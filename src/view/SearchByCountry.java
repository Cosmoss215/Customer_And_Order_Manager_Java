package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchByCountry extends JFrame {
    private javax.swing.JComboBox<String> jComboBoxCountryChoose;
    private javax.swing.JLabel jLabelCountry;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel panelCountrySelector;
    private javax.swing.JPanel panelTableCustomer;

    public SearchByCountry(){
        panelCountrySelector = new javax.swing.JPanel();
        jLabelCountry = new javax.swing.JLabel();
        jComboBoxCountryChoose = new javax.swing.JComboBox<>();
        panelTableCustomer = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        jLabelCountry.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelCountry.setText("Country");

        jComboBoxCountryChoose.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBoxCountryChoose.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Belgium", "France", "Netherlands", "Spain", "Germany" }));
        jComboBoxCountryChoose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //jComboBoxCountryChooseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelCountrySelectorLayout = new javax.swing.GroupLayout(panelCountrySelector);
        panelCountrySelector.setLayout(panelCountrySelectorLayout);
        panelCountrySelectorLayout.setHorizontalGroup(
                panelCountrySelectorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelCountrySelectorLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabelCountry)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBoxCountryChoose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(433, Short.MAX_VALUE))
        );
        panelCountrySelectorLayout.setVerticalGroup(
                panelCountrySelectorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCountrySelectorLayout.createSequentialGroup()
                                .addContainerGap(31, Short.MAX_VALUE)
                                .addGroup(panelCountrySelectorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelCountry)
                                        .addComponent(jComboBoxCountryChoose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(17, 17, 17))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null}
                },
                new String [] {
                        "Customer name", "Address"
                }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout panelTableCustomerLayout = new javax.swing.GroupLayout(panelTableCustomer);
        panelTableCustomer.setLayout(panelTableCustomerLayout);
        panelTableCustomerLayout.setHorizontalGroup(
                panelTableCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTableCustomerLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelTableCustomerLayout.setVerticalGroup(
                panelTableCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelTableCustomerLayout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelCountrySelector, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(panelTableCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(panelCountrySelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(panelTableCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }
}
