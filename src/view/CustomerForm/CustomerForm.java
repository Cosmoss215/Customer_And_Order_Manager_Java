package view.CustomerForm;

import model.Address;
import model.Country;
import model.Customer;
import model.Locality;
import org.jdatepicker.JDateComponent;
import util.Verification;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.GregorianCalendar;


public class CustomerForm extends JFrame {
    private Container mainContainer;
    public JCheckBox jCheckBoxIsVIP;
    public JLabel jLabelEmail,jLabelBIC, jLabelCustomerInformation, jLabelFirstName, jLabelIBAN,jLabelIsVIP, jLabelLastName, jLabelLocality, jLabelPhoneNumber, jLabelPostalCode, jLabelRegistrationDate, jLabelStreetWording,jLabelVATNumber,jLabelNickname,jLabelStreetNumber,jLabelBox;
    public JLabel jLabelRegion,jLabelCountry;
    public JTextField jTextFieldEmail,jTextFieldBIC,jTextFieldFirstName,jTextFieldIBAN,jTextFieldLastName,jTextFieldLocality,jTextFieldPhoneNumber,jTextFieldStreetWording,jTextFieldVATNumber,jTextFieldNickame,jTextFieldBox,jTextFieldRegistrationDate,jTextFieldRegion;
    public JPanel mainPanel,panelForm,panelButton;
    public JSpinner streetNumberSelector,postalCodeSelector,vatSelector;
    public JComboBox<String> jComboBoxCountry;

