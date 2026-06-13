package Exception;

public class NeispravnaVrednostException extends Exception{
    
    public NeispravnaVrednostException(String message){
        super("Greska: " + message);
    }
}
