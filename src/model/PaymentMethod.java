package model;

public class PaymentMethod {
    private String wording;
    private String iban;
    private String bic;

    public PaymentMethod(String wording, String iban, String bic) {
        this.wording = wording;
        this.iban = iban;
        this.bic = bic;
    }

    public String getWording() {
        return wording;
    }
}
