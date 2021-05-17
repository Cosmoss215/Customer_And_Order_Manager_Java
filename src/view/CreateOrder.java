package view;

import controller.ApplicationController;
import exception.ConnectionException;
import exception.SelectQueryException;
import model.Customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;


public class CreateOrder extends JFrame {

    private final JButton jButtonAddProduct;
    private final JButton jButtonCancel;
    private final JButton jButtonCancel1;
    private final JButton jButtonDeleteProduct;
    private final JComboBox<String> jComboBoxDeadline;
    private final JComboBox<String> jComboBoxPaymentmethod;
    private final JLabel jLabelAddProduct;
    private final JLabel jLabelAddProduct1;
    private final JLabel jLabelCreationDate;
    private final JLabel jLabelCustomer;
    private final JLabel jLabelDate;
    private final JLabel jLabelDateOfTheDay;
    private final JLabel jLabelPaymentDealine;
    private final JLabel jLabelPaymentDealine1;
    private final JLabel jLabelPaymentMethod;
    private final JScrollPane jScrollPaneOrderInformation;
    private final JScrollPane jScrollPaneTotal;
    private final JTextField jTextFieldAddProductChoose;
    private final JTextField jTextFieldCustomerName;
    private final JPanel panelOrder;
    private final JPanel panelOrderInformation;
    private final JSpinner quantitySelector;
    private final ArrayList<Customer> customers;
    JTable jTableTotal,jTableOrderInformation;

    public CreateOrder() throws ConnectionException, SelectQueryException {
        super("Create Order");
        panelOrderInformation = new JPanel();
        jLabelCustomer = new JLabel();
        jTextFieldCustomerName = new JTextField();
        jLabelPaymentMethod = new JLabel();
        jComboBoxPaymentmethod = new JComboBox<>();
        jLabelPaymentDealine = new JLabel();
        jComboBoxDeadline = new JComboBox<>();
        jLabelPaymentDealine1 = new JLabel();
        jLabelCreationDate = new JLabel();
        jLabelDate = new JLabel();
        jLabelDateOfTheDay = new JLabel();
        panelOrder = new JPanel();
        jScrollPaneOrderInformation = new JScrollPane();
        jLabelAddProduct = new JLabel();
        jTextFieldAddProductChoose = new JTextField();
        jLabelAddProduct1 = new JLabel();
        jButtonAddProduct = new JButton();
        jScrollPaneTotal = new JScrollPane();
        jButtonDeleteProduct = new JButton();
        jButtonCancel = new JButton();
        jButtonCancel1 = new JButton();
        jTableOrderInformation = new JTable();
        jTableTotal = new JTable();
        quantitySelector = new JSpinner();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        panelOrder.setBackground(new Color(0, 153, 153));

        //region Autocomplete
        ApplicationController allCustomers = new ApplicationController();
        customers = allCustomers.getAllCustomers();
        KeyboardListner keyboardListner = new KeyboardListner();
        jTextFieldCustomerName.addKeyListener(keyboardListner);
        //endregion

        initTextFieldComboBoxSpinner();

        initJLabel();

        initJTable();

        initJButton();

        WindowFormattingCode();

        pack();
    }

    private void initTextFieldComboBoxSpinner(){

        jComboBoxPaymentmethod.setFont(new Font("Tahoma", 0, 18));
        jComboBoxPaymentmethod.setModel(new DefaultComboBoxModel<>(new String[] { "Paypal", "transfer" }));

        jComboBoxDeadline.setFont(new Font("Tahoma", 0, 18));
        jComboBoxDeadline.setModel(new DefaultComboBoxModel<>(new String[] { "8", "15", "30" }));

        jTextFieldCustomerName.setFont(new Font("Tahoma", 0, 18));
        jTextFieldCustomerName.addActionListener(evt -> {

        });

        jTextFieldAddProductChoose.setFont(new Font("Tahoma", 0, 18));
        jTextFieldAddProductChoose.addActionListener(evt -> {

        });
        quantitySelector.setModel(new SpinnerNumberModel(0,0,100000,1));
        quantitySelector.setFont(new Font("Tahoma", 0, 18));
    }


