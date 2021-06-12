package Model;

/**
 * Exception to prevent that non goalkeepers doesn't play at goalkeeper
 */
public class NotAGoalkeeperException extends Exception{
    /**
     * Empty Constructor for Exception to prevent other player to play at Goalkeeper Position
     */
    public NotAGoalkeeperException(){
        super();
    }

    /**
     * Constructor with a message for Exception to prevent other player to play at Goalkeeper Position
     * @param s Message to show
     */
    public NotAGoalkeeperException(String s){
        super(s);
    }
}
