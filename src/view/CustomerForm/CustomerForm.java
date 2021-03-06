package view.CustomerForm;

import controller.ApplicationController;
import exception.ConnectionException;
import exception.SelectQueryException;
import model.Address;
import model.Country;
import model.Customer;
import model.Locality;
import util.DateFormater;
import util.Verification;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.GregorianCalendar;


public class CustomerForm extends JFrame {
    private Container mainContainer;
    public JCheckBox jCheckBoxIsVIP;
    private JLabel jLabelEmail,jLabelBIC, jLabelCustomerInformation, jLabelFirstName, jLabelIBAN,jLabelIsVIP, jLabelLastName, jLabelLocality, jLabelPhoneNumber, jLabelPostalCode, jLabelRegistrationDate, jLabelStreetWording,jLabelVATNumber,jLabelNickname,jLabelStreetNumber,jLabelBox;
    private JLabel jLabelRegion,jLabelCountry;
    protected JTextField jTextFieldEmail,jTextFieldBIC,jTextFieldFirstName,jTextFieldIBAN,jTextFieldLastName,jTextFieldLocality,jTextFieldPhoneNumber,jTextFieldStreetWording,jTextFieldVATNumber,jTextFieldNickame,jTextFieldBox,jTextFieldRegistrationDate,jTextFieldRegion;
    protected JPanel mainPanel,panelForm,panelButton;
    protected JSpinner streetNumberSelector,postalCodeSelector;
    protected JComboBox<String> jComboBoxCountry;
    protected Customer customer;
    private ArrayList<Locality> locality;
    private LineBorder blackBorder;

