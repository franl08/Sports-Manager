package Model;

public class PlayerAlreadyExistsException extends Exception{
    public PlayerAlreadyExistsException(){
        super();
    }

    public PlayerAlreadyExistsException(String s){
        super(s);
    }
}
