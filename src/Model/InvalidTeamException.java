package Model;

public class InvalidTeamException extends Exception{
    public InvalidTeamException(){
        super();
    }

    public InvalidTeamException(String s){
        super(s);
    }
}
