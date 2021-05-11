package Model;

public class NumberAlreadyExistsInTeamException extends Exception{
    public NumberAlreadyExistsInTeamException(){
        super();
    }

    public NumberAlreadyExistsInTeamException(String s){
        super(s);
    }
}
