package exception;

public class CreateQueryException extends MainException {
    private final String typeError = "DB Create Query Exception";
    private final String message = "Create query went wrong : ";
    private String compilerMessage;

    public CreateQueryException(String CompilerMessage){
        this.compilerMessage = CompilerMessage;
    }

    public String getTypeError(){ return typeError; }

    public String getMessage(){ return message + compilerMessage; }
}
