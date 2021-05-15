package exception;

public class ConnectionException extends MainException{
    private final String typeError = "Connection Exception";
    private final String message = "Unable to connect the DB : ";
    private String compilerMessage;

    public ConnectionException(String compilerMessage){
        this.compilerMessage = compilerMessage;
    }

    public String getTypeError(){ return typeError; }

    public String getMessage(){ return message + compilerMessage; }
}

