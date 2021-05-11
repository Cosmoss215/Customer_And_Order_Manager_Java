package model;

public class CustomerByProduct {
    private String lastName;
    private String firstName;
    private Integer quantity;
    private String wordingPaymentMethod;

    public CustomerByProduct(String lastName, String firstName, Integer quantity, String wordingPaymentMethod) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.quantity = quantity;
        this.wordingPaymentMethod = wordingPaymentMethod;
    }
    //region getter
    public String getLastName() {
        return lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public String getWordingPaymentMethod() {
        return wordingPaymentMethod;
    }
    //endregion
}
