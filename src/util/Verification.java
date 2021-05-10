package util;

import javax.swing.*;
import java.util.regex.Pattern;

public class Verification {
    private static Pattern pattern;

    public static boolean LengthStringVerification(String string,int min, int max) {
        return pattern.matches("^[A-Z]{"+ min +","+max+"}$", string);
    }

    public static boolean phoneNumberVerification(String phoneNumber) {
        return phoneNumber != null || pattern.matches("\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}", phoneNumber);
    }

    public static boolean emailVerification(String email) {
        return pattern.matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$", email);
    }
    public static boolean dateVerification(String date) {
        return pattern.matches("^\\d{2}-\\d{2}-\\d{4}$"
                , date) || pattern.matches("^\\d{2}-\\d{2}-\\d{2}$"
                , date);
    }
}