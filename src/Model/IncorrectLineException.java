package Model;

public class IncorrectLineException extends Exception{
    public IncorrectLineException(){
        super();
    }

    public IncorrectLineException(String s){
        super(s);
    }
}
