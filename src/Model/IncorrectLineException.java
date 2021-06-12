package Model;

/**
 * Exception to prevent incorrect lines on logs
 */
public class IncorrectLineException extends Exception{
    /**
     * Empty Constructor for Exception to prevent wrong lines from logs file
     */
    public IncorrectLineException(){
        super();
    }

    /**
     * Constructor for Exception to prevent wrong lines from logs file
     * @param s Message to show
     */
    public IncorrectLineException(String s){
        super(s);
    }
}
