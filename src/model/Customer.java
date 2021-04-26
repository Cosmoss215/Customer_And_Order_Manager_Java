package model;

import java.time.LocalDate;
import java.util.Calendar;
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
        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
        setRegistrationDate(registrationDate);
        setIsVip(isVip);
        setNickname(nickname);
        setPhoneNumber(phoneNumber);
        setEmail(email);
        setVatNumber(vatNumber);
        setIban(iban);
        setBic(bic);
        setAddress(address);
    }

    public Customer(Integer id, String firstName, String lastName, GregorianCalendar registrationDate, Boolean isVip, String iban, String bic, Address address) {
        this(id, firstName, lastName, registrationDate, isVip, null, null, null, null, iban, bic, address);
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

    public String displayRegistrationDate(){
        return registrationDate.get(Calendar.DAY_OF_MONTH) + "/" + ((registrationDate.get(Calendar.MONTH) + 1)<10?"0":"") + (registrationDate.get(Calendar.MONTH) + 1) + "/" + registrationDate.get(Calendar.YEAR);
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

    public void setId(Integer id){
        this.id = id;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setRegistrationDate(GregorianCalendar date){
        registrationDate = date;
    }

    public void setIsVip(Boolean isVip){
        this.isVip = isVip;
    }

    public void setNickname(String nickname){
        if(nickname != null)
            this.nickname = nickname;
        else
            this.nickname = null;
    }

    public void setPhoneNumber(Integer phoneNumber){
        if(phoneNumber != null)
            this.phoneNumber = phoneNumber;
        else
            this.phoneNumber = null;
    }

    public void setEmail(String email){
        if(email != null)
            this.email = email;
        else
            this.email = null;
    }

    public void setVatNumber(Integer vatNumber) {
        if(vatNumber != null)
            this.vatNumber = vatNumber;
        else
            this.vatNumber = null;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}

