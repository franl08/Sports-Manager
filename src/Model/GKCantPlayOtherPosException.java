package Model;

/**
 * Exception to prevent goalkeepers to play out of position
 */
public class GKCantPlayOtherPosException extends Exception{
    /**
     * Empty Constructor for Exception to prevent Goalkeepers from playing on other positions
     */
    public GKCantPlayOtherPosException(){
        super();
    }

    /**
     * Constructor with a message for Exception to prevent Goalkeepers from playing on other positions
     * @param s Message to show
     */
    public GKCantPlayOtherPosException(String s){
        super(s);
    }
}
