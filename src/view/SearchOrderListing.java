package view;

import controller.ApplicationController;
import exception.ConnectionException;
import exception.SelectQueryException;
import model.Customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;


public class SearchOrderListing extends JFrame {
    private SpinnerDateModel jDatePickerModelStart,jDatePickerModelEnd;
    private JSpinner startDateSelector;
    private JSpinner endDateSelector;
    private JLabel jLabelCustomerName;
    private JLabel jLabelFrom;
    private JLabel jLabelTo;
    private JScrollPane jScrollTableOrderList;
    private JTable jTableOrderList;
    private JTextField jTextFieldSearchBar;
    private JPanel panelSearchBar;
    private JPanel panelTableOrderList;
    private ArrayList<Customer> customers;

    public SearchOrderListing() throws ConnectionException, SelectQueryException {
        panelSearchBar = new JPanel();
        jLabelCustomerName = new JLabel();
        jTextFieldSearchBar = new JTextField();
        jDatePickerModelStart = new SpinnerDateModel();
        jDatePickerModelEnd = new SpinnerDateModel();
        jLabelFrom = new JLabel();
        startDateSelector = new JSpinner();
        endDateSelector = new JSpinner();
        jLabelTo = new JLabel();
        panelTableOrderList = new JPanel();
        jScrollTableOrderList = new JScrollPane();
        jTableOrderList = new JTable();


        ApplicationController allCustomers = new ApplicationController();
        customers = allCustomers.getAllCustomers();


        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        jLabelCustomerName.setFont(new Font("Tahoma", 0, 18));
        jLabelCustomerName.setText("Customer's name");

        jTextFieldSearchBar.setFont(new Font("Dialog", 0, 18));
        jTextFieldSearchBar.setText("");
        jTextFieldSearchBar.setCursor(new Cursor(Cursor.TEXT_CURSOR));

        KeyboardListner keyboardListner = new KeyboardListner();
        jTextFieldSearchBar.addKeyListener(keyboardListner);


        startDateSelector.setModel(jDatePickerModelStart);
        endDateSelector.setModel(jDatePickerModelEnd);
        startDateSelector.setFont(new Font("Tahoma", 0, 18));
        endDateSelector.setFont(new Font("Tahoma", 0, 18));


        jLabelFrom.setFont(new Font("Dialog", 0, 18));
        jLabelFrom.setText("From");


        jLabelTo.setFont(new Font("Dialog", 0, 18));
        jLabelTo.setText("to");



        jTableOrderList.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null}
                },
                new String [] {
                        "Order number", "Date order", "Price", "Payment method", "Payment deadline"
                }
        ) {
            Class[] types = new Class [] {
                    java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                    false, false, true, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollTableOrderList.setViewportView(jTableOrderList);


        //region Code de mise en forme
        GroupLayout panelSearchBarLayout = new GroupLayout(panelSearchBar);
        panelSearchBar.setLayout(panelSearchBarLayout);
        panelSearchBarLayout.setHorizontalGroup(
                panelSearchBarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelSearchBarLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabelCustomerName)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextFieldSearchBar, GroupLayout.PREFERRED_SIZE, 495, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelFrom)
                                .addGap(18, 18, 18)
                                .addComponent(startDateSelector, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelTo)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(endDateSelector, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(169, 169, 169))
        );
        panelSearchBarLayout.setVerticalGroup(
                panelSearchBarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelSearchBarLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panelSearchBarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(panelSearchBarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabelTo)
                                                .addComponent(endDateSelector, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(startDateSelector, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabelFrom)
                                                .addComponent(jTextFieldSearchBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(GroupLayout.Alignment.TRAILING, panelSearchBarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabelCustomerName)))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GroupLayout panelTableOrderListLayout = new GroupLayout(panelTableOrderList);
        panelTableOrderList.setLayout(panelTableOrderListLayout);
        panelTableOrderListLayout.setHorizontalGroup(
                panelTableOrderListLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 1222, Short.MAX_VALUE)
        );
        panelTableOrderListLayout.setVerticalGroup(
                panelTableOrderListLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 572, Short.MAX_VALUE)
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(panelSearchBar, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jScrollTableOrderList, GroupLayout.PREFERRED_SIZE, 1207, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(19, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(panelTableOrderList, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(18, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(panelSearchBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollTableOrderList, GroupLayout.PREFERRED_SIZE, 545, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(21, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addContainerGap(67, Short.MAX_VALUE)
                                        .addComponent(panelTableOrderList, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap()))
        );
        //endregion

        pack();
    }
    public void autoComplete (String txt){
        String complete = "";
        int start = txt.length();
        int last = txt.length();
        int a;

        //name as array variable
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