    public CustomerForm(String title,Color color) throws ConnectionException, SelectQueryException {
        setTitle(title);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setBounds(200, 70, 800, 850);
        setLayout(new FlowLayout());

        blackBorder = new LineBorder((Color.black), 1);

        mainContainer = getContentPane();
        mainContainer.setBackground(color);

        mainPanel = new JPanel();
        mainContainer.add(mainPanel);
        mainPanel.setBackground(color);

        mainPanel.setBounds(10, 80, 660, 650);
        mainPanel.setLayout(new BorderLayout(25,25));

        panelForm = new JPanel();
        panelButton = new JPanel();

        panelForm.setBackground(color);
        panelButton.setBackground(color);

        panelForm.setLayout(new GridLayout(17,2,40,10));
        panelButton.setLayout(new FlowLayout());

        //Allows to add the JLabel
        addOutputFields(title);
        //Allows to add all input field
        addInputFields(color);

        //Allows to add all input and output fields (JLabel, JTextField, ...) in panelForm.
        addFieldsToPanel();

        //region autocomplete
        ApplicationController applicationController = new ApplicationController();
        locality = applicationController.getAllLocalities();
        KeyboardListner keyboardListner = new KeyboardListner();
        jTextFieldLocality.addKeyListener(keyboardListner);
        //endregion

        mainPanel.add(jLabelCustomerInformation,BorderLayout.NORTH);
        mainPanel.add(panelForm,BorderLayout.CENTER);
        mainPanel.add(panelButton,BorderLayout.SOUTH);
    }
    /** This method initializes each output of the form.
     * @param title is used to define the title
     */
    private void addOutputFields(String title){
        jLabelCustomerInformation = new JLabel(title);
        jLabelCustomerInformation.setFont(new Font("Tahoma", 0, 20));
        jLabelCustomerInformation.setHorizontalAlignment(SwingConstants.CENTER);

        jLabelFirstName = new JLabel("First name *");
        jLabelFirstName.setFont(new Font("Tahoma", 0, 20));

        jLabelLastName = new JLabel("Last name *");
        jLabelLastName.setFont(new Font("Tahoma", 0, 20));

        jLabelNickname = new JLabel("Nickame");
        jLabelNickname.setFont(new Font("Tahoma", 0, 20));

        jLabelRegistrationDate = new JLabel("Registration date *");
        jLabelRegistrationDate.setFont(new Font("Tahoma", 0, 20));

        jLabelPhoneNumber = new JLabel("Phone number");
        jLabelPhoneNumber.setFont(new Font("Tahoma", 0, 20));

        jLabelEmail = new JLabel("Email");
        jLabelEmail.setFont(new Font("Tahoma", 0, 20));

        jLabelStreetWording = new JLabel("Street name *");
        jLabelStreetWording.setFont(new Font("Tahoma", 0, 20));

        jLabelStreetNumber = new JLabel("Street number *");
        jLabelStreetNumber.setFont(new Font("Tahoma", 0, 20));

        jLabelBox = new JLabel("Box");
        jLabelBox.setFont(new Font("Tahoma", 0, 20));

        jLabelLocality = new JLabel("Locality *");
        jLabelLocality.setFont(new Font("Tahoma", 0, 20));

        jLabelPostalCode = new JLabel("Postal code *");
        jLabelPostalCode.setFont(new Font("Tahoma", 0, 20));

        jLabelRegion = new JLabel("Region *");
        jLabelRegion.setFont(new Font("Tahoma", 0, 20));

        jLabelCountry = new JLabel("Country *");
        jLabelCountry.setFont(new Font("Tahoma", 0, 20));

        jLabelVATNumber = new JLabel("Vat number");
        jLabelVATNumber.setFont(new Font("Tahoma", 0, 20));

        jLabelIBAN = new JLabel("Iban *");
        jLabelIBAN.setFont(new Font("Tahoma", 0, 20));

        jLabelBIC = new JLabel("BIC *");
        jLabelBIC.setFont(new Font("Tahoma", 0, 20));

        jLabelIsVIP = new JLabel("Customer is VIP *");
        jLabelIsVIP.setFont(new Font("Tahoma", 0, 20));

    }
    /** This method initializes each input of the form.
     * @param color is used to define the background color of the JCheckBox.
     */
    private void addInputFields(Color color){
        jTextFieldFirstName = new JTextField();
        jTextFieldFirstName.setFont(new Font("Tahoma", 0, 20));
        jTextFieldFirstName.setPreferredSize(new Dimension(250,5));

        jTextFieldLastName = new JTextField();
        jTextFieldLastName.setFont(new Font("Tahoma", 0, 20));
        jTextFieldNickame = new JTextField();

        jTextFieldNickame.setFont(new Font("Tahoma", 0, 20));
        jTextFieldNickame.setToolTipText("Acronym of the name");

        jTextFieldRegistrationDate = new JTextField();
        jTextFieldRegistrationDate.setFont(new Font("Tahoma", 0, 20));
        jTextFieldRegistrationDate.setToolTipText("Format : dd/mm/yyyy");

        jTextFieldPhoneNumber = new JTextField();
        jTextFieldPhoneNumber.setFont(new Font("Tahoma", 0, 20));
        jTextFieldPhoneNumber.setToolTipText("Format : 0xxxxxxxxxx      Example : 0476717615");

        jTextFieldEmail = new JTextField();
        jTextFieldEmail.setFont(new Font("Tahoma", 0, 20));
        jTextFieldEmail.setToolTipText("Format : xxxxx@xxxx.xxx");

        jTextFieldStreetWording = new JTextField();
        jTextFieldStreetWording.setFont(new Font("Tahoma", 0, 20));
        jTextFieldStreetWording.setToolTipText("You must put the name of the street");

        streetNumberSelector = new JSpinner(new SpinnerNumberModel(0,0,100000,1));
        streetNumberSelector.setFont(new Font("Tahoma", 0, 20));

        jTextFieldBox = new JTextField();
        jTextFieldBox.setFont(new Font("Tahoma", 0, 20));
        jTextFieldBox.setToolTipText("You must put a letter such as A, B, ..., Z ");

        jTextFieldLocality = new JTextField();
        jTextFieldLocality.setFont(new Font("Tahoma", 0, 20));
        jTextFieldLocality.setToolTipText("There is an autocompletion that will help you choose your location");

        postalCodeSelector = new JSpinner(new SpinnerNumberModel(0,0,100000,1));
        postalCodeSelector.setFont(new Font("Tahoma", 0, 20));

        jTextFieldRegion = new JTextField();
        jTextFieldRegion.setFont(new Font("Tahoma", 0, 20));

        String[] country = { "BE","FR","GER","NL"};
        jComboBoxCountry = new JComboBox<String>(country);

        jTextFieldVATNumber = new JTextField();
        jTextFieldVATNumber.setFont(new Font("Tahoma", 0, 20));
        jTextFieldVATNumber.setToolTipText("The VAT number is your business number assigned by the ECB (crossroads bank for enterprises)");

        jTextFieldIBAN = new JTextField();
        jTextFieldIBAN.setFont(new Font("Tahoma", 0, 20));
        jTextFieldIBAN.setToolTipText("Format : QQxx xxxx xxxx xxxx OR QQxx xxxx xxxx xxxx");

        jTextFieldBIC = new JTextField();
        jTextFieldBIC.setFont(new Font("Tahoma", 0, 20));
        jTextFieldBIC.setToolTipText("Example : GKCCBEBB");

        jCheckBoxIsVIP = new JCheckBox();
        jCheckBoxIsVIP.setBackground(color);
        jCheckBoxIsVIP.setFont(new Font("Tahoma", 0, 20));
    }

