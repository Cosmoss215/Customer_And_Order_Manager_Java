package exception;

public class NullException extends MainException{
    private final String typeError = "Null exception";
    private final String message = "A method received a null object";

    public String getTypeError(){ return typeError; }

    public String getMessage(){ return message; }
}