package exception;

public class UpdateQueryException extends MainException {
    private final String typeError = "DB Update Query Exception";
    private final String message = "Update query went wrong : ";
    private String compilerMessage;

    public UpdateQueryException(String compilerMessage){
        this.compilerMessage = compilerMessage;
    }

    public String getTypeError(){ return typeError; }

    public String getMessage(){ return message + compilerMessage; }
}
