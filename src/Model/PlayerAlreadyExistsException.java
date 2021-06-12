package Model;

/**
 * Exception to prevent players with the same number
 */
public class PlayerAlreadyExistsException extends Exception{
    /**
     * Empty Constructor for Exception to prevent players with the same number
     */
    public PlayerAlreadyExistsException(){
        super();
    }

    /**
     * Constructor with a message for Exception to prevent players with the same number
     * @param s Message to show
     */
    public PlayerAlreadyExistsException(String s){
        super(s);
    }
}
