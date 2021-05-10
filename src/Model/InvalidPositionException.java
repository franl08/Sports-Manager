package Model;

public class InvalidPositionException extends Exception{
    public InvalidPositionException(){
        super();
    }

    public InvalidPositionException(String s){
        super(s);
    }
}
