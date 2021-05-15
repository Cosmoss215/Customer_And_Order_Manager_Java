package exception;

public class NullException extends MainException{
    private final String typeError = "Null exception";
    private final String message = "A method received a null object";
    private String object;

    public NullException(String object){
        this.object = object;
    }

    public String getTypeError(){
        return typeError;
    }

    public String getMessage(){
        return message + "It was : " + object ;
    }
}