    private void addFieldsToPanel(){
        panelForm.add(jLabelFirstName);
        panelForm.add(jTextFieldFirstName);
        panelForm.add(jLabelLastName);
        panelForm.add(jTextFieldLastName);
        panelForm.add(jLabelNickname);
        panelForm.add(jTextFieldNickame);
        panelForm.add(jLabelRegistrationDate);
        panelForm.add(jTextFieldRegistrationDate);
        panelForm.add(jLabelPhoneNumber);
        panelForm.add(jTextFieldPhoneNumber);
        panelForm.add(jLabelEmail);
        panelForm.add(jTextFieldEmail);
        panelForm.add(jLabelStreetWording);
        panelForm.add(jTextFieldStreetWording);
        panelForm.add(jLabelStreetNumber);
        panelForm.add(streetNumberSelector);
        panelForm.add(jLabelBox);
        panelForm.add(jTextFieldBox);
        panelForm.add(jLabelLocality);
        panelForm.add(jTextFieldLocality);
        panelForm.add(jLabelPostalCode);
        panelForm.add(postalCodeSelector);
        panelForm.add(jLabelRegion);
        panelForm.add(jTextFieldRegion);
        panelForm.add(jLabelCountry);
        panelForm.add(jComboBoxCountry);
        panelForm.add(jLabelVATNumber);
        panelForm.add(jTextFieldVATNumber);
        panelForm.add(jLabelIBAN);
        panelForm.add(jTextFieldIBAN);
        panelForm.add(jLabelBIC);
        panelForm.add(jTextFieldBIC);
        panelForm.add(jLabelIsVIP);
        panelForm.add(jCheckBoxIsVIP);
    }

