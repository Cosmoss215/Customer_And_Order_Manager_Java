package exception;

public class FormException extends MainException{
    private final String typeError = "Form Exception";
    private final String message = "there is an error in the form";

    public String getTypeError(){
        return typeError;
    }

    public String getMessage(){
        return message;
    }
}