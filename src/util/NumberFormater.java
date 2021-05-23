package util;

import java.text.DecimalFormat;

public class NumberFormater {
    public static String primaryDecimalFormater(double numberToFormat){
        DecimalFormat format = new DecimalFormat("#.00");
        String numberFormated = format.format(numberToFormat);
        return numberFormated;
    }
}
