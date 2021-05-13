package view;

import controller.ApplicationController;
import exception.ConnectionException;
import exception.NullException;
import exception.SelectQueryException;
import model.Customer;
import view.tableModel.AllCustomersByCountryModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SearchByCountry extends JFrame {
    private final JComboBox<String> jComboBoxCountryChoose;
    private final JLabel jLabelCountry;
    private final JScrollPane jScrollPane1;
    private final JTable jTableCustomerByCountry;
    private final JPanel panelCountrySelector, panelTableCustomer;

    public SearchByCountry() throws ConnectionException, SelectQueryException {
        panelCountrySelector = new JPanel();
        jLabelCountry = new JLabel();
        jComboBoxCountryChoose = new JComboBox<>();
        panelTableCustomer = new JPanel();
        jScrollPane1 = new JScrollPane();
        jTableCustomerByCountry = new JTable();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        jLabelCountry.setFont(new Font("Tahoma", 0, 18));
        jLabelCountry.setText("Country");

        jComboBoxCountryChoose.setFont(new Font("Tahoma", 0, 18));
        jComboBoxCountryChoose.setModel(new DefaultComboBoxModel<>(new String[] { "Belgium", "France", "Netherlands", "Spain", "Germany" }));

        jComboBoxCountryChoose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ApplicationController customersByCountry = null;
                try {
                    customersByCountry = new ApplicationController();
                } catch (ConnectionException e) {
                    JOptionPane.showMessageDialog(null,e.getMessage(), e.getTypeError(), JOptionPane.WARNING_MESSAGE);
                }
                String country = (String) jComboBoxCountryChoose.getSelectedItem();

                ArrayList<Customer> allCustomerByCountry = null;
                try {
                    allCustomerByCountry = customersByCountry.getCustomersByCountry(country);
                } catch (SelectQueryException | NullException exception) {
                    JOptionPane.showMessageDialog(null,exception.getMessage(), exception.getTypeError(), JOptionPane.WARNING_MESSAGE);
                }

                AllCustomersByCountryModel customersByCountryModel = new AllCustomersByCountryModel(allCustomerByCountry);

                customersByCountryModel.fireTableDataChanged();
                jTableCustomerByCountry.setModel(customersByCountryModel);
            }
        });

        WindowFormattingCode();
        pack();
    }
    private void WindowFormattingCode(){
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


        jScrollPane1.setViewportView(jTableCustomerByCountry);

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
    }
}
