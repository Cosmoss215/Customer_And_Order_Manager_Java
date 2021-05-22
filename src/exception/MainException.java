package exception;

public abstract class MainException extends Exception {
    @Override
    public abstract String getMessage();
    public abstract String getTypeError();
}
