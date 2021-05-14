package Model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Team {
    private String id;
    private String name;
    private Map<Integer, Player> players;
    private Set<Game> gamesHistory;

    public Team(){
        this.id = "n/a";
        this.name = "n/a";
        this.players = new HashMap<>();
        this.gamesHistory = new HashSet<>();
    }

    public Team(String id, String name) {
        this.id = id;
        this.name = name;
        this.players = new HashMap<>();
        this.gamesHistory = new HashSet<>();
    }

    public Team(String id, String name, Map<Integer, Player> players) {
        this.id = id;
        this.name = name;
        try{
            this.setPlayers(players);
        }
        catch (NumberAlreadyExistsInTeamException i){
            i.printStackTrace();
        }
        this.gamesHistory = new HashSet<>();
    }

    public Team(String id, String name, Map<Integer, Player> players, Set<Game> gamesHistory) {
        this.id = id;
        this.name = name;
        try{
            this.setPlayers(players);
        }
        catch (NumberAlreadyExistsInTeamException i){
            i.printStackTrace();
        }
        this.setGamesHistory(gamesHistory);
    }

    public Team(Team t){
        this.id = t.getId();
        this.name = t.getName();
        try{
            this.setPlayers(players);
        }
        catch (NumberAlreadyExistsInTeamException i){
            i.printStackTrace();
        }
        this.setGamesHistory(t.getGamesHistory());
    }

    public Team clone(){
        return new Team(this);
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlayers(Map<Integer, Player> players) throws NumberAlreadyExistsInTeamException{
        if (players != null && !players.isEmpty())
            for(Player p : players.values()) {
                if (this.players.containsKey(p.getNumber()))
                    throw new NumberAlreadyExistsInTeamException("There is already a player with number" + p.getNumber());
                else this.players.put(p.getNumber(), p.clone());
            }
        else
            this.players = new HashMap<>();
    }

    public Map<Integer, Player> getPlayers(){
        Map<Integer, Player> ans = new HashMap<>();
        if(this.players != null) {
            for (Player p : this.players.values())
                ans.put(p.getNumber(), p.clone());
        }
        return ans;
    }

    public Set<Game> getGamesHistory(){
        Set<Game> ans = new HashSet<>();
        for(Game g : this.gamesHistory)
            ans.add(g.clone());
        return ans;
    }

    public void setGamesHistory(Set<Game> gamesHistory){
        for(Game g : gamesHistory)
            this.gamesHistory.add(g.clone());
    }

    public String toString(){
        StringBuilder sb = new StringBuilder("Team: ")
                .append(name).append("\n")
                .append("Players: ").append(players.toString());
        return sb.toString();
    }

    public boolean equals(Object o){
        if(this == o) return true;
        else if(o == null || this.getClass() != o.getClass()) return false;
        Team t = (Team) o;
        return (this.id.equals(t.getId()));
    }

    public void addPlayer(Player p) throws NumberAlreadyExistsInTeamException{
        if(this.players.containsKey(p.getNumber())) throw new NumberAlreadyExistsInTeamException("There is already a player with number " + p.getNumber());
        else{
            this.players.put(p.getNumber(), p.clone());
        }
    }

}
