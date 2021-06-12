package Model;

/**
 * Exception to prevent teams with the same name
 */
public class TeamAlreadyExistsException extends Exception{
    /**
     * Empty Constructor for Exception to prevent teams with the same name
     */
    public TeamAlreadyExistsException(){
        super();
    }

    /**
     * Constructor with a message for Exception to prevent teams with the same name
     * @param s Message to show
     */
    public TeamAlreadyExistsException(String s){
        super(s);
    }
}
