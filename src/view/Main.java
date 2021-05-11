package view;

import exception.ThreadException;
import util.DateFormater;
import util.OurDate;
import util.Verification;

public class Main {
    public static void main(String[] args) throws ThreadException {
        Menu menu = new Menu();
        menu.setVisible(true);

        String date = "05-05-2020";

        OurDate ourDate = DateFormater.take(date);
        System.out.println(ourDate);

    }
}
