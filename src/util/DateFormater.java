package util;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateFormater {

    public static GregorianCalendar ourDate(String date) {
        int day = Integer.parseInt(date.substring(0,2));
        int month = Integer.parseInt(date.substring(3,5));
        int year = Integer.parseInt(date.substring(6,10));

        return new GregorianCalendar(year,month-1,day);
    }

    public static java.sql.Date fromJavaToSqlDate(GregorianCalendar date) {
        return new java.sql.Date(date.getTimeInMillis());
    }

    public static GregorianCalendar fromSqlToGregorianDate(java.sql.Date sqlDate) {
        if(sqlDate != null) {
            GregorianCalendar date = new GregorianCalendar();
            date.setTime(sqlDate);
            return date;
        }
        return null;
    }

    public static GregorianCalendar today() {
        LocalDate now = LocalDate.now();
        return new GregorianCalendar(now.getYear(), now.getMonthValue() - 1, now.getDayOfMonth());
    }

    public static String toString(GregorianCalendar date){
        return  (date.get(Calendar.DAY_OF_MONTH) <10 ?"0":"") + date.get(Calendar.DAY_OF_MONTH) + "/" +
                ((date.get(Calendar.MONTH) + 1)<10?"0":"") + (date.get(Calendar.MONTH) + 1) + "/" +
                date.get(Calendar.YEAR);
    }
    public static String toString(java.sql.Date date) {
        return toString(fromSqlToGregorianDate(date));
    }
}
