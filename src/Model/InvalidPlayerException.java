package Model;

public class InvalidPlayerException extends Exception{

    public InvalidPlayerException(){
        super();
    }

    public InvalidPlayerException(String s){
        super(s);
    }
}
