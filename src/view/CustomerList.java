package view;


import controller.ApplicationController;
import exception.ConnectionException;
import exception.SelectQueryException;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;

import model.*;
import view.CustomerForm.CreateCustomerForm;
import view.CustomerForm.CustomerForm;
import view.CustomerForm.EditCustomerForm;
import view.tableModel.AllCustomersModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.util.ArrayList;

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

    public CustomerList() throws ConnectionException, SelectQueryException {
        panelSearchBar = new JPanel();
        jButtonSearch = new JButton();
        jTextFieldSearchBar = new JTextField();
        jLabelCustomerName = new JLabel();
        jLabelNickname = new JLabel();
        jTextFieldSearchBar1 = new JTextField();
        panelCustomerTable = new JPanel();
        jScrollCustomerTable = new JScrollPane();
        jTableCustomerList = new JTable();
        panelButtonCRUD = new JPanel();
        jButtonCreateCustomer = new JButton();
        jButtonReadCustomer = new JButton();
        jButtonUpdateCustomer = new JButton();
        jButtonDeleteCustomer = new JButton();



        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        jButtonSearch.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        jButtonSearch.setText("Search");

        jTextFieldSearchBar.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        jTextFieldSearchBar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //jTextFieldSearchBarActionPerformed(evt);
            }
        });

        jLabelCustomerName.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        jLabelCustomerName.setText("Customer name");

        jLabelNickname.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        jLabelNickname.setText("Nickname");

        jTextFieldSearchBar1.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        jTextFieldSearchBar1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //jTextFieldSearchBar1ActionPerformed(evt);
            }
        });

        GroupLayout panelSearchBarLayout = new GroupLayout(panelSearchBar);
        panelSearchBar.setLayout(panelSearchBarLayout);
        panelSearchBarLayout.setHorizontalGroup(
                panelSearchBarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, panelSearchBarLayout.createSequentialGroup()
                                .addGap(142, 142, 142)
                                .addComponent(jLabelCustomerName)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldSearchBar, GroupLayout.PREFERRED_SIZE, 383, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelNickname)
                                .addGap(32, 32, 32)
                                .addComponent(jTextFieldSearchBar1, GroupLayout.PREFERRED_SIZE, 315, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonSearch)
                                .addGap(26, 26, 26))
        );
        panelSearchBarLayout.setVerticalGroup(
                panelSearchBarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelSearchBarLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(panelSearchBarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextFieldSearchBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButtonSearch)
                                        .addComponent(jLabelCustomerName)
                                        .addComponent(jLabelNickname)
                                        .addComponent(jTextFieldSearchBar1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(31, Short.MAX_VALUE))
        );

        ApplicationController allCustomers = new ApplicationController();
        ArrayList<Customer> customers = allCustomers.getAllCustomers();
        AllCustomersModel customersModel = new AllCustomersModel(customers);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        jTableCustomerList = new JTable(customersModel);
        jTableCustomerList.setAutoCreateRowSorter(true);/*
        jTableCustomerList.getColumn(0).setCellRenderer(centerRenderer);
        jTableCustomerList.getColumn(1).setCellRenderer(centerRenderer);
        jTableCustomerList.getColumn(2).setCellRenderer(centerRenderer);
        jTableCustomerList.getColumn(3).setCellRenderer(centerRenderer);
        jTableCustomerList.getColumn(4).setCellRenderer(centerRenderer);
        jTableCustomerList.getColumn(5).setCellRenderer(centerRenderer);
        jTableCustomerList.getColumn(6).setCellRenderer(centerRenderer);
        jTableCustomerList.getColumn(7).setCellRenderer(centerRenderer);
        jTableCustomerList.getColumn(8).setCellRenderer(centerRenderer);
        jTableCustomerList.getColumn(9).setCellRenderer(centerRenderer);
        jTableCustomerList.getColumn(10).setCellRenderer(centerRenderer);*/
        jScrollCustomerTable = new JScrollPane(jTableCustomerList);


        jTableCustomerList.getTableHeader().setReorderingAllowed(false);
        jScrollCustomerTable.setViewportView(jTableCustomerList);

        GroupLayout panelCustomerTableLayout = new GroupLayout(panelCustomerTable);
        panelCustomerTable.setLayout(panelCustomerTableLayout);
        panelCustomerTableLayout.setHorizontalGroup(
                panelCustomerTableLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelCustomerTableLayout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jScrollCustomerTable, GroupLayout.DEFAULT_SIZE, 1219, Short.MAX_VALUE)
                                .addGap(16, 16, 16))
        );
        panelCustomerTableLayout.setVerticalGroup(
                panelCustomerTableLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, panelCustomerTableLayout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollCustomerTable, GroupLayout.PREFERRED_SIZE, 473, GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60))
        );

        Color color = new Color(166, 207, 147);
        jButtonCreateCustomer.setBackground(new Color(0, 204, 0));
        jButtonCreateCustomer.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        jButtonCreateCustomer.setText("Create customer");
        jButtonCreateCustomer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                CreateCustomerForm CreateCustomerForm = new CreateCustomerForm(color,"CreateCustomer");
                CreateCustomerForm.setVisible(true);
            }
        });




        jButtonUpdateCustomer.setBackground(new Color(0, 153, 153));
        jButtonUpdateCustomer.setFont(new Font("Tahoma", 0, 18));
        jButtonUpdateCustomer.setText("Edit customer");
        jButtonUpdateCustomer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

                Customer customer;
                customer = customersModel.getRow(jTableCustomerList.getSelectedRow());
                System.out.println(customer);

                EditCustomerForm editCustomerForm = new EditCustomerForm(color,"Edit customer");
                editCustomerForm.setVisible(true);

            }
        });

        //MouseListner sur jtable

        jButtonDeleteCustomer.setBackground(new Color(255, 102, 102));
        jButtonDeleteCustomer.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        jButtonDeleteCustomer.setText("Delete customer");

        GroupLayout panelButtonCRUDLayout = new GroupLayout(panelButtonCRUD);
        panelButtonCRUD.setLayout(panelButtonCRUDLayout);
        panelButtonCRUDLayout.setHorizontalGroup(
                panelButtonCRUDLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelButtonCRUDLayout.createSequentialGroup()
                                .addGap(376, 376, 376)
                                .addComponent(jButtonCreateCustomer)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonUpdateCustomer)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonDeleteCustomer)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelButtonCRUDLayout.setVerticalGroup(
                panelButtonCRUDLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelButtonCRUDLayout.createSequentialGroup()
                                .addGroup(panelButtonCRUDLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButtonUpdateCustomer)
                                        .addComponent(jButtonDeleteCustomer)
                                        .addComponent(jButtonCreateCustomer))
                                .addGap(0, 26, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(panelSearchBar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelCustomerTable, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelButtonCRUD, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(panelSearchBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panelCustomerTable, GroupLayout.PREFERRED_SIZE, 495, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panelButtonCRUD, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }
}
