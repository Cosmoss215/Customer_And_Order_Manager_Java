package exception;

public class UpdateQueryException extends MainException {
    private final String typeError = "DB Update Query Exception";
    private final String message = "Update query went wrong";

    public String getTypeError(){ return typeError; }

    public String getMessage(){ return message; }
}