    public CustomerForm(String title,Color color){
        setTitle(title);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setBounds(200, 70, 800, 850);
        setLayout(new FlowLayout());

        mainContainer = getContentPane();
        mainContainer.setBackground(color);

        mainPanel = new JPanel();
        mainContainer.add(mainPanel);
        mainPanel.setBackground(color);

        mainPanel.setBounds(10, 80, 660, 650);
        mainPanel.setLayout(new BorderLayout(25,25));

        jLabelCustomerInformation = new JLabel(title);
        jLabelCustomerInformation.setFont(new Font("Tahoma", 0, 20));
        jLabelCustomerInformation.setHorizontalAlignment(SwingConstants.CENTER);

        panelForm = new JPanel();
        panelButton = new JPanel();

        panelForm.setBackground(color);
        panelButton.setBackground(color);

        panelForm.setLayout(new GridLayout(17,2,40,10));
        panelButton.setLayout(new FlowLayout());

        jLabelFirstName = new JLabel("First name");
        jLabelFirstName.setFont(new Font("Tahoma", 0, 20));
        panelForm.add(jLabelFirstName);
        jTextFieldFirstName = new JTextField();
        jTextFieldFirstName.setFont(new Font("Tahoma", 0, 20));
        panelForm.add(jTextFieldFirstName);
        jTextFieldFirstName.setPreferredSize(new Dimension(250,5));

        jLabelLastName = new JLabel("Last name");
        jLabelLastName.setFont(new Font("Tahoma", 0, 20));
        panelForm.add(jLabelLastName);
        jTextFieldLastName = new JTextField();
        jTextFieldLastName.setFont(new Font("Tahoma", 0, 20));
        panelForm.add(jTextFieldLastName);

        jLabelNickname = new JLabel("Nickame");
        jLabelNickname.setFont(new Font("Tahoma", 0, 20));
        panelForm.add(jLabelNickname);
        jTextFieldNickame = new JTextField();
        jTextFieldNickame.setFont(new Font("Tahoma", 0, 20));
        panelForm.add(jTextFieldNickame);

        jLabelRegistrationDate = new JLabel("Registration date");
        jLabelRegistrationDate.setFont(new Font("Tahoma", 0, 20));
        panelForm.add(jLabelRegistrationDate);

        jTextFieldRegistrationDate = new JTextField();
        jTextFieldRegistrationDate.setFont(new Font("Tahoma", 0, 20));
        panelForm.add(jTextFieldRegistrationDate);

        jLabelPhoneNumber = new JLabel("Phone number");
        jLabelPhoneNumber.setFont(new Font("Tahoma", 0, 20));
        panelForm.add(jLabelPhoneNumber);
        jTextFieldPhoneNumber = new JTextField();
        jTextFieldPhoneNumber.setFont(new Font("Tahoma", 0, 20));
        panelForm.add(jTextFieldPhoneNumber);

        jLabelEmail = new JLabel("Email");
        jLabelEmail.setFont(new Font("Tahoma", 0, 20));
        panelForm.add(jLabelEmail);
        jTextFieldEmail = new JTextField();
        jTextFieldEmail.setFont(new Font("Tahoma", 0, 20));
        panelForm.add(jTextFieldEmail);

        jLabelStreetWording = new JLabel("Street name");
        jLabelStreetWording.setFont(new Font("Tahoma", 0, 20));
        panelForm.add(jLabelStreetWording);
        jTextFieldStreetWording = new JTextField();
        jTextFieldStreetWording.setFont(new Font("Tahoma", 0, 20));
        panelForm.add(jTextFieldStreetWording);

        jLabelStreetNumber = new JLabel("Street number");
        jLabelStreetNumber.setFont(new Font("Tahoma", 0, 20));
        panelForm.add(jLabelStreetNumber);
        streetNumberSelector = new JSpinner(new SpinnerNumberModel(0,0,100000,1));
        streetNumberSelector.setFont(new Font("Tahoma", 0, 20));
        panelForm.add(streetNumberSelector);

        jLabelBox = new JLabel("Box");
        jLabelBox.setFont(new Font("Tahoma", 0, 20));
        panelForm.add(jLabelBox);
        jTextFieldBox = new JTextField();
        jTextFieldBox.setFont(new Font("Tahoma", 0, 20));
        panelForm.add(jTextFieldBox);

        jLabelLocality = new JLabel("Locality");
        jLabelLocality.setFont(new Font("Tahoma", 0, 20));
        panelForm.add(jLabelLocality);
        jTextFieldLocality = new JTextField();
        jTextFieldLocality.setFont(new Font("Tahoma", 0, 20));
        panelForm.add(jTextFieldLocality);

        jLabelPostalCode = new JLabel("Postal code");
        jLabelPostalCode.setFont(new Font("Tahoma", 0, 20));
        panelForm.add(jLabelPostalCode);

        postalCodeSelector = new JSpinner(new SpinnerNumberModel(0,0,100000,1));
        postalCodeSelector.setFont(new Font("Tahoma", 0, 20));
        panelForm.add(postalCodeSelector);

        jLabelRegion = new JLabel("Region");
        jLabelRegion.setFont(new Font("Tahoma", 0, 20));
        jTextFieldRegion = new JTextField();
        jTextFieldRegion.setFont(new Font("Tahoma", 0, 20));
        panelForm.add(jLabelRegion);
        panelForm.add(jTextFieldRegion);

        jLabelCountry = new JLabel("Country");
        jLabelCountry.setFont(new Font("Tahoma", 0, 20));
        String[] country = { "BE","FR","GER","NL"};
        jComboBoxCountry = new JComboBox<String>(country);
        panelForm.add(jLabelCountry);
        panelForm.add(jComboBoxCountry);

        jLabelVATNumber = new JLabel("Vat number");
        jLabelVATNumber.setFont(new Font("Tahoma", 0, 20));
        panelForm.add(jLabelVATNumber);


        jTextFieldVATNumber = new JTextField();
        jTextFieldVATNumber.setFont(new Font("Tahoma", 0, 20));
        panelForm.add(jTextFieldVATNumber);

        jLabelIBAN = new JLabel("Iban");
        jLabelIBAN.setFont(new Font("Tahoma", 0, 20));
        panelForm.add(jLabelIBAN);
        jTextFieldIBAN = new JTextField();
        jTextFieldIBAN.setFont(new Font("Tahoma", 0, 20));
        panelForm.add(jTextFieldIBAN);

        jLabelBIC = new JLabel("BIC");
        jLabelBIC.setFont(new Font("Tahoma", 0, 20));
        panelForm.add(jLabelBIC);
        jTextFieldBIC = new JTextField();
        jTextFieldBIC.setFont(new Font("Tahoma", 0, 20));
        panelForm.add(jTextFieldBIC);

        jLabelIsVIP = new JLabel("Customer is VIP");
        jLabelIsVIP.setFont(new Font("Tahoma", 0, 20));
        panelForm.add(jLabelIsVIP);
        jCheckBoxIsVIP = new JCheckBox();
        jCheckBoxIsVIP.setBackground(color);
        jCheckBoxIsVIP.setFont(new Font("Tahoma", 0, 20));
        panelForm.add(jCheckBoxIsVIP);

        mainPanel.add(jLabelCustomerInformation,BorderLayout.NORTH);
        mainPanel.add(panelForm,BorderLayout.CENTER);
        mainPanel.add(panelButton,BorderLayout.SOUTH);

    }
    public boolean verification(){
        if (!Verification.dateVerification(jTextFieldRegistrationDate.getText())) {
            JOptionPane.showMessageDialog(null,"This date is incorrect, should be dd-mm-yy or dd-mm-yyyy", "FormException", JOptionPane.INFORMATION_MESSAGE);
            jTextFieldRegistrationDate.setBorder(new LineBorder(Color.red,3));
            return false;
        }
        else {
            jTextFieldRegistrationDate.setBorder(new LineBorder(Color.BLACK,1));
        }
        if (jTextFieldFirstName.getText().length() > 50) {
            JOptionPane.showMessageDialog(null,"The maximum length is reached (50)", "FormException", JOptionPane.INFORMATION_MESSAGE);
            jTextFieldFirstName.setBorder(new LineBorder(Color.red,3));
            return false;
        }
        if (jTextFieldLastName.getText().length() > 50) {
            JOptionPane.showMessageDialog(null,"The maximum length is reached (50)", "FormException", JOptionPane.INFORMATION_MESSAGE);
            jTextFieldLastName.setBorder(new LineBorder(Color.red,3));
            return false;
        }

        if (jTextFieldNickame.getText().length() > 10) {
            JOptionPane.showMessageDialog(null,"The maximum length is reached (10)", "FormException", JOptionPane.INFORMATION_MESSAGE);
            jTextFieldNickame.setBorder(new LineBorder(Color.red,3));
            return false;
        }

        if (!Verification.phoneNumberVerification(jTextFieldPhoneNumber.getText())) {
            JOptionPane.showMessageDialog(null,"The phone number is incorrect", "FormException", JOptionPane.INFORMATION_MESSAGE);
            jTextFieldPhoneNumber.setBorder(new LineBorder(Color.red,3));
            return false;
        }

        if (!Verification.emailVerification(jTextFieldEmail.getText())) {
            JOptionPane.showMessageDialog(null,"The email is incorrect (must be xxxx@xxxx.ccc", "FormException", JOptionPane.INFORMATION_MESSAGE);
            jTextFieldEmail.setBorder(new LineBorder(Color.red,3));
            return false;
        }

        if (jTextFieldIBAN.getText().length() > 35) {
            JOptionPane.showMessageDialog(null,"The maximum length is reached (35)", "FormException", JOptionPane.INFORMATION_MESSAGE);
            jTextFieldIBAN.setBorder(new LineBorder(Color.red,3));
            return false;
        }

        if (jTextFieldBIC.getText().length() > 15) {
            JOptionPane.showMessageDialog(null,"The maximum length is reached (15)", "FormException", JOptionPane.INFORMATION_MESSAGE);
            jTextFieldBIC.setBorder(new LineBorder(Color.red,3));
            return false;
        }
        return true;
    }


