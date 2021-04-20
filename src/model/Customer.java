package model;

import java.time.LocalDate;

public class Customer {
    private Integer id;
    private final String firstName;
    private final String lastName;
    private final LocalDate registrationDate;
    private final boolean isVip;
    private final String nickname;
    private final Integer phoneNumber;
    private final String email;
    private final Integer vatNumber;
    private final Integer iban;
    private final String bic;
    private final Address address;

    public Customer(String firstName, String lastName, LocalDate registrationDate, boolean isVip, String nickname, int phoneNumber, String email, int vatNumber, int iban, String bic, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.registrationDate = registrationDate;
        this.isVip = isVip;
        this.nickname = nickname;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.vatNumber = vatNumber;
        this.iban = iban;
        this.bic = bic;
        this.address = address;
    }
}
