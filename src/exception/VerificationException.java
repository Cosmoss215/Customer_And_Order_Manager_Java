package exception;

public class VerificationException extends MainException{
    private final String typeError = "Verification exception";
    private final String message = "There was an error during verification. ";
    private String attribut;

    public VerificationException(String attribut) {
        this.attribut = attribut;
    }

    public String getTypeError() {
        return typeError;
    }

    public String getMessage() {
        return message + "This attribut \'" + attribut + "\' does not respect the correct format.";
    }
}