    protected boolean isValidForm(){

        if (jTextFieldFirstName.getText().length() > 50 || jTextFieldFirstName.getText().isEmpty() || !Verification.nameVerification(jTextFieldFirstName.getText())) {
            Verification.invalidField(jTextFieldFirstName, "First name field is obligatory and must NOT contain NUMBERS (the maximum length is 50)");
            return false;
        }
        else {
            jTextFieldFirstName.setBorder(blackBorder);
        }

        if (jTextFieldLastName.getText().isEmpty() || jTextFieldLastName.getText().length() > 50 || !Verification.nameVerification(jTextFieldLastName.getText())) {
            Verification.invalidField(jTextFieldLastName, "Last name field is obligatory and must NOT contain NUMBERS (the maximum length is 50)");
            return false;
        }
        else {
            jTextFieldLastName.setBorder(blackBorder);
        }

        if (!jTextFieldNickame.getText().isEmpty() && jTextFieldNickame.getText().length() > 10) {
            Verification.invalidField(jTextFieldNickame, "The maximum length is reached (10)");
            return false;
        }
        else {
            jTextFieldNickame.setBorder(blackBorder);
        }

        if (!Verification.dateVerification(jTextFieldRegistrationDate.getText()) || jTextFieldRegistrationDate.getText().isEmpty()) {
            Verification.invalidField(jTextFieldRegistrationDate, "This date is incorrect, should be yyyy/mm/dd (05/12/2020)");
            return false;
        }
        else {
            jTextFieldRegistrationDate.setBorder(blackBorder);
        }
        if (!Verification.isDateCorrect(DateFormater.ourDate(jTextFieldRegistrationDate.getText()))) {
            Verification.invalidField(jTextFieldRegistrationDate, "The recording date cannot be greater than the current date. Must be " + LocalDate.now() + " or earlier");
            return false;
        }
        else {
            jTextFieldRegistrationDate.setBorder(blackBorder);;
        }
        if (!jTextFieldPhoneNumber.getText().isEmpty() && !Verification.phoneNumberVerification(jTextFieldPhoneNumber.getText())) {
            Verification.invalidField(jTextFieldPhoneNumber, "The phone number is incorrect");
            return false;
        }
        else {
            jTextFieldPhoneNumber.setBorder(blackBorder);
        }
        if (!jTextFieldEmail.getText().isEmpty() && !Verification.emailVerification(jTextFieldEmail.getText())) {
            Verification.invalidField(jTextFieldEmail, "The email is incorrect (must be xxxx@xxxx.ccc");
            return false;
        }
        else {
            jTextFieldEmail.setBorder(blackBorder);
        }

        if (jTextFieldStreetWording.getText().isEmpty()){
            Verification.invalidField(jTextFieldStreetWording, "Street name is obligatory");
            return false;
        }
        else {
            jTextFieldStreetWording.setBorder(blackBorder);
        }

        if (streetNumberSelector.getValue().equals(0)){
            JOptionPane.showMessageDialog(null,"The street number cannot be 0", "FormException", JOptionPane.INFORMATION_MESSAGE);
            streetNumberSelector.setBorder(new LineBorder(Color.red,1));
            return false;
        }
        else {
            streetNumberSelector.setBorder(blackBorder);
        }
        if (!jTextFieldBox.getText().isEmpty() && !Verification.isAlphabeticCharacters(jTextFieldBox.getText())){
            Verification.invalidField(jTextFieldBox, "The box must be a character or short string (A,AB,..)");
            return false;
        }
        else {
            jTextFieldBox.setBorder(blackBorder);
        }
        if (!jTextFieldVATNumber.getText().isEmpty() && Integer.parseInt(jTextFieldVATNumber.getText()) < 0) {
            Verification.invalidField(jTextFieldVATNumber, "VAT isn't good");
            return false;
        }
        else {
            jTextFieldVATNumber.setBorder(blackBorder);
        }

        if (jTextFieldIBAN.getText().length() > 35 || jTextFieldIBAN.getText().isEmpty()) {
            Verification.invalidField(jTextFieldIBAN, "Iban field is obligatory and the maximum length is (35)");
            return false;
        }
        else {
            jTextFieldIBAN.setBorder(blackBorder);
        }
        if (!Verification.ibanVerification(jTextFieldIBAN.getText())) {
            Verification.invalidField(jTextFieldIBAN, "The iban number you mentioned is not accepted by this program. Please enter it correctly or contact customer services.");
            return false;
        }
        else {
            jTextFieldIBAN.setBorder(blackBorder);
        }

        if (jTextFieldBIC.getText().length() > 15 || jTextFieldBIC.getText().isEmpty()) {
            Verification.invalidField(jTextFieldBIC, "BIC field is obligatory and the maximum length is reached (15))");
            return false;
        }
        else {
            jTextFieldBIC.setBorder(blackBorder);
        }
        return true;
    }

