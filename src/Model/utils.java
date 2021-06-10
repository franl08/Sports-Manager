package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class utils {
    private static final int max = 99;

    /**
     * Function to calculate a random value to an attribute
     * @return a random int between 1 and 99
     */
    public static int setRandomAttribute(){
        return(getRandNum(max) + 1);
    }

    /**
     * Method to calculate if the attacking team scores a goal
     * @param attOv Attacking overall of the team to score
     * @param defOv Defense overall of the team to defend
     * @return True in case of goal, False otherwise
     */
    public static boolean randGoal(int attOv, int defOv){
        Random n = new Random();
        boolean ans = false;
        int dif = attOv - defOv;
        int bingo = n.nextInt(max);
        List<Integer> randNumsAtt = new ArrayList<>();
        List<Integer> randNumsDef = new ArrayList<>();
        if(dif > 0){
            for(int i = 0; i < dif; i++)
                randNumsAtt.add(utils.getRandNum(max));
            ans = randNumsAtt.contains(bingo);
        }
        else if(dif == 0){
            for(int i = 0; i < attOv; i++){
                randNumsAtt.add(utils.getRandNum(max));
                randNumsDef.add(utils.getRandNum(max));
            }
            if(randNumsAtt.contains(bingo) && randNumsDef.contains(bingo)){
                int headsOrTails = n.nextInt(2);
                ans = headsOrTails == 0;
            }
            else ans = randNumsAtt.contains(bingo);
        }
        else{
            for(int i = 0; i < Math.abs(dif); i++)
                randNumsDef.add(utils.getRandNum(max));
            if(!randNumsDef.contains(bingo)){
                int anotherBingo = n.nextInt(Math.abs(dif)), luckyOne = n.nextInt(Math.abs(dif));
                ans = anotherBingo == luckyOne;
            }
        }
        return ans;
    }

    /**
     * Method to calculate team to have ball possession
     * @param homeOv Controlling overall of home team
     * @param awayOv Controlling overall of away team
     * @return true in case of ball to Home Team or false in case of to Away Team
     */
    public static boolean randPossession(int homeOv, int awayOv){
        Random n = new Random();
        boolean ans = false;
        int dif = homeOv - awayOv;
        int bingo = n.nextInt(10);
        List<Integer> randNumsHome = new ArrayList<>();
        List<Integer> randNumsAway = new ArrayList<>();
        if(dif > 0){
            for(int i = 0; i < dif; i++)
                randNumsHome.add(n.nextInt(10));
            ans = randNumsHome.contains(bingo);
        }
        else if (dif == 0){
            for(int i = 0; i < homeOv; i++){
                randNumsHome.add(bingo);
                randNumsAway.add(bingo);
            }
            if(randNumsHome.contains(bingo) && randNumsAway.contains(bingo)){
                int headsOrTails = n.nextInt(2);
                ans = headsOrTails == 0;
            }
            else ans = randNumsHome.contains(bingo);
        }
        else{
            for(int i = 0; i < Math.abs(dif); i++)
                randNumsAway.add(n.nextInt(10));
            ans = !randNumsAway.contains(bingo);
        }
        return ans;
    }

    /**
     * Method to calculate random numbers between 0 and lim - 1
     * @param lim limit to random
     * @return random int
     */
    public static int getRandNum(int lim){
        Random n = new Random();
        return n.nextInt(lim);
    }
}
