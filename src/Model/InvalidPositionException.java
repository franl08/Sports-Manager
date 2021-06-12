package Model;

public class InvalidPositionException extends Exception{
    /**
     * Empty Constructor for Exception to prevent invalid positions
     */
    public InvalidPositionException(){
        super();
    }

    /**
     * Constructor with a message for Exception to prevent invalid positions
     * @param s Message to show
     */
    public InvalidPositionException(String s){
        super(s);
    }
}
