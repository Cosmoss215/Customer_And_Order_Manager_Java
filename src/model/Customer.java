package model;

import java.time.LocalDate;
import java.util.GregorianCalendar;

public class Customer {
    private  Integer id;
    private  String firstName;
    private  String lastName;
    private  GregorianCalendar registrationDate;
    private  Boolean isVip;
    private  String nickname;
    private  Integer phoneNumber;
    private  String email;
    private  Integer vatNumber;
    private  String iban;
    private  String bic;
    private  Address address;

    public Customer(Integer id, String firstName, String lastName, GregorianCalendar registrationDate, Boolean isVip, String nickname, Integer phoneNumber, String email, Integer vatNumber, String iban, String bic, Address address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.registrationDate = registrationDate;
        this.isVip = isVip;
        setNickname(nickname);
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

    public String setNickname(String nickname){
        return this.nickname = nickname;
    }

    public Integer setPhoneNumber(Integer phoneNumber){
        return this.phoneNumber = phoneNumber;
    }
    public String setEmail(String email){
        String s;
        return s = " ";
    }
}

