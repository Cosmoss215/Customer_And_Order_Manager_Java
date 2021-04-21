package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class UpdateReadDeleteCustomer extends JFrame {

    private javax.swing.JButton jButtonDeleteCustomer;
    private javax.swing.JButton jButtonUpdateCustomer;
    private javax.swing.JCheckBox jCheckBoxIsVIP;
    private javax.swing.JLabel jLabelAddressNumber;
    private javax.swing.JLabel jLabelBIC;
    private javax.swing.JLabel jLabelCustomerInformation;
    private javax.swing.JLabel jLabelFirstName;
    private javax.swing.JLabel jLabelIBAN;
    private javax.swing.JLabel jLabelIsVIP;
    private javax.swing.JLabel jLabelLastName;
    private javax.swing.JLabel jLabelLocality;
    private javax.swing.JLabel jLabelPhoneNumber;
    private javax.swing.JLabel jLabelPostalCode;
    private javax.swing.JLabel jLabelRegistrationDate;
    private javax.swing.JLabel jLabelStreetWording;
    private javax.swing.JLabel jLabelVATNumber;
    private javax.swing.JTextField jTextFieldAddressNumber;
    private javax.swing.JTextField jTextFieldBIC;
    private javax.swing.JTextField jTextFieldFirstName;
    private javax.swing.JTextField jTextFieldIBAN;
    private javax.swing.JTextField jTextFieldLastName;
    private javax.swing.JTextField jTextFieldLocality;
    private javax.swing.JTextField jTextFieldPhoneNumber;
    private javax.swing.JTextField jTextFieldPostalCode;
    private javax.swing.JTextField jTextFieldRegistrationDate;
    private javax.swing.JTextField jTextFieldStreetWording;
    private javax.swing.JTextField jTextFieldVATNumber;
    private javax.swing.JPanel panelButton;
    private javax.swing.JPanel panelForm;
    public UpdateReadDeleteCustomer(){
        panelForm = new javax.swing.JPanel();
        jLabelCustomerInformation = new javax.swing.JLabel();
        jLabelFirstName = new javax.swing.JLabel();
        jTextFieldFirstName = new javax.swing.JTextField();
        jLabelLastName = new javax.swing.JLabel();
        jTextFieldLastName = new javax.swing.JTextField();
        jLabelRegistrationDate = new javax.swing.JLabel();
        jTextFieldRegistrationDate = new javax.swing.JTextField();
        jLabelPhoneNumber = new javax.swing.JLabel();
        jTextFieldPhoneNumber = new javax.swing.JTextField();
        jLabelAddressNumber = new javax.swing.JLabel();
        jTextFieldStreetWording = new javax.swing.JTextField();
        jLabelStreetWording = new javax.swing.JLabel();
        jLabelLocality = new javax.swing.JLabel();
        jTextFieldAddressNumber = new javax.swing.JTextField();
        jLabelPostalCode = new javax.swing.JLabel();
        jLabelVATNumber = new javax.swing.JLabel();
        jLabelIBAN = new javax.swing.JLabel();
        jLabelBIC = new javax.swing.JLabel();
        jLabelIsVIP = new javax.swing.JLabel();
        jTextFieldLocality = new javax.swing.JTextField();
        jTextFieldPostalCode = new javax.swing.JTextField();
        jTextFieldVATNumber = new javax.swing.JTextField();
        jTextFieldIBAN = new javax.swing.JTextField();
        jTextFieldBIC = new javax.swing.JTextField();
        jCheckBoxIsVIP = new javax.swing.JCheckBox();
        panelButton = new javax.swing.JPanel();
        jButtonUpdateCustomer = new javax.swing.JButton();
        jButtonDeleteCustomer = new javax.swing.JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        panelForm.setPreferredSize(new java.awt.Dimension(660, 650));

        jLabelCustomerInformation.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelCustomerInformation.setText("Customer information");

        jLabelFirstName.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabelFirstName.setText("Frist Name");

        jTextFieldFirstName.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTextFieldFirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //jTextFieldFirstNameActionPerformed(evt);
            }
        });

        jLabelLastName.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabelLastName.setText("Last Name");

        jTextFieldLastName.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTextFieldLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //jTextFieldLastNameActionPerformed(evt);
            }
        });

        jLabelRegistrationDate.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabelRegistrationDate.setText("Registration Date");

        jTextFieldRegistrationDate.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTextFieldRegistrationDate.setText(".. / .. / ..");
        jTextFieldRegistrationDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //jTextFieldRegistrationDateActionPerformed(evt);
            }
        });

        jLabelPhoneNumber.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabelPhoneNumber.setText("Phone Number");

        jTextFieldPhoneNumber.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTextFieldPhoneNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //jTextFieldPhoneNumberActionPerformed(evt);
            }
        });

        jLabelAddressNumber.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabelAddressNumber.setText("Address Number");

        jTextFieldStreetWording.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTextFieldStreetWording.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //jTextFieldStreetWordingActionPerformed(evt);
            }
        });

        jLabelStreetWording.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabelStreetWording.setText("Street Wording");

        jLabelLocality.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabelLocality.setText("Locality");

        jTextFieldAddressNumber.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTextFieldAddressNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //jTextFieldAddressNumberActionPerformed(evt);
            }
        });

        jLabelPostalCode.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabelPostalCode.setText("Postal Code");

        jLabelVATNumber.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabelVATNumber.setText("VAT Number");

        jLabelIBAN.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabelIBAN.setText("IBAN");

        jLabelBIC.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabelBIC.setText("BIC");

        jLabelIsVIP.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabelIsVIP.setText("Is VIP");

        jTextFieldLocality.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTextFieldLocality.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //jTextFieldLocalityActionPerformed(evt);
            }
        });

        jTextFieldPostalCode.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTextFieldPostalCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //jTextFieldPostalCodeActionPerformed(evt);
            }
        });

        jTextFieldVATNumber.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTextFieldVATNumber.setText("N/A");
        jTextFieldVATNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //jTextFieldVATNumberActionPerformed(evt);
            }
        });

        jTextFieldIBAN.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTextFieldIBAN.setText("BE");
        jTextFieldIBAN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //jTextFieldIBANActionPerformed(evt);
            }
        });

        jTextFieldBIC.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTextFieldBIC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //jTextFieldBICActionPerformed(evt);
            }
        });

        jCheckBoxIsVIP.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout panelFormLayout = new javax.swing.GroupLayout(panelForm);
        panelForm.setLayout(panelFormLayout);
        panelFormLayout.setHorizontalGroup(
                panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelFormLayout.createSequentialGroup()
                                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelFormLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabelCustomerInformation))
                                        .addGroup(panelFormLayout.createSequentialGroup()
                                                .addGap(66, 66, 66)
                                                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabelFirstName)
                                                        .addComponent(jLabelLastName)
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
                                                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jTextFieldLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextFieldRegistrationDate, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextFieldPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextFieldStreetWording, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextFieldAddressNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextFieldLocality, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextFieldPostalCode, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextFieldVATNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextFieldIBAN, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextFieldBIC, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jCheckBoxIsVIP)
                                                        .addComponent(jTextFieldFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(40, Short.MAX_VALUE))
        );
        panelFormLayout.setVerticalGroup(
                panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelFormLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelCustomerInformation)
                                .addGap(32, 32, 32)
                                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelFirstName)
                                        .addComponent(jTextFieldFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelLastName)
                                        .addComponent(jTextFieldLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelRegistrationDate)
                                        .addComponent(jTextFieldRegistrationDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelPhoneNumber)
                                        .addComponent(jTextFieldPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextFieldStreetWording, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelStreetWording))
                                .addGap(18, 18, 18)
                                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelAddressNumber)
                                        .addComponent(jTextFieldAddressNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelLocality)
                                        .addComponent(jTextFieldLocality, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelPostalCode)
                                        .addComponent(jTextFieldPostalCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelVATNumber)
                                        .addComponent(jTextFieldVATNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelIBAN)
                                        .addComponent(jTextFieldIBAN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelBIC)
                                        .addComponent(jTextFieldBIC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jCheckBoxIsVIP)
                                        .addComponent(jLabelIsVIP))
                                .addContainerGap(25, Short.MAX_VALUE))
        );

        jButtonUpdateCustomer.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonUpdateCustomer.setText("Update");

        jButtonDeleteCustomer.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonDeleteCustomer.setText("Delete");

        javax.swing.GroupLayout panelButtonLayout = new javax.swing.GroupLayout(panelButton);
        panelButton.setLayout(panelButtonLayout);
        panelButtonLayout.setHorizontalGroup(
                panelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelButtonLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonUpdateCustomer)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonDeleteCustomer)
                                .addGap(23, 23, 23))
        );
        panelButtonLayout.setVerticalGroup(
                panelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelButtonLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButtonUpdateCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButtonDeleteCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelForm, javax.swing.GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(panelForm, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }
}
