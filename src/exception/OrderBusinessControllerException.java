package exception;

public class OrderBusinessControllerException extends MainException{

    private final String typeError = "Unit test excpetion";
    private final String message = "Warning : ";
    private String compilerMessage;

    public OrderBusinessControllerException(String message){
        this.compilerMessage = message;
    }

    public String getTypeError(){ return typeError; }

    public String getMessage(){ return message + compilerMessage; }
}
