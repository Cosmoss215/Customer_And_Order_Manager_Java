package view.CustomerForm;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class CreateCustomerForm extends CustomerForm {
    private JButton jButtonResetCustomer,jButtonCreateCustomer;

    public CreateCustomerForm(Color color,String title){
        super(title,color);


        jButtonResetCustomer = new JButton();
        jButtonResetCustomer.setText("Reset");
        jButtonResetCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //Reset des données
            }
        });
        jButtonResetCustomer.setFont(new Font("Tahoma", 0, 20));
        panelButton.add(jButtonResetCustomer);

        jButtonCreateCustomer = new JButton();
        jButtonCreateCustomer.setText("Create");
        jButtonCreateCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //Ajout du client dans la base de donnée
            }
        });
        jButtonCreateCustomer.setFont(new Font("Tahoma", 0, 20));
        panelButton.add(jButtonCreateCustomer);

    }
}
