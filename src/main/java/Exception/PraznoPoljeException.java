package Exception;

public class PraznoPoljeException extends Exception{
    
    public PraznoPoljeException(String message){
        super("Greska: " + message);
    }
}
