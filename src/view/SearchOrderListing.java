package view;

import controller.ApplicationController;
import exception.*;
import model.*;
import util.*;
import view.tableModel.AllOrdersByCustomerModel;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.GregorianCalendar;


public class SearchOrderListing extends JFrame {
    private final JTextField startDateSelector;
    private final JTextField endDateSelector;
    private final JLabel jLabelCustomerName;
    private final JLabel jLabelFrom;
    private final JLabel jLabelTo;
    private JScrollPane jScrollTableOrderList;
    private final JTextField jTextFieldSearchBar;
    private final JPanel panelSearchBar;
    private final JPanel panelTableOrderList;
    private JTable jTableOrderList;
    private ArrayList<Customer> customers;
    private ArrayList<OrderByCustomer> orders;
    private JButton searchButton;
    private ApplicationController applicationControllerCustomer;
    private LineBorder redBorder;
    private LineBorder blackBorder;

    int customerId;

    public SearchOrderListing() throws ConnectionException, SelectQueryException {
        super("Customer's order list");
        panelSearchBar = new JPanel();
        jLabelCustomerName = new JLabel();
        jTextFieldSearchBar = new JTextField();
        jLabelFrom = new JLabel();
        jLabelTo = new JLabel();
        panelTableOrderList = new JPanel();
        jScrollTableOrderList = new JScrollPane();
        jTableOrderList = new JTable();

        redBorder = new LineBorder((Color.red), 3);
        blackBorder = new LineBorder((Color.black), 1);

        ApplicationController allCustomers = new ApplicationController();
        customers = allCustomers.getAllCustomers();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        initJLabel();

        jTextFieldSearchBar.setFont(new Font("Dialog", 0, 18));
        jTextFieldSearchBar.setText("");

        KeyboardListner keyboardListner = new KeyboardListner();
        jTextFieldSearchBar.addKeyListener(keyboardListner);

        startDateSelector = new JTextField();
        endDateSelector = new JTextField();

        startDateSelector.setPreferredSize(new Dimension(100, 30));
        endDateSelector.setPreferredSize(new Dimension(100, 30));

        startDateSelector.setFont(new Font("Tahoma", 0, 18));
        endDateSelector.setFont(new Font("Tahoma", 0, 18));

        searchButton = new JButton("Search");
        searchButton.addActionListener(evt -> {
            if (!jTextFieldSearchBar.getText().isEmpty()) {
                jTextFieldSearchBar.setBorder(new LineBorder(Color.BLACK, 1));
                try {
                    if (startDateSelector.getText().isEmpty()) {
                        initTable(customerId);
                    } else {
                        if (Verification.dateVerification(startDateSelector.getText()) && Verification.dateVerification(endDateSelector.getText())) {
                            GregorianCalendar startDate = DateFormater.ourDate(startDateSelector.getText());
                            GregorianCalendar endDate = DateFormater.ourDate(endDateSelector.getText());

                            startDateSelector.setBorder(new LineBorder(Color.BLACK, 1));
                            endDateSelector.setBorder(new LineBorder(Color.BLACK, 1));

                            initTable(customerId, startDate, endDate);
                        } else {
                            JOptionPane.showMessageDialog(null, "The date isn't correct", "Invalid field", JOptionPane.INFORMATION_MESSAGE);
                            startDateSelector.setBorder(redBorder);
                            endDateSelector.setBorder(redBorder);
                        }
                    }

                    jScrollTableOrderList.setViewportView(jTableOrderList);
                } catch (ConnectionException | SelectQueryException | NullException exception) {
                    JOptionPane.showMessageDialog(null, exception.getMessage(), exception.getTypeError(), JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "You must indicate the name of a customer. You can find the list via the menu bar, in the item \"Customer list\"", "Invalid field", JOptionPane.INFORMATION_MESSAGE);
                jTextFieldSearchBar.setBorder(redBorder);
            }
        });

        jScrollTableOrderList = new JScrollPane(jTableOrderList);
        jTableOrderList.getTableHeader().setReorderingAllowed(false);
        jTableOrderList.setAutoCreateRowSorter(true);
        jScrollTableOrderList.setViewportView(jTableOrderList);

        WindowFormattingCode();

        pack();
    }

    private void initJTableOrderList(ArrayList<OrderByCustomer> orders){
        AllOrdersByCustomerModel orderByCustomerModel = new AllOrdersByCustomerModel(orders);
        jTableOrderList.setModel(orderByCustomerModel);
    }

    private void initTable(int customerId, GregorianCalendar startDate,GregorianCalendar endDate) throws ConnectionException, SelectQueryException, NullException {
        ApplicationController applicationController = new ApplicationController();
        orders = applicationController.getOrdersByCustomer(customerId, startDate, endDate);
        initJTableOrderList(orders);
    }

    private void initTable(int customerId) throws ConnectionException, SelectQueryException, NullException {
        ApplicationController applicationController = new ApplicationController();
        orders = applicationController.getOrdersByCustomer(customerId);
        initJTableOrderList(orders);
    }

    private void initJLabel(){
        jLabelCustomerName.setFont(new Font("Tahoma", 0, 18));
        jLabelCustomerName.setText("Customer's name");
        jLabelFrom.setFont(new Font("Dialog", 0, 18));
        jLabelFrom.setText("From");
        jLabelTo.setFont(new Font("Dialog", 0, 18));
        jLabelTo.setText("to");
    }
    private void WindowFormattingCode(){
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
                                .addGap(18, 18, 18)
                                .addComponent(searchButton)
                                .addGap(62, 62, 62)
                        )
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
                                                .addComponent(jTextFieldSearchBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(searchButton))
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
    }

    private void autoComplete (String txt){
        String complete = "";
        int start = txt.length();
        int last = txt.length();


        int iCurrentCustomer = 0;
        Boolean isFind = false;
        while (iCurrentCustomer < customers.size() && !isFind){
            Customer currentCustomer = customers.get(iCurrentCustomer);
            if (currentCustomer .getFirstName().startsWith(txt) || currentCustomer .getLastName().startsWith(txt)) {
                complete = currentCustomer.getLastName() + " " +currentCustomer.getFirstName();
                customerId = currentCustomer.getId();
                last = complete.length();
                isFind = true;
            }
            iCurrentCustomer++;
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
                    EventQueue.invokeLater(() -> {
                        String txt = jTextFieldSearchBar.getText();
                        autoComplete(txt);
                    });
            }
        }
        @Override
        public void keyReleased(KeyEvent e) {

        }
    }
}
