package exception;

public class ThreadException extends MainException{
    private final String typeError = "Thread Exception";
    private final String message = "An exception was noted in the thread part, check. Pay attention to the image file.";

    public String getTypeError(){
        return typeError;
    }

    public String getMessage(){
        return message;
    }
}
