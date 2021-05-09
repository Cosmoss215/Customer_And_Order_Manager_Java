package exception;

import model.Order;

public class OrderStateException extends MainException {
    private final String typeError = "Illegal Order state";
    private final String message = "The only valid values for the Order state are : ";

    public String getTypeError(){ return typeError; }

    public String getMessage(){ return message + getValues(); }

    private String getValues(){
        String values = "";
        for(int i = 0; i < Order.STATES_NUMBER; i++){
            values += "\"" + Order.states[i] + "\" ";
        }
        return values += ".";
    }
}
