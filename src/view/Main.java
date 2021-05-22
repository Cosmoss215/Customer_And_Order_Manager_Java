package view;

import controller.ApplicationController;
import exception.ConnectionException;
import exception.SelectQueryException;
import exception.ThreadException;
import model.OrderBusinessTask;
import util.DateFormater;
import util.OurDate;
import util.Verification;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) throws ThreadException {
        Menu menu = new Menu();
        menu.setVisible(true);
    }
}
