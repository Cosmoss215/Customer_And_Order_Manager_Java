package exception;

public class DBQueryException extends MainException{
    private final String typeError = "DB Query Exception";
    private final String message = "Can't acces to the DB";

    public String getTypeError(){ return typeError;}

    public String getMessage(){return message;}
}
