package model;

import java.time.LocalDate;
import java.util.GregorianCalendar;

public class Customer {
    private final Integer id;
    private final String firstName;
    private final String lastName;
    private final GregorianCalendar registrationDate;
    private final Boolean isVip;
    private final String nickname;
    private final Integer phoneNumber;
    private final String email;
    private final Integer vatNumber;
    private final String iban;
    private final String bic;
    private final Address address;

    public Customer(Integer id, String firstName, String lastName, GregorianCalendar registrationDate, Boolean isVip, String nickname, Integer phoneNumber, String email, Integer vatNumber, String iban, String bic, Address address) {
        this.id = id;
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

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public GregorianCalendar getRegistrationDate() {
        return registrationDate;
    }

    public Boolean getVip() {
        return isVip;
    }

    public String getNickname() {
        return nickname;
    }

    public String getEmail() {
        return email;
    }
    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public Integer getVatNumber() {
        return vatNumber;
    }

    public String getIban() {
        return iban;
    }

    public String getBic() {
        return bic;
    }

    public Address getAddress() {
        return address;
    }
}

