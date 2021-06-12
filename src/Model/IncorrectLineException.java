package Model;

public class IncorrectLineException extends Exception{
    /**
     * Empty Constructor for Exception to prevent wrong lines from logs file
     */
    public IncorrectLineException(){
        super();
    }

    /**
     * Constructor for Exception to prevent wrong lines from logs file
     * @param s
     */
    public IncorrectLineException(String s){
        super(s);
    }
}
