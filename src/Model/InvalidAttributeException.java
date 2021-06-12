package Model;

public class InvalidAttributeException extends Exception
{
    /**
     * Empty Constructor for Exception to prevent invalid attributes
     */
    public InvalidAttributeException()
    {
        super();
    }

    /**
     * Constructor with a message for Exception to prevent invalid attributes
     * @param s Message to show
     */
    public InvalidAttributeException(String s)
    {
        super(s);
    }
}
