package util;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.time.LocalDate;
import java.util.GregorianCalendar;
import java.util.regex.Pattern;

public class Verification {
    private static Pattern pattern;
    private static LineBorder redBorder = new LineBorder((Color.red), 3);

    public static boolean LengthStringVerification(String string,int min, int max) {
        return pattern.matches("^[A-Z]{"+ min +","+max+"}$", string);
    }

    public static boolean phoneNumberVerification(String phoneNumber) {
        return phoneNumber != null && pattern.matches("\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}", phoneNumber);
    }

    public static boolean emailVerification(String email) {
        return pattern.matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$", email);
    }
    public static boolean dateVerification(String date) {
        return pattern.matches("^\\d{2}/\\d{2}/\\d{4}$" , date);
    }

    public static boolean isAlphabeticCharacters(String character) {
        return pattern.matches( "[A-Z]",character);
    }

    public static boolean ibanVerification(String iban) {
        return Pattern.matches( "^[A-Z]{2}[0-9]{2}(?:[ ]?[0-9]{4}){4}(?:[ ]?[0-9]{1,2})?$",iban) ||
                Pattern.matches( "^[A-Z]{2}[0-9]{2}(?:[ ]?[0-9]{4}){3}(?:[ ]?[0-9]{1,2})?$",iban); //Ici car en belgique c'est 3x 4 chiffre. Du coup au lieu de vérifié si il y a bien 4x4 chiffre on vérifie s'il n'y
        //en aura pas aussi que 3
    }
    /*
    public static boolean isToday(GregorianCalendar calendar) {
        LocalDate dateReceived = LocalDate.ofInstant(calendar.toInstant(),calendar.toZonedDateTime().getZone());
        LocalDate today = LocalDate.now();
        return today.isEqual(dateReceived) || today.isAfter(dateReceived);
    }
     */
    public static boolean nameVerification(String name){
        return Pattern.matches( "[a-zA-zéèàêÉÈ]+([ -][a-zéèàêA-Zéèàê]+)*",name);
    }

    public static boolean isDateCorrect(GregorianCalendar date) {
        return !date.after(DateFormater.today());
    }
    public static void invalidField(JTextField jTextField,String message){
        JOptionPane.showMessageDialog(null,message, "FormException", JOptionPane.INFORMATION_MESSAGE);
        jTextField.setBorder(redBorder);
    }
}