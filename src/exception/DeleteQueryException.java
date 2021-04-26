package exception;

public class DeleteQueryException extends MainException {
    private final String typeError = "DB Delete Query Exception";
    private final String message = "Delete query went wrong";

    public String getTypeError(){ return typeError; }

    public String getMessage(){ return message; }
}
