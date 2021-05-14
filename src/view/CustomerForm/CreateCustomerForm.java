package view.CustomerForm;

import controller.ApplicationController;
import exception.ConnectionException;
import exception.CreateQueryException;
import exception.NullException;
import exception.SelectQueryException;
import model.Customer;
import javax.swing.*;
import java.awt.*;

public class CreateCustomerForm extends CustomerForm {
    private JButton jButtonResetCustomer,jButtonCreateCustomer;
    private Customer customer;

    public CreateCustomerForm(Color color,String title) throws SelectQueryException, ConnectionException {
        super(title,color);


        jButtonResetCustomer = new JButton("Reset");
        jButtonResetCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                jTextFieldFirstName.setText("");
                jTextFieldLastName.setText("");
                jTextFieldNickame.setText("");
                jTextFieldRegistrationDate.setText("");
                jTextFieldPhoneNumber.setText("");
                jTextFieldEmail.setText("");
                jTextFieldStreetWording.setText("");
                streetNumberSelector.setValue(0);
                jTextFieldBox.setText("");
                postalCodeSelector.setValue(0);
                jTextFieldVATNumber.setText("");
                jTextFieldIBAN.setText("");
                jTextFieldBIC.setText("");
                jTextFieldLocality.setText("");
                jTextFieldRegion.setText("");
                jComboBoxCountry.setSelectedIndex(0);
                jCheckBoxIsVIP.setSelected(false);
            }
        });
        jButtonResetCustomer.setFont(new Font("Tahoma", 0, 20));
        panelButton.add(jButtonResetCustomer);

        jButtonCreateCustomer = new JButton("Create");
        jButtonCreateCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                if (verification())
                {
                    customer = addCustomer();
                    System.out.println(customer);
                    ApplicationController applicationController = null;
                    try {
                        applicationController = new ApplicationController();
                    } catch (ConnectionException connectionException) {
                        JOptionPane.showMessageDialog(null,connectionException.getMessage(), connectionException.getTypeError(), JOptionPane.WARNING_MESSAGE);
                    }
                    try {
                        applicationController.addCustomer(customer);
                    } catch (CreateQueryException createQueryException) {
                        JOptionPane.showMessageDialog(null,createQueryException.getMessage(), createQueryException.getTypeError(), JOptionPane.WARNING_MESSAGE);
                    } catch (NullException nullException) {
                        JOptionPane.showMessageDialog(null,nullException.getMessage(), nullException.getTypeError(), JOptionPane.WARNING_MESSAGE);
                    }
                }

            }
        });
        jButtonCreateCustomer.setFont(new Font("Tahoma", 0, 20));
        panelButton.add(jButtonCreateCustomer);

    }
}
