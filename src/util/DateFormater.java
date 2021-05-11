package util;

import java.sql.Date;
import java.util.GregorianCalendar;

public class DateFormater {
    /** créer une classe Util.Format (package Util) ayant comme méthode static setDate(dateJava, "column_label") qui renvoie un GregorianCalendar?
    GregorianCalendar registrationDate = new GregorianCalendar();
    Date registrationDateSQL =  data.getDate("registration_date");
                registrationDate.setTime(registrationDateSQL);
     */
    /*
    public static GregorianCalendar setDateFromData(Date date, String columnLabel){

    } */
    public static OurDate take(String date ){
        int day = Integer.parseInt(date.substring(0,2));
        int month = Integer.parseInt(date.substring(3,5));
        int year = Integer.parseInt(date.substring(6,10));

        OurDate ourDate = new OurDate(day,month,year);

        return ourDate;
    }
}
