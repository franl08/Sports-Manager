package Model;

/**
 * Exception to prevent invalid teams
 */
public class InvalidTeamException extends Exception{
    /**
     * Empty Constructor for Exception to prevent invalid teams
     */
    public InvalidTeamException(){
        super();
    }

    /**
     * Constructor with a message for Exception to prevent invalid teams
     * @param s Message to show
     */
    public InvalidTeamException(String s){
        super(s);
    }
}
