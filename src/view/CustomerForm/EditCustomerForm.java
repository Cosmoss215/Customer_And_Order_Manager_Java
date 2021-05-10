package view.CustomerForm;

import model.Customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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
        jButtonEditCustomer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                verification();
            }
        });


        SimpleDateFormat fmt = new SimpleDateFormat("dd-MM-yyyy");
        fmt.setCalendar(customer.getRegistrationDate());
        String dateFormatted = fmt.format(customer.getRegistrationDate().getTime());
        System.out.println(dateFormatted);


        jTextFieldFirstName.setText(customer.getFirstName());
        jTextFieldLastName.setText(customer.getLastName());
        jTextFieldNickame.setText(customer.getNickname());
        jTextFieldRegistrationDate.setText(dateFormatted);
        jTextFieldPhoneNumber.setText(String.valueOf(customer.getPhoneNumber()));
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