    private void initJLabel(){
        jLabelCustomer.setFont(new Font("Tahoma", 0, 18));
        jLabelCustomer.setText("Customer");

        jLabelPaymentMethod.setFont(new Font("Tahoma", 0, 18));
        jLabelPaymentMethod.setText("Payment method");

        jLabelPaymentDealine.setFont(new Font("Tahoma", 0, 18));
        jLabelPaymentDealine.setText("Payment deadline");

        jLabelPaymentDealine1.setFont(new Font("Tahoma", 0, 18));
        jLabelPaymentDealine1.setText("days");

        jLabelCreationDate.setFont(new Font("Tahoma", 0, 18));
        jLabelCreationDate.setText("Creation date");

        jLabelDate.setFont(new Font("Tahoma", 0, 18));

        jLabelDateOfTheDay.setFont(new Font("Tahoma", 0, 18));
        jLabelDateOfTheDay.setText("Date of the day");

        jLabelAddProduct.setFont(new Font("Tahoma", 0, 18));
        jLabelAddProduct.setForeground(new Color(255, 255, 255));
        jLabelAddProduct.setText("Quantity");

        jLabelAddProduct1.setFont(new Font("Tahoma", 0, 18));
        jLabelAddProduct1.setForeground(new Color(255, 255, 255));
        jLabelAddProduct1.setText("Add product");
    }

