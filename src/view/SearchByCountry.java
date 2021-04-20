package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchByCountry extends JFrame {
    private final JPanel PanelSelector;
    private final JPanel PanelTable;
    private final JComboBox<String> jComboBoxCountryChoose;
    private final JLabel jLabelCountry;
    private final JScrollPane jScrollPane1;
    private final JTable jTable1;

    public SearchByCountry(){
        PanelSelector = new JPanel();
        jLabelCountry = new JLabel();
        jComboBoxCountryChoose = new JComboBox<>();
        PanelTable = new JPanel();
        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        jLabelCountry.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        jLabelCountry.setText("Country");

        jComboBoxCountryChoose.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        jComboBoxCountryChoose.setModel(new DefaultComboBoxModel<>(new String[] { "Belgium", "France", "Netherlands", "Spain", "Germany" }));
        jComboBoxCountryChoose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //jComboBoxCountryChooseActionPerformed(evt);
            }
        });

        GroupLayout PanelSelectorLayout = new GroupLayout(PanelSelector);
        PanelSelector.setLayout(PanelSelectorLayout);
        PanelSelectorLayout.setHorizontalGroup(
                PanelSelectorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(PanelSelectorLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabelCountry)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBoxCountryChoose, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelSelectorLayout.setVerticalGroup(
                PanelSelectorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, PanelSelectorLayout.createSequentialGroup()
                                .addContainerGap(31, Short.MAX_VALUE)
                                .addGroup(PanelSelectorLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelCountry)
                                        .addComponent(jComboBoxCountryChoose, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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

        GroupLayout PanelTableLayout = new GroupLayout(PanelTable);
        PanelTable.setLayout(PanelTableLayout);
        PanelTableLayout.setHorizontalGroup(
                PanelTableLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(PanelTableLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 621, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(19, Short.MAX_VALUE))
        );
        PanelTableLayout.setVerticalGroup(
                PanelTableLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(PanelTableLayout.createSequentialGroup()
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 586, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 8, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(PanelSelector, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(PanelTable, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(PanelSelector, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(PanelTable, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }
}
