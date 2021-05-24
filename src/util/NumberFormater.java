package util;

import java.text.DecimalFormat;

public class NumberFormater {
    public static String primaryDecimalFormater(double numberToFormat){
        String numberFormated = "N/A";
        if (numberToFormat > 0){
            DecimalFormat format = new DecimalFormat("#.00");
            numberFormated = format.format(numberToFormat);
        }
        return numberFormated;
    }
}
