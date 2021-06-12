package Model;

public class PlayerAlreadyExistsException extends Exception{
    /**
     * Empty Constructor to prevent players with the same number
     */
    public PlayerAlreadyExistsException(){
        super();
    }

    public PlayerAlreadyExistsException(String s){
        super(s);
    }
}
