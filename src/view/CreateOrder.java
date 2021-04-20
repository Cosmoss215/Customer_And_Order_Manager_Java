package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


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
    private final JLabel jLabelNickname;
    private final JLabel jLabelPaymentDealine;
    private final JLabel jLabelPaymentDealine1;
    private final JLabel jLabelPaymentMethod;
    private final JPanel jPanelOrder;
    private final JPanel jPanelOrderInformation;
    private final JScrollPane jScrollPane1;
    private final JScrollPane jScrollPane2;
    private final JTable jTable1;
    private final JTable jTable2;
    private final JTextField jTextFieldAddProductChoose;
    private final JTextField jTextFieldCustomerName;
    private final JTextField jTextFieldNickname;
    private final JTextField jTextFieldQuantityChoose;

    public CreateOrder()
    {
        jPanelOrderInformation = new JPanel();
        jLabelCustomer = new JLabel();
        jTextFieldCustomerName = new JTextField();
        jTextFieldNickname = new JTextField();
        jLabelPaymentMethod = new JLabel();
        jComboBoxPaymentmethod = new JComboBox<>();
        jLabelPaymentDealine = new JLabel();
        jComboBoxDeadline = new JComboBox<>();
        jLabelPaymentDealine1 = new JLabel();
        jLabelCreationDate = new JLabel();
        jLabelDate = new JLabel();
        jLabelDateOfTheDay = new JLabel();
        jLabelNickname = new JLabel();
        jPanelOrder = new JPanel();
        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();
        jLabelAddProduct = new JLabel();
        jTextFieldAddProductChoose = new JTextField();
        jLabelAddProduct1 = new JLabel();
        jTextFieldQuantityChoose = new JTextField();
        jButtonAddProduct = new JButton();
        jScrollPane2 = new JScrollPane();
        jTable2 = new JTable();
        jButtonDeleteProduct = new JButton();
        jButtonCancel = new JButton();
        jButtonCancel1 = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        jLabelCustomer.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        jLabelCustomer.setText("Customer");

        jTextFieldCustomerName.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        jTextFieldCustomerName.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //jTextFieldCustomerNameActionPerformed(evt);
            }
        });

        jTextFieldNickname.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        jTextFieldNickname.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //jTextFieldNicknameActionPerformed(evt);
            }
        });

        jLabelPaymentMethod.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        jLabelPaymentMethod.setText("Payment method");

        jComboBoxPaymentmethod.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        jComboBoxPaymentmethod.setModel(new DefaultComboBoxModel<>(new String[] { "Paypal", "transfer" }));

        jLabelPaymentDealine.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        jLabelPaymentDealine.setText("Payment deadline");

        jComboBoxDeadline.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        jComboBoxDeadline.setModel(new DefaultComboBoxModel<>(new String[] { "8", "15", "30" }));

        jLabelPaymentDealine1.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        jLabelPaymentDealine1.setText("days");

        jLabelCreationDate.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        jLabelCreationDate.setText("Creation date");

        jLabelDate.setFont(new Font("Tahoma", 0, 18)); // NOI18N

        jLabelDateOfTheDay.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        jLabelDateOfTheDay.setText("Date of the day");

        jLabelNickname.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        jLabelNickname.setText("Nickname");

        GroupLayout jPanelOrderInformationLayout = new GroupLayout(jPanelOrderInformation);
        jPanelOrderInformation.setLayout(jPanelOrderInformationLayout);
        jPanelOrderInformationLayout.setHorizontalGroup(
                jPanelOrderInformationLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelOrderInformationLayout.createSequentialGroup()
                                .addGroup(jPanelOrderInformationLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanelOrderInformationLayout.createSequentialGroup()
                                                .addGap(57, 57, 57)
                                                .addComponent(jLabelCreationDate)
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanelOrderInformationLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jLabelDate, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanelOrderInformationLayout.createSequentialGroup()
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
                                        .addGroup(jPanelOrderInformationLayout.createSequentialGroup()
                                                .addGap(149, 149, 149)
                                                .addComponent(jLabelCustomer)
                                                .addGap(18, 18, 18)
                                                .addComponent(jTextFieldCustomerName, GroupLayout.PREFERRED_SIZE, 392, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabelNickname)
                                                .addGap(18, 18, 18)
                                                .addComponent(jTextFieldNickname, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelOrderInformationLayout.setVerticalGroup(
                jPanelOrderInformationLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelOrderInformationLayout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(jPanelOrderInformationLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelCustomer)
                                        .addComponent(jTextFieldCustomerName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextFieldNickname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelNickname))
                                .addGap(18, 18, 18)
                                .addGroup(jPanelOrderInformationLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
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

        jPanelOrder.setBackground(new Color(0, 153, 153));

        jTable1.setFont(new Font("Tahoma", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
            final Class[] types = new Class [] {
                    java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabelAddProduct.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        jLabelAddProduct.setForeground(new Color(255, 255, 255));
        jLabelAddProduct.setText("Quantity");

        jTextFieldAddProductChoose.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        jTextFieldAddProductChoose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //jTextFieldAddProductChooseActionPerformed(evt);
            }
        });

        jLabelAddProduct1.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        jLabelAddProduct1.setForeground(new Color(255, 255, 255));
        jLabelAddProduct1.setText("Add product");

        jTextFieldQuantityChoose.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        jTextFieldQuantityChoose.setText("0");
        jTextFieldQuantityChoose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //jTextFieldQuantityChooseActionPerformed(evt);
            }
        });

        jButtonAddProduct.setBackground(new Color(0, 204, 51));
        jButtonAddProduct.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        jButtonAddProduct.setText("Add");

        jTable2.setFont(new Font("Tahoma", 0, 12)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        jButtonDeleteProduct.setBackground(new Color(255, 255, 0));
        jButtonDeleteProduct.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        jButtonDeleteProduct.setText("Delete product");

        jButtonCancel.setBackground(new Color(0, 204, 0));
        jButtonCancel.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        jButtonCancel.setText("Create order");

        jButtonCancel1.setBackground(new Color(255, 0, 0));
        jButtonCancel1.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        jButtonCancel1.setText("Cancel");

        GroupLayout jPanelOrderLayout = new GroupLayout(jPanelOrder);
        jPanelOrder.setLayout(jPanelOrderLayout);
        jPanelOrderLayout.setHorizontalGroup(
                jPanelOrderLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelOrderLayout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(jPanelOrderLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 1042, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanelOrderLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(jPanelOrderLayout.createSequentialGroup()
                                                        .addComponent(jLabelAddProduct1)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jTextFieldAddProductChoose, GroupLayout.PREFERRED_SIZE, 334, GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jLabelAddProduct)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jTextFieldQuantityChoose, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jButtonAddProduct)
                                                        .addGap(365, 365, 365))
                                                .addGroup(jPanelOrderLayout.createSequentialGroup()
                                                        .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 340, GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jButtonDeleteProduct))
                                                .addGroup(jPanelOrderLayout.createSequentialGroup()
                                                        .addComponent(jButtonCancel)
                                                        .addGap(31, 31, 31)
                                                        .addComponent(jButtonCancel1))))
                                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanelOrderLayout.setVerticalGroup(
                jPanelOrderLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelOrderLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(jPanelOrderLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextFieldAddProductChoose, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextFieldQuantityChoose, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelAddProduct1)
                                        .addComponent(jButtonAddProduct)
                                        .addComponent(jLabelAddProduct))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 297, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanelOrderLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanelOrderLayout.createSequentialGroup()
                                                .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(jPanelOrderLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jButtonCancel)
                                                        .addComponent(jButtonCancel1))
                                                .addGap(51, 51, 51))
                                        .addGroup(jPanelOrderLayout.createSequentialGroup()
                                                .addComponent(jButtonDeleteProduct)
                                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanelOrderInformation, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanelOrder, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanelOrderInformation, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanelOrder, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        pack();
    }
}
