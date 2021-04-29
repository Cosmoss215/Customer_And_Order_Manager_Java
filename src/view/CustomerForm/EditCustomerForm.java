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






    }
}
