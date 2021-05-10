package Model;

public class TeamAlreadyExistsException extends Exception{
    public TeamAlreadyExistsException(){
        super();
    }
    public TeamAlreadyExistsException(String s){
        super(s);
    }
}
