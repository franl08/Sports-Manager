package Model;

/**
 * Exception to prevent invalid players
 */
public class InvalidPlayerException extends Exception{

    /**
     * Empty Constructor for Exception to prevent invalid players
     */
    public InvalidPlayerException(){
        super();
    }

    /**
     * Constructor with a message for Exception to prevent invalid players
     * @param s Message to show
     */
    public InvalidPlayerException(String s){
        super(s);
    }
}
