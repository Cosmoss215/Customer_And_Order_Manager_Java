package view;


import controller.ApplicationController;
import exception.*;

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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class CustomerList extends JFrame {
    private final JButton jButtonCreateCustomer;
    private final JButton jButtonDeleteCustomer;
    private final JButton jButtonSearch;
    private final JButton jButtonUpdateCustomer;
    private final JLabel jLabelCustomerName,jLabelNickname;
    private JScrollPane jScrollCustomerTable;
    private JTable jTableCustomerList;
    private final JTextField jTextFieldSearchBar, jTextFieldSearchBar1;
    private final JPanel panelButtonCRUD, panelCustomerTable, panelSearchBar;
    private ApplicationController applicationControllerCustomer;
    private AllCustomersModel customersModel;
    private ArrayList<Customer> customers;

    public CustomerList() throws ConnectionException, SelectQueryException {
        super("Customer List");
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
        jButtonUpdateCustomer = new JButton();
        jButtonDeleteCustomer = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        initPanelSearchBar();

        initTable();

        initPanelButton();

        WindowFormattingCode();

        pack();
    }


    private void initPanelSearchBar(){
        jLabelCustomerName.setFont(new Font("Tahoma", 0, 18));
        jLabelCustomerName.setText("Customer name");

        jLabelNickname.setFont(new Font("Tahoma", 0, 18));
        jLabelNickname.setText("Nickname");

        jButtonSearch.setFont(new Font("Tahoma", 0, 18));
        jButtonSearch.setText("Refresh");
        jButtonSearch.addActionListener(evt -> {
            try {
                customers =  applicationControllerCustomer.getAllCustomers();
            } catch (SelectQueryException exception) {
                JOptionPane.showMessageDialog(null,exception.getMessage(), exception.getTypeError(), JOptionPane.WARNING_MESSAGE);
            }
            customersModel = new AllCustomersModel(customers);
            jTableCustomerList.setModel(customersModel);
        });

        jTextFieldSearchBar.setFont(new Font("Tahoma", 0, 18));;
        jTextFieldSearchBar1.setFont(new Font("Tahoma", 0, 18));
    }

    private void initTable() throws ConnectionException, SelectQueryException {
        applicationControllerCustomer = new ApplicationController();
        customers = applicationControllerCustomer.getAllCustomers();
        customersModel = new AllCustomersModel(customers);
        jTableCustomerList = new JTable(customersModel);
        jTableCustomerList.setAutoCreateRowSorter(false);
        jTableCustomerList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//Allows selection of a single line
        jScrollCustomerTable = new JScrollPane(jTableCustomerList);
        jTableCustomerList.getTableHeader().setReorderingAllowed(false);
        jScrollCustomerTable.setViewportView(jTableCustomerList);
    }

    private void initPanelButton(){
        Color color = new Color(166, 207, 147);

        jButtonCreateCustomer.setBackground(new Color(0, 204, 0));
        jButtonCreateCustomer.setFont(new Font("Tahoma", 0, 18)); //
        jButtonCreateCustomer.setText("Create customer");
        jButtonCreateCustomer.addActionListener(evt -> {
            CreateCustomerForm createCustomerForm = null;
            try {
                createCustomerForm = new CreateCustomerForm(color,"CreateCustomer");
                createCustomerForm.setVisible(true);
            } catch (SelectQueryException | ConnectionException exception) {
                JOptionPane.showMessageDialog(null,exception.getMessage(), exception.getTypeError(), JOptionPane.WARNING_MESSAGE);
            }
        });
        jButtonUpdateCustomer.setBackground(new Color(0, 153, 153));
        jButtonUpdateCustomer.setFont(new Font("Tahoma", 0, 18));
        jButtonUpdateCustomer.setText("Edit customer");
        jButtonUpdateCustomer.addActionListener(evt -> {
            if (jTableCustomerList.getSelectedRow() != -1) {
                try {
                    Customer customerToEdit;
                    customerToEdit = customersModel.getRow(jTableCustomerList.getSelectedRow());
                    EditCustomerForm editCustomerForm = new EditCustomerForm(color, "Edit customer", customerToEdit);
                    editCustomerForm.setVisible(true);
                } catch (SelectQueryException | ConnectionException exception) {
                    JOptionPane.showMessageDialog(null, exception.getMessage(), exception.getTypeError(), JOptionPane.WARNING_MESSAGE);
                }
            }
            else {
                JOptionPane.showMessageDialog(null, "Please select the customer you want to edit.", "Edit error", JOptionPane.WARNING_MESSAGE);
            }
        });
        jButtonDeleteCustomer.setBackground(new Color(255, 102, 102));
        jButtonDeleteCustomer.setFont(new Font("Tahoma", 0, 18));
        jButtonDeleteCustomer.setText("Delete customer");
        jButtonDeleteCustomer.addActionListener(evt -> {
            if(jTableCustomerList.getSelectedRow() != -1) {
                Customer customerToDelete;
                customerToDelete = customersModel.getRow(jTableCustomerList.getSelectedRow());

                int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (response == JOptionPane.YES_OPTION) {
                    try {
                        applicationControllerCustomer.delete(customerToDelete);
                        refreshJtable();
                    } catch (DeleteQueryException | UpdateQueryException | NullException exception) {
                        JOptionPane.showMessageDialog(null, exception.getMessage(), exception.getTypeError(), JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
            else {
                JOptionPane.showMessageDialog(null, "Please select the customer you want to delete.", "Delete error", JOptionPane.WARNING_MESSAGE);
            }
        });

    }
    private void refreshJtable(){
        try {
            customers =  applicationControllerCustomer.getAllCustomers();
        } catch (SelectQueryException exception) {
            JOptionPane.showMessageDialog(null,exception.getMessage(), exception.getTypeError(), JOptionPane.WARNING_MESSAGE);
        }
        customersModel = new AllCustomersModel(customers);
        jTableCustomerList.setModel(customersModel);
    }

    public void refresh(){
        refreshJtable();
    }

    private void WindowFormattingCode(){
        GroupLayout panelSearchBarLayout = new GroupLayout(panelSearchBar);
        panelSearchBar.setLayout(panelSearchBarLayout);
        panelSearchBarLayout.setHorizontalGroup(
                panelSearchBarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, panelSearchBarLayout.createSequentialGroup()
                                .addGap(142, 142, 142)
                                .addComponent(jLabelCustomerName)
                                .addGap(25, 25, 25)
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
    }

}