    protected Customer addCustomer() {

        Boolean isVip;
        String firstName, lastName, iban, bic, streetName, localityName, region, code;
        Integer streetNumber, postalCode;
        Integer phoneNumber = null, vatNumber = null;
        String nickname = null, email = null,box = null;

        firstName = jTextFieldFirstName.getText();
        lastName = jTextFieldLastName.getText();

        if (!jTextFieldNickame.getText().isEmpty()){
            nickname = jTextFieldNickame.getText();
        }
        if (!jTextFieldPhoneNumber.getText().isEmpty()){
            phoneNumber = Integer.valueOf(jTextFieldPhoneNumber.getText());
        }
        if (!jTextFieldEmail.getText().isEmpty()){
            email = jTextFieldEmail.getText();
        }
        if (!jTextFieldVATNumber.getText().isEmpty()){
            vatNumber = Integer.valueOf(jTextFieldVATNumber.getText());
        }
        if (!jTextFieldBox.getText().isEmpty()){
            box = jTextFieldBox.getText();
        }
        iban = jTextFieldIBAN.getText();
        bic = jTextFieldBIC.getText();

        streetName = jTextFieldStreetWording.getText();
        localityName = jTextFieldLocality.getText();
        region = jTextFieldRegion.getText();
        code = (String) jComboBoxCountry.getSelectedItem();

        isVip = jCheckBoxIsVIP.isSelected();
        GregorianCalendar registrationDate = DateFormater.ourDate(jTextFieldRegistrationDate.getText());

        postalCode = (Integer) postalCodeSelector.getValue();
        streetNumber = (Integer) streetNumberSelector.getValue();

        Country country = new Country(code);
        Locality locality = new Locality(localityName, postalCode, region, country);
        Address address = new Address(streetName, streetNumber, box, locality);
        Customer customer = new Customer(firstName, lastName, registrationDate, isVip, nickname, phoneNumber, email, vatNumber, iban, bic, address);

        return customer;
    }

    protected void autoComplete (String txt){
        String localityComplete = "";
        String regionComplete = "";
        Integer postalCodeComplete = null;
        int start = txt.length();
        int last = txt.length();

        int iLocality = 0;
        Boolean isFind = false;

        while (iLocality < locality.size() && !isFind){

            Locality currentLocality = locality.get(iLocality);
            if (currentLocality.getName().startsWith(txt)) {
                localityComplete = currentLocality.getName();
                regionComplete = currentLocality.getRegion();
                postalCodeComplete = currentLocality.getPostalCode();
                last = localityComplete.length();
                isFind = true;
            }
            iLocality++;
        }

        if (last > start) {
            jTextFieldLocality.setText(localityComplete);
            jTextFieldRegion.setText(regionComplete);
            postalCodeSelector.setValue(postalCodeComplete);
            int nb = 0;
            switch (locality.get(iLocality).getCountry().getCode()){
                case "BE" : nb = 0;
                    break;
                case "FR" : nb = 1;
                    break;
                case "GER" : nb = 2;
                    break;
                case "NL" : nb = 3;
                    break;
            }
            jComboBoxCountry.setSelectedIndex(nb);
            jTextFieldLocality.setCaretPosition(last);
            jTextFieldLocality.moveCaretPosition(start);
        }
    }
    private class KeyboardListner implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {
        }
        @Override
        public void keyPressed(KeyEvent evt) {
            switch (evt.getKeyCode()) {
                case KeyEvent.VK_BACK_SPACE:
                    break;
                case KeyEvent.VK_ENTER:
                    jTextFieldLocality.setText(jTextFieldLocality.getText());
                    break;
                default:
                    EventQueue.invokeLater(new Runnable(){
                        @Override

                        public void run(){
                            String txt = jTextFieldLocality.getText();
                            autoComplete(txt);
                        }
                    });
            }
        }
        @Override
        public void keyReleased(KeyEvent e) {

        }
    }




}

