package Model;

import java.util.*;

public class Team {
    private String name;
    private Map<Integer, Player> players;
    private List<Game> gamesHistory;

    /**
     * Empty Constructor
     */
    public Team(){
        this.name = "n/a";
        this.players = new HashMap<>();
        this.gamesHistory = new ArrayList<Game>();
    }

    /**
     * Constructor with team name
     * @param name Team name
     */
    public Team(String name) {
        this.name = name;
        this.players = new HashMap<>();
        this.gamesHistory = new ArrayList<Game>();
    }

    /**
     * Constructor with team name and players
     * @param name Team name
     * @param players Team players
     */
    public Team(String id, String name, Map<Integer, Player> players) {
        this.name = name;
        try{
            this.setPlayers(players);
        }
        catch (NumberAlreadyExistsInTeamException i){
            i.printStackTrace();
        }
        this.gamesHistory = new ArrayList<Game>();
    }

    /**
     * Constructor with team name, players and games history
     * @param name Team Name
     * @param players Team Players
     * @param gamesHistory Team games history
     */
    public Team(String id, String name, Map<Integer, Player> players, List<Game> gamesHistory) {
        this.name = name;
        try{
            this.setPlayers(players);
        }
        catch (NumberAlreadyExistsInTeamException i){
            i.printStackTrace();
        }
        this.setGamesHistory(gamesHistory);
    }

    /**
     * Copy constructor
     * @param t Team to copy
     */
    public Team(Team t){
        this.name = t.getName();
        try{
            this.setPlayers(players);
        }
        catch (NumberAlreadyExistsInTeamException i){
            i.printStackTrace();
        }
        this.setGamesHistory(t.getGamesHistory());
    }

    /**
     * Cloning method
     * @return Cloned team
     */
    public Team clone(){
        return new Team(this);
    }

    /**
     * Name getter
     * @return Team name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Name setter
     * @param name Name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Players setter
     * @param players Players to set
     * @throws NumberAlreadyExistsInTeamException Exception to prevent players with the same number
     */
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

    /**
     * Players getter
     * @return Team Players
     */
    public Map<Integer, Player> getPlayers(){
        Map<Integer, Player> ans = new HashMap<>();
        if(this.players != null) {
            for (Player p : this.players.values())
                ans.put(p.getNumber(), p.clone());
        }
        return ans;
    }

    /**
     * Games history getter
     * @return Games history
     */
    public List<Game> getGamesHistory(){
        List<Game> ans = new ArrayList<>();
        if(this.gamesHistory != null)
        {
            for(Game g : this.gamesHistory)
                ans.add(g.clone());
        }
        return ans;
    }

    /**
     * Games history setter
     * @param gamesHistory Games history to set
     */
    public void setGamesHistory(List<Game> gamesHistory){
        for(Game g : gamesHistory)
            this.gamesHistory.add(g.clone());
    }

    /**
     * Method to get team as a String
     * @return Team as a string
     */
    public String toString(){
        StringBuilder sb = new StringBuilder("Team: ")
                .append(name).append("\n")
                .append("Players: ").append(players.toString());
        return sb.toString();
    }

    /**
     * Method to check if an object is equal to a Team
     * @param o Object to check
     * @return True if they are equal, false otherwise
     */
    public boolean equals(Object o){
        if(this == o) return true;
        else if(o == null || this.getClass() != o.getClass()) return false;
        Team t = (Team) o;
        return (this.name.equals(t.getName()) && this.players.equals(t.getPlayers()) && this.gamesHistory.equals(t.getGamesHistory()));
    }

    /**
     * Method to add a player to a team
     * @param p Player to add
     * @throws NumberAlreadyExistsInTeamException Exception to prevent players with the same number
     */
    public void addPlayer(Player p) throws NumberAlreadyExistsInTeamException{
        if(this.players.containsKey(p.getNumber())) throw new NumberAlreadyExistsInTeamException("There is already a player with number " + p.getNumber());
        else{
            this.players.put(p.getNumber(), p.clone());
        }
    }

    /**
     * Method to see what numbers a team currently has
     * @return Used numbers
     */
    public Set<Integer> usedNumbers(){
       return new HashSet<>(this.players.keySet());
    }

    /**
     *
     */
    public void removePlayer(int number){
        this.players.remove(number);
    }

}
