package Exception;

public class OsobaNijePronadjenaException extends Exception{
    
    public OsobaNijePronadjenaException(String message){
        super("Obavestenje" + message);
    }
}
