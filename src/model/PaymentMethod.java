package model;

public class PaymentMethod {
    private String wording;
    private Integer iban;
    private String bic;

    public PaymentMethod(String wording, Integer iban, String bic) {
       setWording(wording);
       setIban(iban);
       setBic(bic);
    }

    public String getWording() {
        return wording;
    }

    public Integer getIban() {
        return iban;
    }

    public String getBic() {
        return bic;
    }

    private void setWording(String wording) {
        this.wording = wording;
    }

    private void setIban(Integer iban) {
        this.iban = iban;
    }

    private void setBic(String bic) {
        this.bic = bic;
    }
}
