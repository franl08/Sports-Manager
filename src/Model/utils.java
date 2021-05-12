package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class utils {

    public static int setRandomAttribute(){
        Random n = new Random();
        return(n.nextInt(99) + 1);
    }

    public static boolean randGoal(int attOv, int defOv){
        Random n = new Random();
        boolean ans = false;
        int dif = attOv - defOv;
        int bingo = n.nextInt(99);
        List<Integer> randNumsAtt = new ArrayList<>();
        List<Integer> randNumsDef = new ArrayList<>();
        if(dif > 0){
            for(int i = 0; i < dif; i++)
                randNumsAtt.add(utils.getRandNum());
            ans = randNumsAtt.contains(bingo);
        }
        else if(dif == 0){
            for(int i = 0; i < attOv; i++){
                randNumsAtt.add(utils.getRandNum());
                randNumsDef.add(utils.getRandNum());
            }
            if(randNumsAtt.contains(bingo) && randNumsDef.contains(bingo)){
                int headsOrTails = n.nextInt(2);
                ans = headsOrTails == 0;
            }
            ans = randNumsAtt.contains(bingo);
        }
        else{
            for(int i = 0; i < Math.abs(dif); i++)
                randNumsDef.add(utils.getRandNum());
            if(!randNumsDef.contains(bingo)){
                int anotherBingo = n.nextInt(Math.abs(dif)), luckyOne = n.nextInt(Math.abs(dif));
                ans = anotherBingo == luckyOne;
            }
        }
        return ans;
    }

    public static int getRandNum(){
        Random n = new Random();
        return n.nextInt(99);
    }
}
