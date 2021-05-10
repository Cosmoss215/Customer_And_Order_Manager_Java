package view.CustomerForm;

import controller.ApplicationController;
import exception.ConnectionException;
import exception.CreateQueryException;
import exception.NullException;
import model.Address;
import model.Customer;
import model.Locality;
import util.Verification;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.GregorianCalendar;

import static java.awt.Color.*;

public class CreateCustomerForm extends CustomerForm {
    private JButton jButtonResetCustomer,jButtonCreateCustomer;
    private Customer customer;
    private Locality locality;
    private Address address;

    public CreateCustomerForm(Color color,String title){
        super(title,color);

        jButtonResetCustomer = new JButton("Reset");
        jButtonResetCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                jTextFieldFirstName.setText("");
                jTextFieldLastName.setText("");
                jTextFieldNickame.setText("");
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
                jCheckBoxIsVIP.setSelected(false);
            }
        });
        jButtonResetCustomer.setFont(new Font("Tahoma", 0, 20));
        panelButton.add(jButtonResetCustomer);

        jButtonCreateCustomer = new JButton("Create");
        jButtonCreateCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                customer = new Customer();
                address = new Address();
                locality = new Locality();

                customer.setAddress(address);
                if (verification())
                {
                    customer.setFirstName(jTextFieldFirstName.getText());

                    customer.setLastName(jTextFieldLastName.getText());

                    customer.setNickname(jTextFieldNickame.getText());

                    customer.setPhoneNumber(Integer.valueOf(jTextFieldPhoneNumber.getText()));

                    customer.setEmail(jTextFieldEmail.getText());

                    customer.setIban(jTextFieldIBAN.getText());

                    customer.setBic(jTextFieldBIC.getText());

                    locality.setName(jTextFieldLocality.getText());

                    locality.setPostalCode((Integer) postalCodeSelector.getValue());

                    customer.getAddress().setBox(jTextFieldBox.getText());

                    customer.getAddress().setLocality(locality);

                    customer.getAddress().setStreetName(jTextFieldStreetWording.getText());

                    customer.getAddress().setStreetNumber((Integer) streetNumberSelector.getValue());

                    customer.setVatNumber(Integer.valueOf(jTextFieldVATNumber.getText()));
                }

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
        });
        jButtonCreateCustomer.setFont(new Font("Tahoma", 0, 20));
        panelButton.add(jButtonCreateCustomer);

    }
}
