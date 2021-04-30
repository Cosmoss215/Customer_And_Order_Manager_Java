package view.CustomerForm;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class CustomerForm extends JFrame {
    private Container mainContainer;
    public JCheckBox jCheckBoxIsVIP;
    public JLabel jLabelAddressNumber,jLabelBIC, jLabelCustomerInformation, jLabelFirstName, jLabelIBAN,jLabelIsVIP, jLabelLastName, jLabelLocality, jLabelPhoneNumber, jLabelPostalCode, jLabelRegistrationDate, jLabelStreetWording,jLabelVATNumber,jLabelCountryChoose;
    public JTextField jTextFieldAddressNumber,jTextFieldBIC,jTextFieldFirstName,jTextFieldIBAN,jTextFieldLastName,jTextFieldLocality,jTextFieldPhoneNumber,jTextFieldPostalCode,jTextFieldStreetWording,jTextFieldVATNumber;
    public JComboBox<String> jComboBoxCountry;
    public JPanel mainPanel,panelForm,panelButton,datePicker;

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

        mainPanel.setBounds(10, 80, 660, 650);
        mainPanel.setLayout(new BorderLayout(25,25));

        jLabelCustomerInformation = new JLabel(title);
        jLabelCustomerInformation.setFont(new Font("Tahoma", 0, 20));
        jLabelCustomerInformation.setHorizontalAlignment(SwingConstants.CENTER);

        panelForm = new JPanel();
        panelButton = new JPanel();

        panelForm.setBackground(color);
        panelButton.setBackground(color);

        panelForm.setLayout(new GridLayout(14,2,50,10));
        panelButton.setLayout(new FlowLayout());

        jLabelFirstName = new JLabel("First name");
        jLabelFirstName.setFont(new Font("Tahoma", 0, 20));
        panelForm.add(jLabelFirstName);
        jTextFieldFirstName = new JTextField();
        panelForm.add(jTextFieldFirstName);
        jTextFieldFirstName.setPreferredSize(new Dimension(250,5));

        jLabelLastName = new JLabel("Last name");
        jLabelLastName.setFont(new Font("Tahoma", 0, 20));
        panelForm.add(jLabelLastName);
        jTextFieldLastName = new JTextField();
        panelForm.add(jTextFieldLastName);



        jLabelRegistrationDate = new JLabel("Registration date");
        jLabelRegistrationDate.setFont(new Font("Tahoma", 0, 20));
        panelForm.add(jLabelRegistrationDate);

        datePicker = new JPanel();


        SpinnerDateModel dateSpinner = new SpinnerDateModel();
        JSpinner dateSelector = new JSpinner(dateSpinner);
        dateSelector.setFont(new Font("Tahoma", 0, 15));

        datePicker.add(dateSelector);
        datePicker.setBackground(color);
        panelForm.add(datePicker);

        jLabelPhoneNumber = new JLabel("Phone number");
        jLabelPhoneNumber.setFont(new Font("Tahoma", 0, 20));
        panelForm.add(jLabelPhoneNumber);
        jTextFieldPhoneNumber = new JTextField();
        panelForm.add(jTextFieldPhoneNumber);

        jLabelAddressNumber = new JLabel("Address");
        jLabelAddressNumber.setFont(new Font("Tahoma", 0, 20));
        panelForm.add(jLabelAddressNumber);
        jTextFieldAddressNumber = new JTextField();
        panelForm.add(jTextFieldAddressNumber);

        jLabelStreetWording = new JLabel("Street wording");
        jLabelStreetWording.setFont(new Font("Tahoma", 0, 20));
        panelForm.add(jLabelStreetWording);
        jTextFieldStreetWording = new JTextField();
        panelForm.add(jTextFieldStreetWording);

        jLabelLocality = new JLabel("Locality");
        jLabelLocality.setFont(new Font("Tahoma", 0, 20));
        panelForm.add(jLabelLocality);
        jTextFieldLocality = new JTextField();
        panelForm.add(jTextFieldLocality);


        jLabelPostalCode = new JLabel("Postal code");
        jLabelPostalCode.setFont(new Font("Tahoma", 0, 20));
        panelForm.add(jLabelPostalCode);
        jTextFieldPostalCode = new JTextField();
        panelForm.add(jTextFieldPostalCode);


        jLabelCountryChoose = new JLabel("Country");
        jLabelCountryChoose.setFont(new Font("Tahoma", 0, 20));
        panelForm.add(jLabelCountryChoose);

        jComboBoxCountry = new JComboBox<>();
        jComboBoxCountry.setFont(new Font("Tahoma", 0, 20));
        jComboBoxCountry.setModel(new DefaultComboBoxModel<>(new String[] { "Belgium", "France", "Netherlands", "Spain", "Germany" }));
        panelForm.add(jComboBoxCountry);


        jLabelVATNumber = new JLabel("Vat number");
        jLabelVATNumber.setFont(new Font("Tahoma", 0, 20));
        panelForm.add(jLabelVATNumber);
        jTextFieldVATNumber = new JTextField();
        panelForm.add(jTextFieldVATNumber);


        jLabelIBAN = new JLabel("Iban");
        jLabelIBAN.setFont(new Font("Tahoma", 0, 20));
        panelForm.add(jLabelIBAN);
        jTextFieldIBAN = new JTextField();
        panelForm.add(jTextFieldIBAN);

        jLabelBIC = new JLabel("BIC");
        jLabelBIC.setFont(new Font("Tahoma", 0, 20));
        panelForm.add(jLabelBIC);
        jTextFieldBIC = new JTextField();
        panelForm.add(jTextFieldBIC);

        jLabelIsVIP = new JLabel("Customer is VIP");
        jLabelIsVIP.setFont(new Font("Tahoma", 0, 20));
        panelForm.add(jLabelIsVIP);
        jCheckBoxIsVIP = new JCheckBox();
        jCheckBoxIsVIP.setBackground(color);
        panelForm.add(jCheckBoxIsVIP);

        mainPanel.add(jLabelCustomerInformation,BorderLayout.NORTH);
        mainPanel.add(panelForm,BorderLayout.CENTER);
        mainPanel.add(panelButton,BorderLayout.SOUTH);
    }
}