    public Customer addCustomer() {

        Boolean isVip;
        String firstName, lastName, nickname, email, iban, bic, streetName, box, localityName, region, code, registrationDate;
        Integer streetNumber, postalCode, phoneNumber, vatNumber;

        firstName = jTextFieldFirstName.getText();
        lastName = jTextFieldLastName.getText();
        nickname = jTextFieldNickame.getText();
        phoneNumber = Integer.valueOf(jTextFieldPhoneNumber.getText());
        email = jTextFieldEmail.getText();
        vatNumber = Integer.valueOf(jTextFieldVATNumber.getText());
        iban = jTextFieldIBAN.getText();
        bic = jTextFieldBIC.getText();
        streetName = jTextFieldStreetWording.getText();
        box = jTextFieldBox.getText();
        localityName = jTextFieldLocality.getText();
        region = jTextFieldRegion.getText();
        code = (String) jComboBoxCountry.getSelectedItem();
        isVip = jCheckBoxIsVIP.isSelected();
        registrationDate = jTextFieldRegistrationDate.getText();
        postalCode = (Integer) postalCodeSelector.getValue();
        streetNumber = (Integer) streetNumberSelector.getValue();

        GregorianCalendar gregorianCalendar = new GregorianCalendar(2020,05,05);

        Country country = new Country(code);
        Locality locality = new Locality(localityName, postalCode, region, country);
        Address address = new Address(streetName, streetNumber, box, locality);
        Customer customer = new Customer(firstName, lastName, gregorianCalendar, isVip, nickname, phoneNumber, email, vatNumber, iban, bic, address);

        return customer;
    }

}

