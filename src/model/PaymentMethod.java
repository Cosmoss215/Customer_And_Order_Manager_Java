package model;

public class PaymentMethod {
    private String wording;

    public PaymentMethod(String wording) {
        this.wording = wording;
    }
    @Override
    public String toString() {
        return wording;
    }
}
