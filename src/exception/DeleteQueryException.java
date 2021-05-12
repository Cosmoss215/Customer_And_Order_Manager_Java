package exception;

public class DeleteQueryException extends MainException {
    private final String typeError = "DB Delete Query Exception";
    private final String message = "Delete query went wrong : ";

    private String compilerMessage;

    public DeleteQueryException(String compilerMessage){
        this.compilerMessage = compilerMessage;
    }

    public String getTypeError(){ return typeError; }

    public String getMessage(){ return message + compilerMessage; }
}
