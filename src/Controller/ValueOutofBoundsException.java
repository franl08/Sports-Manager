package Controller;

public class ValueOutofBoundsException extends Exception
{
    public ValueOutofBoundsException(){
        super();
    }

    public ValueOutofBoundsException(String s){
        super(s);
    }
}
