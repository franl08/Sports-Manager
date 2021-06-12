package Model;

/**
 * Exception to control that the maximum number of substitutions isn't exceeded
 */
public class NumberOfMaximumSubsException extends Exception{
    /**
     * Empty Constructor for Exception to control that the maximum number of substitutions isn't exceeded
     */
    public NumberOfMaximumSubsException(){
        super();
    }

    /**
     * Constructor with a message for Exception to control that the maximum number of substitutions isn't exceeded
     * @param s Message to show
     */
    public NumberOfMaximumSubsException(String s){
        super(s);
    }
}
