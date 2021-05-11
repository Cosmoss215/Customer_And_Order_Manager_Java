package exception;

public class VerificationException extends MainException{
    private final String typeError = "Verification exception";
    private final String message = "There was an error raising during verification.";
    private String attribut;

    public VerificationException(String attribut){
        this.attribut = attribut;
    }
    public String getTypeError(){ return typeError; }

    public String getMessage(){ return message + "This attribut " + attribut + " do not respect the correct format."; }
}