package Model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Model {
    private Map<String, Team> teams;
    private Map<String, Player> players;

    public Model(){
        this.teams = new HashMap<>();
        this.players = new HashMap<>();
    }

    public Model(Map<String, Team> teams, Map<String, Player> players) {
        this.setTeams(teams);
        this.setPlayers(players);
    }

    public Map<String, Team> getTeams() {
        Map<String, Team> ans = new HashMap<>();
        for(Team t : this.teams.values())
            ans.put(t.getName(), t.clone());
        return ans;
    }

    public void setTeams(Map<String, Team> teams) {
        this.teams = new HashMap<>();
        for(Team t : teams.values())
            this.teams.put(t.getName(), t.clone());
    }

    public Map<String, Player> getPlayers() {
        Map<String, Player> ans = new HashMap<>();
        for(Player p : this.players.values())
            ans.put(p.getId(), p.clone());
        return ans;
    }

    public void setPlayers(Map<String, Player> players) {
        this.players = new HashMap<>();
        for(Player p : players.values())
            this.players.put(p.getId(), p.clone());
    }

    public void removeTeam(String name){
        this.teams.remove(name);
        for(Player p : this.players.values())
            if(p.getCurrentTeam().getName().equals(name))
                this.players.remove(p.getId());
    }

    public void removePlayerFromTeam(String pID, Team t) throws InvalidPlayerException{
        Player p = this.players.get(pID);
        if(!this.players.containsKey(pID)) throw new InvalidPlayerException("Player " + pID + " doesn't exist on database");
        else if(!this.teams.get(t.getName()).getPlayers().containsKey(p.getNumber())) throw new InvalidPlayerException("Player " + pID + " doesn't exist on team " + t.getName());
        else t.getPlayers().remove(p.getNumber());
    }

    public void removePlayer(String ID){
        for(Team t : this.teams.values()){
            try{
                removePlayerFromTeam(ID, t);
            }
            catch (InvalidPlayerException i){
                i.printStackTrace();
            }
        }
        this.players.remove(ID);
    }

    public void transferPlayer(String pID, String tName){
        Player p = this.players.get(pID);
        Team t = this.teams.get(tName);
        try{
            removePlayerFromTeam(pID, t);
        }
        catch (InvalidPlayerException i){
            i.printStackTrace();
        }
        p.changeTeam(t);
    }

    public void addPlayer(Player p) throws PlayerAlreadyExistsException, InvalidTeamException{
        if(this.players.containsValue(p)) throw new PlayerAlreadyExistsException("Player " + p.getId() + " already exists in database");
        else if(!(this.teams.containsValue(p.getCurrentTeam()))) throw new InvalidTeamException("Team " + p.getCurrentTeam().getId() + " doesn't exist on database");
        else {
            this.players.put(p.getId(), p.clone());
            Team t = this.teams.get(p.getCurrentTeam().getName());
            try{
                t.addPlayer(p.clone());
            }
            catch(NumberAlreadyExistsInTeamException i){
                i.printStackTrace();
            }
        }
    }

    public void addTeam(Team t) throws TeamAlreadyExistsException, PlayerAlreadyExistsException{
        int flag = 1;
        if(this.teams.containsValue(t)) throw new TeamAlreadyExistsException("Team " + t.getId() + " already exists in database");
        else {
            for(Player p : t.getPlayers().values()){
                if(this.players.containsValue(p)) throw new PlayerAlreadyExistsException("Player " + p.getId() + " already exists in database");
            }
            this.teams.put(t.getId(), t.clone());
        }
    }

    public Player getPlayerWithID(String ID){
        return this.players.get(ID).clone();
    }

    public boolean containsPlayerInTeam(String teamName, int playerNum){
        return this.teams.get(teamName).getPlayers().containsKey(playerNum);
    }

    public Team getTeamWithName(String name){
        return this.teams.get(name).clone();
    }
}