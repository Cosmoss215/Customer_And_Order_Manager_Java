package view.CustomerForm;

import model.Customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class EditCustomerForm extends CustomerForm {

    private JButton jButtonCancelCustomer,jButtonEditCustomer;
    public EditCustomerForm(Color color, String title,Customer customer){
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


        jTextFieldFirstName.setText(customer.getFirstName());
        jTextFieldLastName.setText(customer.getLastName());
        //RegistrationDate
        jTextFieldPhoneNumber.setText(String.valueOf(customer.getPhoneNumber()));
        jTextFieldAddressNumber.setText(String.valueOf(customer.getAddress().getStreetNumber()));
        jTextFieldStreetWording.setText(customer.getAddress().getStreetName());
        jTextFieldLocality.setText(String.valueOf(customer.getAddress().getLocality()));
        jTextFieldPostalCode.setText(String.valueOf(customer.getAddress().getLocality().getPostalCode()));
        jTextFieldIBAN.setText(customer.getIban());
        jTextFieldBIC.setText(customer.getBic());
        jTextFieldVATNumber.setText(String.valueOf(customer.getVatNumber()));
        jCheckBoxIsVIP.setSelected(customer.getVip());
    }
}
