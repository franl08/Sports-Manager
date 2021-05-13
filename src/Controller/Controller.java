package Controller;
import Model.*;
import View.*;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model m, View v){
        this.model = m;
        this.view = v;
    }

    public int selectGoalkeeper(Team t) throws NotAGoalkeeperException, InvalidPlayerException{
        View.showPlayers(t.getPlayers());
        View.showMessage("Choose your goalkeeper inserting his/her number: ");
        Scanner in = new Scanner(System.in);
        int nPlayer = in.nextInt();
        if(t.getPlayers().containsKey(nPlayer)){
            if(t.getPlayers().get(nPlayer).getPosition().equals(Position.GOALKEEPER)) return nPlayer;
            else throw new NotAGoalkeeperException("Selected player isn't a goalkeeper");
        }
        else throw new InvalidPlayerException("Player with number " + nPlayer + " doesn't exist");
    }

    public Set<Integer> selectDefenders(Team t, int n) throws GKCantPlayOtherPosException, InvalidPlayerException{
        Team tmp = t.clone();
        Scanner in = new Scanner(System.in);
        Set<Integer> ans = new HashSet<>();
        int nPlayer = -1;
        for(int i = 0; i < n; i++) {
            View.showPlayers(tmp.getPlayers()); // IMPLEMENT THIS (SHOULD SHOW ALL AVAILABLE PLAYERS)
            View.showMessage("Choose your " + (i+1) + " defender inserting his/her number: ");
            nPlayer = in.nextInt();
            if(tmp.getPlayers().containsKey(nPlayer)){
                Player p = tmp.getPlayers().get(nPlayer);
                if(p.getPosition().equals(Position.GOALKEEPER)) throw new GKCantPlayOtherPosException("Goalkeeper can't play as Defender");
                else if(!p.getPosition().equals(Position.DEFENDER)){
                        DF toAdd = new DF(p);
                        ans.add(nPlayer);
                        tmp.getPlayers().remove(nPlayer);
                }
                else{
                    ans.add(nPlayer);
                    tmp.getPlayers().remove(nPlayer);
                }
            }
            else throw new InvalidPlayerException("Either player with number " + nPlayer + " doesn't exist on team or was already selected to lineup");
        }
        return ans;
    }

    public Set<Integer> selectWingers(Team t, int n) throws GKCantPlayOtherPosException, InvalidPlayerException{
        Team tmp = t.clone();
        Scanner in = new Scanner(System.in);
        Set<Integer> ans = new HashSet<>();
        int nPlayer = -1;
        for(int i = 0; i < n; i++) {
            View.showPlayers(tmp.getPlayers()); // IMPLEMENT THIS (SHOULD SHOW ALL AVAILABLE PLAYERS)
            View.showMessage("Choose your " + (i+1) + " winger inserting his/her number: ");
            nPlayer = in.nextInt();
            if(tmp.getPlayers().containsKey(nPlayer)){
                Player p = tmp.getPlayers().get(nPlayer);
                if(p.getPosition().equals(Position.GOALKEEPER)) throw new GKCantPlayOtherPosException("Goalkeeper can't play as Winger");
                else if(!p.getPosition().equals(Position.WINGER)){
                    WG toAdd = new WG(p);
                    ans.add(nPlayer);
                    tmp.getPlayers().remove(nPlayer);
                }
                else{
                    ans.add(nPlayer);
                    tmp.getPlayers().remove(nPlayer);
                }
            }
            else throw new InvalidPlayerException("Either player with number " + nPlayer + " doesn't exist on team or was already selected to lineup");
        }
        return ans;
    }

    public Set<Integer> selectMidfielders(Team t, int n) throws GKCantPlayOtherPosException, InvalidPlayerException{
        Team tmp = t.clone();
        Scanner in = new Scanner(System.in);
        Set<Integer> ans = new HashSet<>();
        int nPlayer = -1;
        for(int i = 0; i < n; i++) {
            View.showPlayers(tmp.getPlayers()); // IMPLEMENT THIS (SHOULD SHOW ALL AVAILABLE PLAYERS)
            View.showMessage("Choose your " + (i+1) + " midfielder inserting his/her number: ");
            nPlayer = in.nextInt();
            if(tmp.getPlayers().containsKey(nPlayer)){
                Player p = tmp.getPlayers().get(nPlayer);
                if(p.getPosition().equals(Position.GOALKEEPER)) throw new GKCantPlayOtherPosException("Goalkeeper can't play as Midfielder");
                else if(!p.getPosition().equals(Position.MIDFIELDER)){
                    MD toAdd = new MD(p);
                    ans.add(nPlayer);
                    tmp.getPlayers().remove(nPlayer);
                }
                else{
                    ans.add(nPlayer);
                    tmp.getPlayers().remove(nPlayer);
                }
            }
            else throw new InvalidPlayerException("Either player with number " + nPlayer + " doesn't exist on team or was already selected to lineup");
        }
        return ans;
    }

    public Set<Integer> selectForwards(Team t, int n) throws GKCantPlayOtherPosException, InvalidPlayerException{
        Team tmp = t.clone();
        Scanner in = new Scanner(System.in);
        Set<Integer> ans = new HashSet<>();
        int nPlayer = -1;
        for(int i = 0; i < n; i++) {
            View.showPlayers(tmp.getPlayers()); // IMPLEMENT THIS (SHOULD SHOW ALL AVAILABLE PLAYERS)
            View.showMessage("Choose your " + (i+1) + " forward inserting his/her number: ");
            nPlayer = in.nextInt();
            if(tmp.getPlayers().containsKey(nPlayer)){
                Player p = tmp.getPlayers().get(nPlayer);
                if(p.getPosition().equals(Position.GOALKEEPER)) throw new GKCantPlayOtherPosException("Goalkeeper can't play as Forward");
                else if(!p.getPosition().equals(Position.FORWARD)){
                    FW toAdd = new FW(p);
                    ans.add(nPlayer);
                    tmp.getPlayers().remove(nPlayer);
                }
                else{
                    ans.add(nPlayer);
                    tmp.getPlayers().remove(nPlayer);
                }
            }
            else throw new InvalidPlayerException("Either player with number " + nPlayer + " doesn't exist on team or was already selected to lineup");
        }
        return ans;
    }

    public void run(){

    }
}
