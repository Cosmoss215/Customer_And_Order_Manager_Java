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
            if (updateResult){
                JOptionPane.showMessageDialog(null,"The customer has been updated","Customer updated", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Pourquoi ne pas placer dans DateFormater ?
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        format.setCalendar(customerFromView.getRegistrationDate());
        String dateFormatted = format.format(customerFromView.getRegistrationDate().getTime());

        jTextFieldFirstName.setText(customerFromView.getFirstName());
        jTextFieldLastName.setText(customerFromView.getLastName());
        jTextFieldNickame.setText(customerFromView.getNickname());
        jTextFieldRegistrationDate.setText(dateFormatted);
        if (customerFromView.getPhoneNumber() != null){
            jTextFieldPhoneNumber.setText("0" +customerFromView.getPhoneNumber());
        }
        jTextFieldEmail.setText(String.valueOf(customerFromView.getEmail()));
        jTextFieldStreetWording.setText(customerFromView.getAddress().getStreetName());
        streetNumberSelector.setValue(customerFromView.getAddress().getStreetNumber());
        jTextFieldBox.setText(customerFromView.getAddress().getBox());
        jTextFieldLocality.setText(String.valueOf(customerFromView.getAddress().getLocality().getName()));
        jTextFieldRegion.setText(customerFromView.getAddress().getLocality().getRegion());
        postalCodeSelector.setValue(customerFromView.getAddress().getLocality().getPostalCode());
        jTextFieldIBAN.setText(customerFromView.getIban());
        jTextFieldBIC.setText(customerFromView.getBic());
        jTextFieldVATNumber.setText(String.valueOf(customerFromView.getVatNumber()));
        jCheckBoxIsVIP.setSelected(customerFromView.getVip());
    }
}
