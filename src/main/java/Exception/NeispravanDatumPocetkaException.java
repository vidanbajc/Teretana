package Exception;

public class NeispravanDatumPocetkaException extends Exception {
    
    public NeispravanDatumPocetkaException(String message){
        super("Greska: " + message);
    }
}
