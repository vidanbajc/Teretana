package Exception;

public class OsobaVecPostojiException extends Exception{
    
    public OsobaVecPostojiException(String message){
        super("Greska: " + message);
    }
}
