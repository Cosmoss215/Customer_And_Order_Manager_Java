package view;

import controller.ApplicationController;
import exception.ConnectionException;
import exception.SelectQueryException;
import model.Customer;
import view.tableModel.AllCustomersByCountryModel;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SearchByCountry extends JFrame {
    private JComboBox<String> jComboBoxCountryChoose;
    private JLabel jLabelCountry;
    private JScrollPane jScrollPane1;
    private JTable jTable1;
    private JPanel panelCountrySelector,panelTableCustomer;

    public SearchByCountry() throws ConnectionException, SelectQueryException {
        panelCountrySelector = new JPanel();
        jLabelCountry = new JLabel();
        jComboBoxCountryChoose = new JComboBox<>();
        panelTableCustomer = new JPanel();
        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        jLabelCountry.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        jLabelCountry.setText("Country");

        jComboBoxCountryChoose.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        jComboBoxCountryChoose.setModel(new DefaultComboBoxModel<>(new String[] { "Belgium", "France", "Netherlands", "Spain", "Germany" }));
        jComboBoxCountryChoose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //Ajouter le code permettant de refresh la ou est le tableau en fonction du pays selectionner
            }
        });
        ApplicationController customersByCountry = null;
        try {
            customersByCountry = new ApplicationController();
        } catch (ConnectionException e) {
            JOptionPane.showMessageDialog(null,e.getMessage(), "ConnectionException",
                    JOptionPane.WARNING_MESSAGE);
        }
        String country = (String) jComboBoxCountryChoose.getSelectedItem();

        ArrayList<Customer> allCustomerByCountry = null;
        try {
            allCustomerByCountry = customersByCountry.getCustomersByCountry("France");
        } catch (SelectQueryException e) {
            JOptionPane.showMessageDialog(null,e.getMessage(), "QueryException",
                    JOptionPane.WARNING_MESSAGE);
        }

        AllCustomersByCountryModel customersByCountryModel = new AllCustomersByCountryModel(allCustomerByCountry);


        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        jTable1 = new JTable(customersByCountryModel);
        panelTableCustomer.add(jTable1);


        //region Code de mise en forme
        GroupLayout panelCountrySelectorLayout = new GroupLayout(panelCountrySelector);
        panelCountrySelector.setLayout(panelCountrySelectorLayout);
        panelCountrySelectorLayout.setHorizontalGroup(
                panelCountrySelectorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelCountrySelectorLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabelCountry)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBoxCountryChoose, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(433, Short.MAX_VALUE))
        );
        panelCountrySelectorLayout.setVerticalGroup(
                panelCountrySelectorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, panelCountrySelectorLayout.createSequentialGroup()
                                .addContainerGap(31, Short.MAX_VALUE)
                                .addGroup(panelCountrySelectorLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelCountry)
                                        .addComponent(jComboBoxCountryChoose, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(17, 17, 17))
        );


        jScrollPane1.setViewportView(jTable1);

        GroupLayout panelTableCustomerLayout = new GroupLayout(panelTableCustomer);
        panelTableCustomer.setLayout(panelTableCustomerLayout);
        panelTableCustomerLayout.setHorizontalGroup(
                panelTableCustomerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, panelTableCustomerLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 630, GroupLayout.PREFERRED_SIZE))
        );
        panelTableCustomerLayout.setVerticalGroup(
                panelTableCustomerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelTableCustomerLayout.createSequentialGroup()
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 540, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 23, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(panelCountrySelector, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(panelTableCustomer, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(panelCountrySelector, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(panelTableCustomer, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        //endregion

        pack();
    }
}
