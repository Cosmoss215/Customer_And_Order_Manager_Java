package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CreateOrder extends JFrame {

    private javax.swing.JButton jButtonAddProduct;
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonCancel1;
    private javax.swing.JButton jButtonDeleteProduct;
    private javax.swing.JComboBox<String> jComboBoxDeadline;
    private javax.swing.JComboBox<String> jComboBoxPaymentmethod;
    private javax.swing.JLabel jLabelAddProduct;
    private javax.swing.JLabel jLabelAddProduct1;
    private javax.swing.JLabel jLabelCreationDate;
    private javax.swing.JLabel jLabelCustomer;
    private javax.swing.JLabel jLabelDate;
    private javax.swing.JLabel jLabelDateOfTheDay;
    private javax.swing.JLabel jLabelNickname;
    private javax.swing.JLabel jLabelPaymentDealine;
    private javax.swing.JLabel jLabelPaymentDealine1;
    private javax.swing.JLabel jLabelPaymentMethod;
    private javax.swing.JScrollPane jScrollPaneOrderInformation;
    private javax.swing.JScrollPane jScrollPaneTotal;
    private javax.swing.JTable jTableOrderInformation;
    private javax.swing.JTable jTableTotal;
    private javax.swing.JTextField jTextFieldAddProductChoose;
    private javax.swing.JTextField jTextFieldCustomerName;
    private javax.swing.JTextField jTextFieldNickname;
    private javax.swing.JTextField jTextFieldQuantityChoose;
    private javax.swing.JPanel panelOrder;
    private javax.swing.JPanel panelOrderInformation;

    public CreateOrder()
    {
        panelOrderInformation = new javax.swing.JPanel();
        jLabelCustomer = new javax.swing.JLabel();
        jTextFieldCustomerName = new javax.swing.JTextField();
        jTextFieldNickname = new javax.swing.JTextField();
        jLabelPaymentMethod = new javax.swing.JLabel();
        jComboBoxPaymentmethod = new javax.swing.JComboBox<>();
        jLabelPaymentDealine = new javax.swing.JLabel();
        jComboBoxDeadline = new javax.swing.JComboBox<>();
        jLabelPaymentDealine1 = new javax.swing.JLabel();
        jLabelCreationDate = new javax.swing.JLabel();
        jLabelDate = new javax.swing.JLabel();
        jLabelDateOfTheDay = new javax.swing.JLabel();
        jLabelNickname = new javax.swing.JLabel();
        panelOrder = new javax.swing.JPanel();
        jScrollPaneOrderInformation = new javax.swing.JScrollPane();
        jTableOrderInformation = new javax.swing.JTable();
        jLabelAddProduct = new javax.swing.JLabel();
        jTextFieldAddProductChoose = new javax.swing.JTextField();
        jLabelAddProduct1 = new javax.swing.JLabel();
        jTextFieldQuantityChoose = new javax.swing.JTextField();
        jButtonAddProduct = new javax.swing.JButton();
        jScrollPaneTotal = new javax.swing.JScrollPane();
        jTableTotal = new javax.swing.JTable();
        jButtonDeleteProduct = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();
        jButtonCancel1 = new javax.swing.JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        jLabelCustomer.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelCustomer.setText("Customer");

        jTextFieldCustomerName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextFieldCustomerName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //jTextFieldCustomerNameActionPerformed(evt);
            }
        });

        jTextFieldNickname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextFieldNickname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //jTextFieldNicknameActionPerformed(evt);
            }
        });

        jLabelPaymentMethod.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelPaymentMethod.setText("Payment method");

        jComboBoxPaymentmethod.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBoxPaymentmethod.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Paypal", "transfer" }));

        jLabelPaymentDealine.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelPaymentDealine.setText("Payment deadline");

        jComboBoxDeadline.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBoxDeadline.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "8", "15", "30" }));

        jLabelPaymentDealine1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelPaymentDealine1.setText("days");

        jLabelCreationDate.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelCreationDate.setText("Creation date");

        jLabelDate.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabelDateOfTheDay.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelDateOfTheDay.setText("Date of the day");

        jLabelNickname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelNickname.setText("Nickname");

        javax.swing.GroupLayout panelOrderInformationLayout = new javax.swing.GroupLayout(panelOrderInformation);
        panelOrderInformation.setLayout(panelOrderInformationLayout);
        panelOrderInformationLayout.setHorizontalGroup(
                panelOrderInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelOrderInformationLayout.createSequentialGroup()
                                .addGroup(panelOrderInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelOrderInformationLayout.createSequentialGroup()
                                                .addGap(57, 57, 57)
                                                .addComponent(jLabelCreationDate)
                                                .addGap(18, 18, 18)
                                                .addGroup(panelOrderInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jLabelDate, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(panelOrderInformationLayout.createSequentialGroup()
                                                                .addGap(10, 10, 10)
                                                                .addComponent(jLabelDateOfTheDay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabelPaymentMethod)
                                                .addGap(38, 38, 38)
                                                .addComponent(jComboBoxPaymentmethod, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(53, 53, 53)
                                                .addComponent(jLabelPaymentDealine)
                                                .addGap(37, 37, 37)
                                                .addComponent(jComboBoxDeadline, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(36, 36, 36)
                                                .addComponent(jLabelPaymentDealine1))
                                        .addGroup(panelOrderInformationLayout.createSequentialGroup()
                                                .addGap(149, 149, 149)
                                                .addComponent(jLabelCustomer)
                                                .addGap(18, 18, 18)
                                                .addComponent(jTextFieldCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabelNickname)
                                                .addGap(18, 18, 18)
                                                .addComponent(jTextFieldNickname, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelOrderInformationLayout.setVerticalGroup(
                panelOrderInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelOrderInformationLayout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(panelOrderInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelCustomer)
                                        .addComponent(jTextFieldCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextFieldNickname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelNickname))
                                .addGap(18, 18, 18)
                                .addGroup(panelOrderInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelCreationDate)
                                        .addComponent(jLabelPaymentMethod)
                                        .addComponent(jComboBoxPaymentmethod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelPaymentDealine)
                                        .addComponent(jComboBoxDeadline, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelPaymentDealine1)
                                        .addComponent(jLabelDate)
                                        .addComponent(jLabelDateOfTheDay))
                                .addContainerGap(19, Short.MAX_VALUE))
        );

        panelOrder.setBackground(new java.awt.Color(0, 153, 153));

        jTableOrderInformation.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTableOrderInformation.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null}
                },
                new String [] {
                        "Product", "Quantity", "Unit Price", "Discount", "VAT", "Subtotal"
                }
        ) {
            Class[] types = new Class [] {
                    java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPaneOrderInformation.setViewportView(jTableOrderInformation);

        jLabelAddProduct.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelAddProduct.setForeground(new java.awt.Color(255, 255, 255));
        jLabelAddProduct.setText("Quantity");

        jTextFieldAddProductChoose.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextFieldAddProductChoose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //jTextFieldAddProductChooseActionPerformed(evt);
            }
        });

        jLabelAddProduct1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelAddProduct1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelAddProduct1.setText("Add product");

        jTextFieldQuantityChoose.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextFieldQuantityChoose.setText("0");
        jTextFieldQuantityChoose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //jTextFieldQuantityChooseActionPerformed(evt);
            }
        });

        jButtonAddProduct.setBackground(new java.awt.Color(0, 204, 51));
        jButtonAddProduct.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonAddProduct.setText("Add");

        jTableTotal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
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
            Class[] types = new Class [] {
                    java.lang.String.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPaneTotal.setViewportView(jTableTotal);

        jButtonDeleteProduct.setBackground(new java.awt.Color(255, 255, 0));
        jButtonDeleteProduct.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonDeleteProduct.setText("Delete product");

        jButtonCancel.setBackground(new java.awt.Color(0, 204, 0));
        jButtonCancel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonCancel.setText("Create order");

        jButtonCancel1.setBackground(new java.awt.Color(255, 0, 0));
        jButtonCancel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonCancel1.setText("Cancel");

        javax.swing.GroupLayout panelOrderLayout = new javax.swing.GroupLayout(panelOrder);
        panelOrder.setLayout(panelOrderLayout);
        panelOrderLayout.setHorizontalGroup(
                panelOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelOrderLayout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(panelOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPaneOrderInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 1042, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(panelOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(panelOrderLayout.createSequentialGroup()
                                                        .addComponent(jLabelAddProduct1)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jTextFieldAddProductChoose, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jLabelAddProduct)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jTextFieldQuantityChoose, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jButtonAddProduct)
                                                        .addGap(365, 365, 365))
                                                .addGroup(panelOrderLayout.createSequentialGroup()
                                                        .addComponent(jScrollPaneTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jButtonDeleteProduct))
                                                .addGroup(panelOrderLayout.createSequentialGroup()
                                                        .addComponent(jButtonCancel)
                                                        .addGap(31, 31, 31)
                                                        .addComponent(jButtonCancel1))))
                                .addContainerGap(26, Short.MAX_VALUE))
        );
        panelOrderLayout.setVerticalGroup(
                panelOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelOrderLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(panelOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextFieldAddProductChoose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextFieldQuantityChoose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelAddProduct1)
                                        .addComponent(jButtonAddProduct)
                                        .addComponent(jLabelAddProduct))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPaneOrderInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(panelOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelOrderLayout.createSequentialGroup()
                                                .addComponent(jScrollPaneTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(panelOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jButtonCancel)
                                                        .addComponent(jButtonCancel1))
                                                .addGap(51, 51, 51))
                                        .addGroup(panelOrderLayout.createSequentialGroup()
                                                .addComponent(jButtonDeleteProduct)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelOrderInformation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(panelOrderInformation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panelOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        pack();
    }
}
