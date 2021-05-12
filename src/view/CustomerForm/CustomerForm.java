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
    private ArrayList<Locality> locality;

    public CustomerForm(String title,Color color) throws ConnectionException, SelectQueryException {
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

        jLabelFirstName = new JLabel("First name");
        jLabelFirstName.setFont(new Font("Tahoma", 0, 20));

        jLabelLastName = new JLabel("Last name");
        jLabelLastName.setFont(new Font("Tahoma", 0, 20));

        jLabelNickname = new JLabel("Nickame");
        jLabelNickname.setFont(new Font("Tahoma", 0, 20));

        jLabelRegistrationDate = new JLabel("Registration date");
        jLabelRegistrationDate.setFont(new Font("Tahoma", 0, 20));

        jLabelPhoneNumber = new JLabel("Phone number");
        jLabelPhoneNumber.setFont(new Font("Tahoma", 0, 20));

        jLabelEmail = new JLabel("Email");
        jLabelEmail.setFont(new Font("Tahoma", 0, 20));

        jLabelStreetWording = new JLabel("Street name");
        jLabelStreetWording.setFont(new Font("Tahoma", 0, 20));

        jLabelStreetNumber = new JLabel("Street number");
        jLabelStreetNumber.setFont(new Font("Tahoma", 0, 20));

        jLabelBox = new JLabel("Box");
        jLabelBox.setFont(new Font("Tahoma", 0, 20));

        jLabelLocality = new JLabel("Locality");
        jLabelLocality.setFont(new Font("Tahoma", 0, 20));

        jLabelPostalCode = new JLabel("Postal code");
        jLabelPostalCode.setFont(new Font("Tahoma", 0, 20));

        jLabelRegion = new JLabel("Region");
        jLabelRegion.setFont(new Font("Tahoma", 0, 20));

        jLabelCountry = new JLabel("Country");
        jLabelCountry.setFont(new Font("Tahoma", 0, 20));

        jLabelVATNumber = new JLabel("Vat number");
        jLabelVATNumber.setFont(new Font("Tahoma", 0, 20));

        jLabelIBAN = new JLabel("Iban");
        jLabelIBAN.setFont(new Font("Tahoma", 0, 20));

        jLabelBIC = new JLabel("BIC");
        jLabelBIC.setFont(new Font("Tahoma", 0, 20));

        jLabelIsVIP = new JLabel("Customer is VIP");
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
        jTextFieldRegistrationDate = new JTextField();
        jTextFieldRegistrationDate.setFont(new Font("Tahoma", 0, 20));
        jTextFieldPhoneNumber = new JTextField();
        jTextFieldPhoneNumber.setFont(new Font("Tahoma", 0, 20));
        jTextFieldEmail = new JTextField();
        jTextFieldEmail.setFont(new Font("Tahoma", 0, 20));
        jTextFieldStreetWording = new JTextField();
        jTextFieldStreetWording.setFont(new Font("Tahoma", 0, 20));
        streetNumberSelector = new JSpinner(new SpinnerNumberModel(0,0,100000,1));
        streetNumberSelector.setFont(new Font("Tahoma", 0, 20));
        jTextFieldBox = new JTextField();
        jTextFieldBox.setFont(new Font("Tahoma", 0, 20));
        jTextFieldLocality = new JTextField();
        jTextFieldLocality.setFont(new Font("Tahoma", 0, 20));
        postalCodeSelector = new JSpinner(new SpinnerNumberModel(0,0,100000,1));
        postalCodeSelector.setFont(new Font("Tahoma", 0, 20));
        jTextFieldRegion = new JTextField();
        jTextFieldRegion.setFont(new Font("Tahoma", 0, 20));
        String[] country = { "BE","FR","GER","NL"};
        jComboBoxCountry = new JComboBox<String>(country);
        jTextFieldVATNumber = new JTextField();
        jTextFieldVATNumber.setFont(new Font("Tahoma", 0, 20));
        jTextFieldIBAN = new JTextField();
        jTextFieldIBAN.setFont(new Font("Tahoma", 0, 20));
        jTextFieldBIC = new JTextField();
        jTextFieldBIC.setFont(new Font("Tahoma", 0, 20));
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

    protected boolean verification(){

        if (jTextFieldFirstName.getText().length() > 50 || jTextFieldFirstName.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,"First name field is obligatory and the maximum length is (50)", "FormException", JOptionPane.INFORMATION_MESSAGE);
            jTextFieldFirstName.setBorder(new LineBorder(Color.red,3));
            return false;
        }else {
            jTextFieldFirstName.setBorder(new LineBorder(Color.BLACK,1));
        }

        if (jTextFieldLastName.getText().isEmpty() || jTextFieldLastName.getText().length() > 50) {
            JOptionPane.showMessageDialog(null,"Last name field is obligatory and the maximum length is (50)", "FormException", JOptionPane.INFORMATION_MESSAGE);
            jTextFieldLastName.setBorder(new LineBorder(Color.red,3));
            return false;
        }else {
            jTextFieldLastName.setBorder(new LineBorder(Color.BLACK,1));
        }

        if (!jTextFieldNickame.getText().isEmpty() && jTextFieldNickame.getText().length() > 10) {
            JOptionPane.showMessageDialog(null,"The maximum length is reached (10)", "FormException", JOptionPane.INFORMATION_MESSAGE);
            jTextFieldNickame.setBorder(new LineBorder(Color.red,3));
            return false;
        }else {
            jTextFieldNickame.setBorder(new LineBorder(Color.BLACK,1));
        }

        if (!Verification.dateVerification(jTextFieldRegistrationDate.getText()) || jTextFieldRegistrationDate.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,"This date is incorrect, should be dd-mm-yyyy (01-01-2021)", "FormException", JOptionPane.INFORMATION_MESSAGE);
            jTextFieldRegistrationDate.setBorder(new LineBorder(Color.red,3));
            return false;
        }
        else {
            jTextFieldRegistrationDate.setBorder(new LineBorder(Color.BLACK,1));
        }
        //can be null
        if (!jTextFieldPhoneNumber.getText().isEmpty() && !Verification.phoneNumberVerification(jTextFieldPhoneNumber.getText())) {
            JOptionPane.showMessageDialog(null,"The phone number is incorrect", "FormException", JOptionPane.INFORMATION_MESSAGE);
            jTextFieldPhoneNumber.setBorder(new LineBorder(Color.red,3));
            return false;
        }
        else {
            jTextFieldPhoneNumber.setBorder(new LineBorder(Color.BLACK,1));
        }
        //can be null
        if (!jTextFieldEmail.getText().isEmpty() && !Verification.emailVerification(jTextFieldEmail.getText())) {
            JOptionPane.showMessageDialog(null,"The email is incorrect (must be xxxx@xxxx.ccc", "FormException", JOptionPane.INFORMATION_MESSAGE);
            jTextFieldEmail.setBorder(new LineBorder(Color.red,3));
            return false;
        }
        else {
            jTextFieldEmail.setBorder(new LineBorder(Color.BLACK,1));
        }

        if (jTextFieldStreetWording.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Street name is obligatory", "FormException", JOptionPane.INFORMATION_MESSAGE);
            jTextFieldStreetWording.setBorder(new LineBorder(Color.red,3));
            return false;
        }
        else {
            jTextFieldStreetWording.setBorder(new LineBorder(Color.BLACK,1));
        }

        if (streetNumberSelector.getValue().equals(0)){
            JOptionPane.showMessageDialog(null,"The street number cannot be 0", "FormException", JOptionPane.INFORMATION_MESSAGE);
            streetNumberSelector.setBorder(new LineBorder(Color.red,2));
            return false;
        }
        else {
            streetNumberSelector.setBorder(new LineBorder(Color.BLACK,1));
        }
        //can be null
        if (!jTextFieldBox.getText().isEmpty() && !Verification.isAlphabeticCharacters(jTextFieldBox.getText())){
            JOptionPane.showMessageDialog(null,"The box must be a character or short string (A,AB,..)", "FormException", JOptionPane.INFORMATION_MESSAGE);
            jTextFieldBox.setBorder(new LineBorder(Color.red,3));
            return false;
        }
        else {
            jTextFieldBox.setBorder(new LineBorder(Color.BLACK,1));
        }
        //can be null
        if (!jTextFieldVATNumber.getText().isEmpty() && Integer.parseInt(jTextFieldVATNumber.getText()) < 0) {
            JOptionPane.showMessageDialog(null,"VAT isn't good", "FormException", JOptionPane.INFORMATION_MESSAGE);
            jTextFieldVATNumber.setBorder(new LineBorder(Color.red,3));
            return false;
        }
        else {
            jTextFieldVATNumber.setBorder(new LineBorder(Color.BLACK,1));
        }

        if (jTextFieldIBAN.getText().length() > 35 || jTextFieldIBAN.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,"Iban field is obligatory and the maximum length is (35)", "FormException", JOptionPane.INFORMATION_MESSAGE);
            jTextFieldIBAN.setBorder(new LineBorder(Color.red,3));
            return false;
        }
        else {
            jTextFieldIBAN.setBorder(new LineBorder(Color.BLACK,1));
        }

        if (jTextFieldBIC.getText().length() > 15 || jTextFieldBIC.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,"BIC field is obligatory and the maximum length is reached (15)", "FormException", JOptionPane.INFORMATION_MESSAGE);
            jTextFieldBIC.setBorder(new LineBorder(Color.red,3));
            return false;
        }
        else {
            jTextFieldBIC.setBorder(new LineBorder(Color.BLACK,1));
        }
        return true;
    }

    protected Customer addCustomer() {

        Boolean isVip;
        String firstName, lastName, iban, bic, streetName, box, localityName, region, code;
        Integer streetNumber, postalCode;
        Integer phoneNumber = null, vatNumber = null;
        String nickname = null, email = null;

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
        iban = jTextFieldIBAN.getText();
        bic = jTextFieldBIC.getText();
        streetName = jTextFieldStreetWording.getText();
        box = jTextFieldBox.getText();
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
        int a;

        for(a = 0; a < locality.size();a++)
        {
            if (locality.get(a).getName().startsWith(txt)) {
                localityComplete = locality.get(a).getName();
                regionComplete = locality.get(a).getRegion();
                postalCodeComplete = locality.get(a).getPostalCode();
                last = localityComplete.length();
                break;
            }
        }
        if (last > start) {
            jTextFieldLocality.setText(localityComplete);
            jTextFieldRegion.setText(regionComplete);
            postalCodeSelector.setValue(postalCodeComplete);
            int nb = 0;
            switch (locality.get(a).getCountry().getCode()){
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

