package util;

import java.time.LocalDate;
import java.util.GregorianCalendar;

public class DateFormater {

    public static GregorianCalendar ourDate(String date) {
        int day = Integer.parseInt(date.substring(0,2));
        int month = Integer.parseInt(date.substring(3,5));
        int year = Integer.parseInt(date.substring(6,10));

        GregorianCalendar ourDate = new GregorianCalendar(year,month-1,day);
        return ourDate;
    }

    public static java.sql.Date fromJavaToSqlDate(GregorianCalendar date) {
        java.sql.Date sqlDate = new java.sql.Date(date.getTimeInMillis());
        return sqlDate;
    }

    public static GregorianCalendar fromSqlToGregorianDate(java.sql.Date sqlDate) {
        GregorianCalendar date = new GregorianCalendar();
        date.setTime(sqlDate);
        return date;
    }

    public static GregorianCalendar today() {
        LocalDate now = LocalDate.now();
        return new GregorianCalendar(now.getYear(), now.getMonthValue() - 1, now.getDayOfMonth());
    }
}
