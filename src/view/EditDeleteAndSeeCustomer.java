package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class EditDeleteAndSeeCustomer extends JFrame {

    private final JButton jButtonDeleteCustomer;
    private final JButton jButtonEditCustomer;
    private final JCheckBox jCheckBoxIsVIP;
    private final JLabel jLabel2;
    private final JLabel jLabelAddressNumber;
    private final JLabel jLabelBIC;
    private final JLabel jLabelCustomerInformation1;
    private final JLabel jLabelFirstName1;
    private final JLabel jLabelIBAN;
    private final JLabel jLabelIsVIP;
    private final JLabel jLabelLocality;
    private final JLabel jLabelPhoneNumber;
    private final JLabel jLabelPostalCode;
    private final JLabel jLabelRegistrationDate;
    private final JLabel jLabelStreetWording;
    private final JLabel jLabelVATNumber;
    private final JPanel jPanel2;
    private final JTextField jTextFieldAddressNumber;
    private final JTextField jTextFieldBIC;
    private final JTextField jTextFieldFirstName1;
    private final JTextField jTextFieldIBAN;
    private final JTextField jTextFieldLastName;
    private final JTextField jTextFieldLocality;
    private final JTextField jTextFieldPhoneNumber;
    private final JTextField jTextFieldPostalCode;
    private final JTextField jTextFieldRegistrationDate;
    private final JTextField jTextFieldStreetWording;
    private final JTextField jTextFieldVATNumber;
    public EditDeleteAndSeeCustomer(){
        jPanel2 = new JPanel();
        jLabelCustomerInformation1 = new JLabel();
        jLabelFirstName1 = new JLabel();
        jTextFieldFirstName1 = new JTextField();
        jLabel2 = new JLabel();
        jTextFieldLastName = new JTextField();
        jLabelRegistrationDate = new JLabel();
        jTextFieldRegistrationDate = new JTextField();
        jLabelPhoneNumber = new JLabel();
        jTextFieldPhoneNumber = new JTextField();
        jLabelAddressNumber = new JLabel();
        jTextFieldStreetWording = new JTextField();
        jLabelStreetWording = new JLabel();
        jLabelLocality = new JLabel();
        jTextFieldAddressNumber = new JTextField();
        jLabelPostalCode = new JLabel();
        jLabelVATNumber = new JLabel();
        jLabelIBAN = new JLabel();
        jLabelBIC = new JLabel();
        jLabelIsVIP = new JLabel();
        jTextFieldLocality = new JTextField();
        jTextFieldPostalCode = new JTextField();
        jTextFieldVATNumber = new JTextField();
        jTextFieldIBAN = new JTextField();
        jTextFieldBIC = new JTextField();
        jCheckBoxIsVIP = new JCheckBox();
        jButtonEditCustomer = new JButton();
        jButtonDeleteCustomer = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setPreferredSize(new Dimension(660, 650));

        jLabelCustomerInformation1.setFont(new Font("Tahoma", 1, 18)); // NOI18N
        jLabelCustomerInformation1.setText("Customer information");

        jLabelFirstName1.setFont(new Font("Tahoma", 0, 16)); // NOI18N
        jLabelFirstName1.setText("Frist Name");

        jTextFieldFirstName1.setFont(new Font("Tahoma", 0, 16)); // NOI18N
        jTextFieldFirstName1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //jTextFieldFirstName1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setText("Last Name");

        jTextFieldLastName.setFont(new Font("Tahoma", 0, 16)); // NOI18N
        jTextFieldLastName.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //jTextFieldLastNameActionPerformed(evt);
            }
        });

        jLabelRegistrationDate.setFont(new Font("Tahoma", 0, 16)); // NOI18N
        jLabelRegistrationDate.setText("Registration Date");

        jTextFieldRegistrationDate.setFont(new Font("Tahoma", 0, 16)); // NOI18N
        jTextFieldRegistrationDate.setText(".. / .. / ..");
        jTextFieldRegistrationDate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //jTextFieldRegistrationDateActionPerformed(evt);
            }
        });

        jLabelPhoneNumber.setFont(new Font("Tahoma", 0, 16)); // NOI18N
        jLabelPhoneNumber.setText("Phone Number");

        jTextFieldPhoneNumber.setFont(new Font("Tahoma", 0, 16)); // NOI18N
        jTextFieldPhoneNumber.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //jTextFieldPhoneNumberActionPerformed(evt);
            }
        });

        jLabelAddressNumber.setFont(new Font("Tahoma", 0, 16)); // NOI18N
        jLabelAddressNumber.setText("Address Number");

        jTextFieldStreetWording.setFont(new Font("Tahoma", 0, 16)); // NOI18N
        jTextFieldStreetWording.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //jTextFieldStreetWordingActionPerformed(evt);
            }
        });

        jLabelStreetWording.setFont(new Font("Tahoma", 0, 16)); // NOI18N
        jLabelStreetWording.setText("Street Wording");

        jLabelLocality.setFont(new Font("Tahoma", 0, 16)); // NOI18N
        jLabelLocality.setText("Locality");

        jTextFieldAddressNumber.setFont(new Font("Tahoma", 0, 16)); // NOI18N
        jTextFieldAddressNumber.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //jTextFieldAddressNumberActionPerformed(evt);
            }
        });

        jLabelPostalCode.setFont(new Font("Tahoma", 0, 16)); // NOI18N
        jLabelPostalCode.setText("Postal Code");

        jLabelVATNumber.setFont(new Font("Tahoma", 0, 16)); // NOI18N
        jLabelVATNumber.setText("VAT Number");

        jLabelIBAN.setFont(new Font("Tahoma", 0, 16)); // NOI18N
        jLabelIBAN.setText("IBAN");

        jLabelBIC.setFont(new Font("Tahoma", 0, 16)); // NOI18N
        jLabelBIC.setText("BIC");

        jLabelIsVIP.setFont(new Font("Tahoma", 0, 16)); // NOI18N
        jLabelIsVIP.setText("Is VIP");

        jTextFieldLocality.setFont(new Font("Tahoma", 0, 16)); // NOI18N
        jTextFieldLocality.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //jTextFieldLocalityActionPerformed(evt);
            }
        });

        jTextFieldPostalCode.setFont(new Font("Tahoma", 0, 16)); // NOI18N
        jTextFieldPostalCode.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //jTextFieldPostalCodeActionPerformed(evt);
            }
        });

        jTextFieldVATNumber.setFont(new Font("Tahoma", 0, 16)); // NOI18N
        jTextFieldVATNumber.setText("N/A");
        jTextFieldVATNumber.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //jTextFieldVATNumberActionPerformed(evt);
            }
        });

        jTextFieldIBAN.setFont(new Font("Tahoma", 0, 16)); // NOI18N
        jTextFieldIBAN.setText("BE");
        jTextFieldIBAN.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //jTextFieldIBANActionPerformed(evt);
            }
        });

        jTextFieldBIC.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTextFieldBIC.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //jTextFieldBICActionPerformed(evt);
            }
        });

        jCheckBoxIsVIP.setFont(new Font("Tahoma", 0, 18)); // NOI18N

        jButtonEditCustomer.setBackground(new Color(255, 255, 255));
        jButtonEditCustomer.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonEditCustomer.setText("Edit");

        jButtonDeleteCustomer.setBackground(new Color(255, 255, 255));
        jButtonDeleteCustomer.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        jButtonDeleteCustomer.setText("Delete");

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabelCustomerInformation1))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(66, 66, 66)
                                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabelFirstName1)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabelRegistrationDate)
                                                        .addComponent(jLabelPhoneNumber)
                                                        .addComponent(jLabelAddressNumber)
                                                        .addComponent(jLabelStreetWording)
                                                        .addComponent(jLabelLocality)
                                                        .addComponent(jLabelPostalCode)
                                                        .addComponent(jLabelVATNumber)
                                                        .addComponent(jLabelIBAN)
                                                        .addComponent(jLabelBIC)
                                                        .addComponent(jLabelIsVIP))
                                                .addGap(65, 65, 65)
                                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jTextFieldLastName, GroupLayout.PREFERRED_SIZE, 380, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextFieldRegistrationDate, GroupLayout.PREFERRED_SIZE, 380, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextFieldPhoneNumber, GroupLayout.PREFERRED_SIZE, 380, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextFieldStreetWording, GroupLayout.PREFERRED_SIZE, 380, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextFieldAddressNumber, GroupLayout.PREFERRED_SIZE, 380, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextFieldLocality, GroupLayout.PREFERRED_SIZE, 380, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextFieldPostalCode, GroupLayout.PREFERRED_SIZE, 380, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextFieldVATNumber, GroupLayout.PREFERRED_SIZE, 380, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextFieldIBAN, GroupLayout.PREFERRED_SIZE, 380, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextFieldBIC, GroupLayout.PREFERRED_SIZE, 380, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jCheckBoxIsVIP)
                                                        .addComponent(jTextFieldFirstName1, GroupLayout.PREFERRED_SIZE, 380, GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(20, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButtonEditCustomer)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonDeleteCustomer)
                                .addGap(20, 20, 20))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelCustomerInformation1)
                                .addGap(32, 32, 32)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelFirstName1)
                                        .addComponent(jTextFieldFirstName1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jTextFieldLastName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelRegistrationDate)
                                        .addComponent(jTextFieldRegistrationDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelPhoneNumber)
                                        .addComponent(jTextFieldPhoneNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextFieldStreetWording, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelStreetWording))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelAddressNumber)
                                        .addComponent(jTextFieldAddressNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelLocality)
                                        .addComponent(jTextFieldLocality, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelPostalCode)
                                        .addComponent(jTextFieldPostalCode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelVATNumber)
                                        .addComponent(jTextFieldVATNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelIBAN)
                                        .addComponent(jTextFieldIBAN, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelBIC)
                                        .addComponent(jTextFieldBIC, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jCheckBoxIsVIP)
                                        .addComponent(jLabelIsVIP))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButtonEditCustomer, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButtonDeleteCustomer, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
                                .addGap(19, 19, 19))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 652, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 665, GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }
}
