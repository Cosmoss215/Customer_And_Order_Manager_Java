package model;

public class PaymentMethod {
    private String wording;
    private String iban;
    private String bic;

    public PaymentMethod(String wording, String iban, String bic) {
       setWording(wording);
       setIban(iban);
       setBic(bic);
    }

    public String getWording() {
        return wording;
    }

    public String getIban() {
        return iban;
    }

    public String getBic() {
        return bic;
    }

    private void setWording(String wording) {
        this.wording = wording;
    }

    private void setIban(String iban) {
        this.iban = iban;
    }

    private void setBic(String bic) {
        this.bic = bic;
    }
}
