package view.CustomerForm;

import javax.swing.*;
import java.awt.*;

public class CustomerForm extends JFrame {
    private Container mainContainer;
    public JButton jButtonResetCustomer,jButtonCreateCustomer;
    public JCheckBox jCheckBoxIsVIP;
    public JLabel jLabelAddressNumber,jLabelBIC, jLabelCustomerInformation, jLabelFirstName, jLabelIBAN,jLabelIsVIP, jLabelLastName, jLabelLocality, jLabelPhoneNumber, jLabelPostalCode, jLabelRegistrationDate, jLabelStreetWording,jLabelVATNumber;
    public JTextField jTextFieldAddressNumber,jTextFieldBIC,jTextFieldFirstName,jTextFieldIBAN,jTextFieldLastName,jTextFieldLocality,jTextFieldPhoneNumber,jTextFieldPostalCode,jTextFieldStreetWording,jTextFieldVATNumber;

    public JPanel mainPanel;

    public CustomerForm(String title,Color color){
        setTitle(title);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setBounds(200, 70, 800, 800);
        setLayout(new FlowLayout());

        mainContainer = getContentPane();
        mainContainer.setBackground(color);

        mainPanel = new JPanel();
        mainContainer.add(mainPanel);
        mainPanel.setBackground(color);


    }
}
