package model;

import util.DateFormater;
import util.Verification;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.regex.Pattern;

public class Customer {
    private Integer id;
    private String firstName;
    private String lastName;
    private GregorianCalendar registrationDate;
    private Boolean isVip;
    private String nickname;
    private Integer phoneNumber;
    private String email;
    private Integer vatNumber;
    private String iban;
    private String bic;
    private Address address;

    public Customer(Integer id, String firstName, String lastName , GregorianCalendar registrationDate, Boolean isVip, String nickname, Integer phoneNumber, String email, Integer vatNumber, String iban, String bic, Address address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        setRegistrationDate(registrationDate);
        this.isVip = isVip;
        setNickname(nickname);
        setPhoneNumber(phoneNumber);
        setEmail(email);
        setVatNumber(vatNumber);
        this.iban = iban;
        this.bic = bic;
        this.address = address;
    }
    //region overload constructor
    public Customer(String firstName, String lastName , GregorianCalendar registrationDate, Boolean isVip, String nickname, Integer phoneNumber, String email, Integer vatNumber, String iban, String bic, Address address){
        this(null, firstName, lastName, registrationDate, isVip, nickname, phoneNumber, email, vatNumber, iban, bic, address);
    }

    public Customer(Integer id, String firstName, String lastName, GregorianCalendar registrationDate, Boolean isVip, String iban, String bic, Address address) {
        this(id, firstName, lastName, registrationDate, isVip, null, null, null, null, iban, bic, address);
    }
    public Customer( String firstName, String lastName, GregorianCalendar registrationDate, Boolean isVip, String iban, String bic, Address address) {
        this(null, firstName, lastName, registrationDate, isVip, null, null, null, null, iban, bic, address);
    }
    //endregion
    //region getter
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
    //endregion
    //region setter
    public void setRegistrationDate(GregorianCalendar date){
        this.registrationDate = date;
    }
    public void setNickname(String nickname){
        this.nickname = nickname;
    }
    public void setPhoneNumber(Integer phoneNumber) {
            this.phoneNumber = phoneNumber;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setVatNumber(Integer vatNumber) {
        this.vatNumber = vatNumber;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    //endregion
    //region display

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", registrationDate=" + DateFormater.toString(registrationDate) +
                ", isVip=" + isVip +
                ", nickname='" + nickname + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                ", vatNumber=" + vatNumber +
                ", iban='" + iban + '\'' +
                ", bic='" + bic + '\'' +
                ", address=" + address +
                '}';
    }
    //endregion
}

