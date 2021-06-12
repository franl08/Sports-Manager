package Controller;

/**
 * Exception to prevent values out of bounds
 */
public class ValueOutofBoundsException extends Exception
{
    /**
     * Empty Constructor for Exception to prevent values out of bounds
     */
    public ValueOutofBoundsException(){
        super();
    }

    /**
     * Constructor with a message for Exception to prevent values out of bounds
     * @param s Message to show
     */
    public ValueOutofBoundsException(String s){
        super(s);
    }
}
