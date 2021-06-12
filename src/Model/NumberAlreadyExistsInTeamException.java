package Model;

public class NumberAlreadyExistsInTeamException extends Exception{
    /**
     * Empty Constructor for Exception to prevent players with the same number in the same team
     */
    public NumberAlreadyExistsInTeamException(){
        super();
    }

    /**
     * Constructor with a message for Exception to prevent players with the same number in the same team
     * @param s
     */
    public NumberAlreadyExistsInTeamException(String s){
        super(s);
    }
}