    private void initJTable(){
        jTableOrderInformation.setFont(new Font("Tahoma", 0, 12));
        jTableOrderInformation.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null}
                },
                new String [] {
                        "Product", "Quantity", "Unit Price", "Discount", "VAT", "Subtotal"
                }
        ) {
            final Class[] types = new Class [] {
                    java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPaneOrderInformation.setViewportView(jTableOrderInformation);
        jTableTotal.setFont(new Font("Tahoma", 0, 12)); //
        jTableTotal.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {"Total excluding VAT", null},
                        {"VAT", null},
                        {"Total price", null}
                },
                new String [] {
                        "", ""
                }
        ) {
            final Class[] types = new Class [] {
                    java.lang.String.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPaneTotal.setViewportView(jTableTotal);
    }

    private void initJButton(){
        jButtonAddProduct.setBackground(new Color(0, 204, 51));
        jButtonAddProduct.setFont(new Font("Tahoma", 0, 18)); //
        jButtonAddProduct.setText("Add");

        jButtonDeleteProduct.setBackground(new Color(255, 255, 0));
        jButtonDeleteProduct.setFont(new Font("Tahoma", 0, 18)); //
        jButtonDeleteProduct.setText("Delete product");

        jButtonCancel.setBackground(new Color(0, 204, 0));
        jButtonCancel.setFont(new Font("Tahoma", 0, 18)); //
        jButtonCancel.setText("Create order");

        jButtonCancel1.setBackground(new Color(255, 0, 0));
        jButtonCancel1.setFont(new Font("Tahoma", 0, 18)); //
        jButtonCancel1.setText("Cancel");
    }

    private void WindowFormattingCode(){
        GroupLayout panelOrderInformationLayout = new GroupLayout(panelOrderInformation);
        panelOrderInformation.setLayout(panelOrderInformationLayout);
        panelOrderInformationLayout.setHorizontalGroup(
                panelOrderInformationLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelOrderInformationLayout.createSequentialGroup()
                                .addGroup(panelOrderInformationLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(panelOrderInformationLayout.createSequentialGroup()
                                                .addGap(57, 57, 57)
                                                .addComponent(jLabelCreationDate)
                                                .addGap(18, 18, 18)
                                                .addGroup(panelOrderInformationLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jLabelDate, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(panelOrderInformationLayout.createSequentialGroup()
                                                                .addGap(10, 10, 10)
                                                                .addComponent(jLabelDateOfTheDay, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabelPaymentMethod)
                                                .addGap(38, 38, 38)
                                                .addComponent(jComboBoxPaymentmethod, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
                                                .addGap(53, 53, 53)
                                                .addComponent(jLabelPaymentDealine)
                                                .addGap(37, 37, 37)
                                                .addComponent(jComboBoxDeadline, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(36, 36, 36)
                                                .addComponent(jLabelPaymentDealine1))
                                        .addGroup(panelOrderInformationLayout.createSequentialGroup()
                                                .addGap(149, 149, 149)
                                                .addComponent(jLabelCustomer)
                                                .addGap(18, 18, 18)
                                                .addComponent(jTextFieldCustomerName, GroupLayout.PREFERRED_SIZE, 392, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addGap(18, 18, 18)))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelOrderInformationLayout.setVerticalGroup(
                panelOrderInformationLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelOrderInformationLayout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(panelOrderInformationLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelCustomer)
                                        .addComponent(jTextFieldCustomerName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                )
                                .addGap(18, 18, 18)
                                .addGroup(panelOrderInformationLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelCreationDate)
                                        .addComponent(jLabelPaymentMethod)
                                        .addComponent(jComboBoxPaymentmethod, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelPaymentDealine)
                                        .addComponent(jComboBoxDeadline, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelPaymentDealine1)
                                        .addComponent(jLabelDate)
                                        .addComponent(jLabelDateOfTheDay))
                                .addContainerGap(19, Short.MAX_VALUE))
        );


        GroupLayout panelOrderLayout = new GroupLayout(panelOrder);
        panelOrder.setLayout(panelOrderLayout);
        panelOrderLayout.setHorizontalGroup(
                panelOrderLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelOrderLayout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(panelOrderLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPaneOrderInformation, GroupLayout.PREFERRED_SIZE, 1042, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(panelOrderLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(panelOrderLayout.createSequentialGroup()
                                                        .addComponent(jLabelAddProduct1)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jTextFieldAddProductChoose, GroupLayout.PREFERRED_SIZE, 334, GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jLabelAddProduct)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(quantitySelector, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jButtonAddProduct)
                                                        .addGap(365, 365, 365))
                                                .addGroup(panelOrderLayout.createSequentialGroup()
                                                        .addComponent(jScrollPaneTotal, GroupLayout.PREFERRED_SIZE, 340, GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jButtonDeleteProduct))
                                                .addGroup(panelOrderLayout.createSequentialGroup()
                                                        .addComponent(jButtonCancel)
                                                        .addGap(31, 31, 31)
                                                        .addComponent(jButtonCancel1))))
                                .addContainerGap(26, Short.MAX_VALUE))
        );
        panelOrderLayout.setVerticalGroup(
                panelOrderLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelOrderLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(panelOrderLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextFieldAddProductChoose, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(quantitySelector, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelAddProduct1)
                                        .addComponent(jButtonAddProduct)
                                        .addComponent(jLabelAddProduct))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPaneOrderInformation, GroupLayout.PREFERRED_SIZE, 297, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(panelOrderLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(panelOrderLayout.createSequentialGroup()
                                                .addComponent(jScrollPaneTotal, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(panelOrderLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jButtonCancel)
                                                        .addComponent(jButtonCancel1))
                                                .addGap(51, 51, 51))
                                        .addGroup(panelOrderLayout.createSequentialGroup()
                                                .addComponent(jButtonDeleteProduct)
                                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(panelOrderInformation, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelOrder, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(panelOrderInformation, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panelOrder, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
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
            jTextFieldCustomerName.setText(complete);
            jTextFieldCustomerName.setCaretPosition(last);
            jTextFieldCustomerName.moveCaretPosition(start);
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
                    jTextFieldCustomerName.setText(jTextFieldCustomerName.getText());
                    break;
                default:
                    EventQueue.invokeLater(new Runnable(){
                        @Override

                        public void run(){
                            String txt = jTextFieldCustomerName.getText();
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
