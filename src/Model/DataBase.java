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

    public void addPlayer(Player p) throws PlayerAlreadyExistsException, InvalidTeamException{
        if(this.players.containsValue(p)) throw new PlayerAlreadyExistsException("Player " + p.getId() + " already exists in database");
        else if(!(this.teams.containsValue(p.getCurrentTeam()))) throw new InvalidTeamException("Team " + p.getCurrentTeam().getId() + " doesn't exist on database");
        else {
            this.players.put(p.getId(), p.clone());
            Team t = this.teams.get(p.getCurrentTeam());
            try{
                t.addPlayer(p.clone());
            }
            catch(InvalidPositionException i){
                i.printStackTrace();
            }
        }
    }

    public void addTeam(Team t) throws TeamAlreadyExistsException, PlayerAlreadyExistsException{
        int flag = 1;
        if(this.teams.containsValue(t)) throw new TeamAlreadyExistsException("Team " + t.getId() + " already exists in database");
        else {
            for (GK g : t.getGoalkeepers()) {
                if (this.players.containsValue(g))
                    throw new PlayerAlreadyExistsException("Player " + g.getId() + " already exists in database");
                else this.players.put(g.getId(), g.clone());
            }
            for (DF d : t.getDefenders()) {
                if (this.players.containsValue(d))
                    throw new PlayerAlreadyExistsException("Player " + d.getId() + " already exists in database");
                else this.players.put(d.getId(), d.clone());
            }
            for (WG w : t.getWingers()) {
                if (this.players.containsValue(w))
                    throw new PlayerAlreadyExistsException("Player " + w.getId() + " already exists in database");
                else this.players.put(w.getId(), w.clone());
            }
            for (MD m : t.getMidfielders()) {
                if (this.players.containsValue(m))
                    throw new PlayerAlreadyExistsException("Player " + m.getId() + " already exists in database");
                else this.players.put(m.getId(), m.clone());
            }
            for(FW f : t.getForwards()) {
                if (this.players.containsValue(f))
                    throw new PlayerAlreadyExistsException("Player " + f.getId() + " already exists in database");
                else this.players.put(f.getId(), f.clone());
            }
        }
        this.teams.put(t.getId(), t.clone());
    }
}
