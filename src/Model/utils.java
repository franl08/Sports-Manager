package Model;

import java.util.Random;

public class utils {

    public static int setRandomAttribute(){
        Random n = new Random();
        return(n.nextInt(99) + 1);
    }
}
