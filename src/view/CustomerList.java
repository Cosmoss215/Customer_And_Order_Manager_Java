package view;


import controller.ApplicationController;
import exception.ConnectionException;
import exception.DeleteQueryException;
import exception.SelectQueryException;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;

import exception.UpdateQueryException;
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
        jButtonSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    customers =  applicationControllerCustomer.getAllCustomers();
                } catch (SelectQueryException exception) {
                    JOptionPane.showMessageDialog(null,exception.getMessage(), exception.getTypeError(), JOptionPane.WARNING_MESSAGE);
                }
                customersModel = new AllCustomersModel(customers);
                jTableCustomerList.setModel(customersModel);
            }
        });

        jTextFieldSearchBar.setFont(new Font("Tahoma", 0, 18));;
        jTextFieldSearchBar1.setFont(new Font("Tahoma", 0, 18));

        KeyboardListner keyboardListner = new KeyboardListner();
        jTextFieldSearchBar.addKeyListener(keyboardListner);
    }

    private void initTable() throws ConnectionException, SelectQueryException {
        applicationControllerCustomer = new ApplicationController();
        customers = applicationControllerCustomer.getAllCustomers();
        customersModel = new AllCustomersModel(customers);
        jTableCustomerList = new JTable(customersModel);
        jTableCustomerList.setAutoCreateRowSorter(true);
        jScrollCustomerTable = new JScrollPane(jTableCustomerList);
        jTableCustomerList.getTableHeader().setReorderingAllowed(false);
        jScrollCustomerTable.setViewportView(jTableCustomerList);
    }

    private void initPanelButton(){
        Color color = new Color(166, 207, 147);

        jButtonCreateCustomer.setBackground(new Color(0, 204, 0));
        jButtonCreateCustomer.setFont(new Font("Tahoma", 0, 18)); //
        jButtonCreateCustomer.setText("Create customer");
        jButtonCreateCustomer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                CreateCustomerForm CreateCustomerForm = null;
                try {
                    CreateCustomerForm = new CreateCustomerForm(color,"CreateCustomer");
                    CreateCustomerForm.setVisible(true);
                } catch (SelectQueryException | ConnectionException exception) {
                    JOptionPane.showMessageDialog(null,exception.getMessage(), exception.getTypeError(), JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        jButtonUpdateCustomer.setBackground(new Color(0, 153, 153));
        jButtonUpdateCustomer.setFont(new Font("Tahoma", 0, 18));
        jButtonUpdateCustomer.setText("Edit customer");
        jButtonUpdateCustomer.addActionListener(evt -> {
            Customer customer;
            customer = customersModel.getRow(jTableCustomerList.getSelectedRow());
            try {
                EditCustomerForm editCustomerForm = new EditCustomerForm(color,"Edit customer",customer);
                editCustomerForm.setVisible(true);
            } catch (SelectQueryException | ConnectionException exception) {
                JOptionPane.showMessageDialog(null,exception.getMessage(), exception.getTypeError(), JOptionPane.WARNING_MESSAGE);
            }
        });
        jButtonDeleteCustomer.setBackground(new Color(255, 102, 102));
        jButtonDeleteCustomer.setFont(new Font("Tahoma", 0, 18)); //
        jButtonDeleteCustomer.setText("Delete customer");
        jButtonDeleteCustomer.addActionListener(evt -> {
            Customer customer;
            int row = jTableCustomerList.getSelectedRow();
            customer = customersModel.getRow(row);
            try {
                applicationControllerCustomer.delete(customer);
            } catch (DeleteQueryException | UpdateQueryException exception) {
                JOptionPane.showMessageDialog(null,exception.getMessage(), exception.getTypeError(), JOptionPane.WARNING_MESSAGE);
            }
        });

    }
    private void WindowFormattingCode(){
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

    private void autoComplete (String txt){
        String complete = "";
        int start = txt.length();
        int last = txt.length();
        int a;

        for(a = 0; a < customers.size();a++)
        {
            if (customers.get(a).getFirstName().startsWith(txt) || customers.get(a).getLastName().startsWith(txt)) {
                complete = customers.get(a).getLastName() + " " +customers.get(a).getFirstName();
                last = complete.length();
                break;
            }
        }
        if (last > start) {
            jTextFieldSearchBar.setText(complete);
            jTextFieldSearchBar.setCaretPosition(last);
            jTextFieldSearchBar.moveCaretPosition(start);
        }
    }

    private class KeyboardListner implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent evt) {
            switch (evt.getKeyCode()) {
                case KeyEvent.VK_BACK_SPACE:
                    break;
                case KeyEvent.VK_ENTER:
                    jTextFieldSearchBar.setText(jTextFieldSearchBar.getText());
                    break;
                default:
                    EventQueue.invokeLater(new Runnable(){
                        @Override

                        public void run(){
                            String txt = jTextFieldSearchBar.getText();
                            autoComplete(txt);
                        }
                    });
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }
}
