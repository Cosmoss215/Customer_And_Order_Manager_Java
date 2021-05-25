package view.CustomerForm;

import controller.ApplicationController;
import exception.*;
import model.Customer;
import util.DateFormater;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

public class EditCustomerForm extends CustomerForm {

    private JButton jButtonCancelCustomer,jButtonEditCustomer;
    private Customer customer;
    public EditCustomerForm(Color color, String title, Customer customerFromView) throws SelectQueryException, ConnectionException {
        super(title,color);

        jButtonCancelCustomer = new JButton("Cancel");
        jButtonCancelCustomer.addActionListener(evt -> EditCustomerForm.super.dispose());
        jButtonCancelCustomer.setFont(new Font("Tahoma", 0, 20));
        panelButton.add(jButtonCancelCustomer);

        jButtonEditCustomer = new JButton("Edit");
        jButtonEditCustomer.setFont(new Font("Tahoma", 0, 20));
        panelButton.add(jButtonEditCustomer);


        jButtonEditCustomer.addActionListener(evt -> {
            boolean updateResult = false;
            int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to edit this customer ?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

            if (response == JOptionPane.YES_OPTION){
                if (isValidForm()) {
                    customer = addCustomer();
                    customer.setId(customerFromView.getId());
                    customer.getAddress().setId(customerFromView.getAddress().getId());
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
            }
            if (updateResult){
                JOptionPane.showMessageDialog(null,"The customer has been updated","Customer updated", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        jTextFieldFirstName.setText(customerFromView.getFirstName());
        jTextFieldLastName.setText(customerFromView.getLastName());

        if (customerFromView.getNickname() != null){
            jTextFieldNickame.setText(customerFromView.getNickname());
        }

        jTextFieldRegistrationDate.setText(DateFormater.toString(customerFromView.getRegistrationDate()));

        if (customerFromView.getPhoneNumber() != null){
            jTextFieldPhoneNumber.setText(String.valueOf(customerFromView.getPhoneNumber()));
        }

        if (customerFromView.getEmail() != null){
            jTextFieldEmail.setText(String.valueOf(customerFromView.getEmail()));
        }

        jTextFieldStreetWording.setText(customerFromView.getAddress().getStreetName());
        streetNumberSelector.setValue(customerFromView.getAddress().getStreetNumber());

        if (customerFromView.getAddress().getBox() != null){
            jTextFieldBox.setText(customerFromView.getAddress().getBox());
        }

        jTextFieldLocality.setText(String.valueOf(customerFromView.getAddress().getLocality().getName()));
        jTextFieldRegion.setText(customerFromView.getAddress().getLocality().getRegion());
        postalCodeSelector.setValue(customerFromView.getAddress().getLocality().getPostalCode());
        jTextFieldIBAN.setText(customerFromView.getIban());
        jTextFieldBIC.setText(customerFromView.getBic());

        if (customerFromView.getVatNumber() != null){
            jTextFieldVATNumber.setText(String.valueOf(customerFromView.getVatNumber()));
        }

        jCheckBoxIsVIP.setSelected(customerFromView.getVip());
    }
}
