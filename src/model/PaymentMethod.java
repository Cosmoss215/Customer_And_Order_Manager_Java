package model;

public class PaymentMethod {
    private final String wording;
    private final Integer iban;
    private final String bic;

    public PaymentMethod(String wording, int iban, String bic) {
        this.wording = wording;
        this.iban = iban;
        this.bic = bic;
    }
}
