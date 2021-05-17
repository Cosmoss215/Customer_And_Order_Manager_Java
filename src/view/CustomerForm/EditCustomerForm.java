package view.CustomerForm;

import controller.ApplicationController;
import exception.*;
import model.Customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

public class EditCustomerForm extends CustomerForm {

    private JButton jButtonCancelCustomer,jButtonEditCustomer;
    private Customer customer2;
    public EditCustomerForm(Color color, String title, Customer customer) throws SelectQueryException, ConnectionException {
        super(title,color);

        jButtonCancelCustomer = new JButton("Cancel");
        jButtonCancelCustomer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                EditCustomerForm.super.dispose();
            }
        });
        jButtonCancelCustomer.setFont(new Font("Tahoma", 0, 20));
        panelButton.add(jButtonCancelCustomer);

        jButtonEditCustomer = new JButton("Edit");
        jButtonEditCustomer.setFont(new Font("Tahoma", 0, 20));
        panelButton.add(jButtonEditCustomer);

        customer2 = customer;

        jButtonEditCustomer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                boolean updateResult = false;
                if (isValidForm()) {
                    customer2 = addCustomer();
                    System.out.println("ici EditCustomerForm (ligne 40)"+customer2);
                    try {
                        ApplicationController applicationController = new ApplicationController();
                        updateResult = applicationController.update(customer);
                    } catch (ConnectionException connectionException) {
                        JOptionPane.showMessageDialog(null,connectionException.getMessage(), connectionException.getTypeError(), JOptionPane.WARNING_MESSAGE);
                    } catch (UpdateQueryException createQueryException) {
                        JOptionPane.showMessageDialog(null,createQueryException.getMessage(), createQueryException.getTypeError(), JOptionPane.WARNING_MESSAGE);
                    } catch (NullException nullException) {
                        JOptionPane.showMessageDialog(null,nullException.getMessage(), nullException.getTypeError(), JOptionPane.WARNING_MESSAGE);
                    }
                }
                if (updateResult){
                    JOptionPane.showMessageDialog(null,"The customer has been updated","Customer updated", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        // Pourquoi ne pas placer dans DateFormater ?
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        format.setCalendar(customer.getRegistrationDate());
        String dateFormatted = format.format(customer.getRegistrationDate().getTime());

        jTextFieldFirstName.setText(customer.getFirstName());
        jTextFieldLastName.setText(customer.getLastName());
        jTextFieldNickame.setText(customer.getNickname());
        jTextFieldRegistrationDate.setText(dateFormatted);

        if (customer.getPhoneNumber() != null){
            jTextFieldPhoneNumber.setText(String.valueOf(customer.getPhoneNumber()));
        }
        jTextFieldEmail.setText(String.valueOf(customer.getEmail()));
        jTextFieldStreetWording.setText(customer.getAddress().getStreetName());
        streetNumberSelector.setValue(customer.getAddress().getStreetNumber());
        jTextFieldBox.setText(customer.getAddress().getBox());
        jTextFieldLocality.setText(String.valueOf(customer.getAddress().getLocality()));
        postalCodeSelector.setValue(customer.getAddress().getLocality().getPostalCode());
        jTextFieldIBAN.setText(customer.getIban());
        jTextFieldBIC.setText(customer.getBic());
        jTextFieldVATNumber.setText(String.valueOf(customer.getVatNumber()));
        jCheckBoxIsVIP.setSelected(customer.getVip());
    }
}
