package exception;

public class SelectQueryException extends MainException{
    private final String typeError = "DB Select Query Exception";
    private final String message = "Select query went wrong : ";
    String compilerMessage;

    public SelectQueryException(String compilerMessage) { this.compilerMessage = compilerMessage; }

    public String getTypeError(){ return typeError; }

    public String getMessage(){ return message + compilerMessage; }
}
