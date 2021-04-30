package Model;

import java.util.HashMap;
import java.util.Map;

public class DataBase {
    private Map<String, Team> teams;
    private Map<String, Player> players;

    public DataBase(){
        this.teams = new HashMap<>();
        this.players = new HashMap<>();
    }

    public DataBase(Map<String, Team> teams, Map<String, Player> players) {
        this.setTeams(teams);
        this.setPlayers(players);
    }

    public Map<String, Team> getTeams() {
        Map<String, Team> ans = new HashMap<String, Team>();
        for(Team t : this.teams.values())
            ans.put(t.getId(), t.clone());
        return ans;
    }

    public void setTeams(Map<String, Team> teams) {
        this.teams = new HashMap<String, Team>();
        for(Team t : teams.values())
            this.teams.put(t.getId(), t.clone());
    }

    public Map<String, Player> getPlayers() {
        Map<String, Player> ans = new HashMap<String, Player>();
        for(Player p : this.players.values())
            ans.put(p.getId(), p.clone());
        return ans;
    }

    public void setPlayers(Map<String, Player> players) {
        this.players = new HashMap<String, Player>();
        for(Player p : players.values())
            this.players.put(p.getId(), p.clone());
    }

    public void removeTeam(String ID){
        this.teams.remove(ID);
        for(Player p : this.players.values())
            if(p.getCurrentTeam().getId().equals(ID)) this.players.remove(p.getId());
    }

    public void removePlayerFromTeam(String pID, Team t){
        Player p = this.players.get(pID);
        t.getGoalkeepers().removeIf(g -> g.equals(p));
        t.getDefenders().removeIf(d -> d.equals(p));
        t.getMidfielders().removeIf(m -> m.equals(p));
        t.getWingers().removeIf(w -> w.equals(p));
        t.getForwards().removeIf(f -> f.equals(p));
    }

    public void removePlayer(String ID){
        for(Team t : this.teams.values()){
            removePlayerFromTeam(ID, t);
        }
        this.players.remove(ID);
    }

    public void transferPlayer(String pID, String tID){
        Player p = this.players.get(pID);
        Team t = this.teams.get(tID);
        removePlayerFromTeam(pID, t);
        p.changeTeam(t);
    }


}
