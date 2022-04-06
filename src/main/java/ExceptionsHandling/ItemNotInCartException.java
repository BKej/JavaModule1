package ExceptionsHandling;

public class ItemNotInCartException extends Exception {

    public ItemNotInCartException(String message){
        super(message);
    }
}
