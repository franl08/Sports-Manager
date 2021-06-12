package Model;

import java.io.Serializable;
import java.util.*;

public class Team implements Serializable {
    /**
     * Team's name
     */
    private String name;
    /**
     * Team's players
     */
    private Map<Integer, Player> players;
    /**
     * Team's games history
     */
    private List<HistoryGame> gamesHistory;
    /**
     * Team's overall
     */
    private int overall;
    /**
     * Empty Constructor
     */
    public Team(){
        this.name = "n/a";
        this.players = new HashMap<>();
        this.gamesHistory = new ArrayList<>();
        this.overall = 0;
    }

    /**
     * Constructor with team name
     * @param name Team name
     */
    public Team(String name) {
        this.name = name;
        this.players = new HashMap<>();
        this.gamesHistory = new ArrayList<>();
        this.overall = 0;
    }

    /**
     * Constructor with team name and players
     * @param name Team name
     * @param players Team players
     */
    public Team(String name, Map<Integer, Player> players) {
        this.name = name;
        try{
            this.setPlayers(players);
        }
        catch (NumberAlreadyExistsInTeamException i){
            i.printStackTrace();
        }
        this.gamesHistory = new ArrayList<>();
        this.calcOverall();
    }

    /**
     * Constructor with team name, players and games history
     * @param name Team Name
     * @param players Team Players
     * @param gamesHistory Team games history
     */
    public Team(String name, Map<Integer, Player> players, List<HistoryGame> gamesHistory) {
        this.name = name;
        try{
            this.setPlayers(players);
        }
        catch (NumberAlreadyExistsInTeamException i){
            i.printStackTrace();
        }
        this.setGamesHistory(gamesHistory);
        this.calcOverall();
    }

    /**
     * Copy constructor
     * @param t Team to copy
     */
    public Team(Team t){
        this.name = t.getName();
        try{
            this.setPlayers(t.getPlayers());
        }
        catch (NumberAlreadyExistsInTeamException i){
            i.printStackTrace();
        }
        this.setGamesHistory(t.getGamesHistory());
        this.overall = t.getOverall();
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
        this.players = new HashMap<>();
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
    public List<HistoryGame> getGamesHistory(){
        List<HistoryGame> ans = new ArrayList<>();
        if(this.gamesHistory != null)
            for(HistoryGame g : this.gamesHistory)
                ans.add(g.clone());
        else return null;
        return ans;
    }

    /**
     * Games history setter
     * @param gamesHistory Games history to set
     */
    public void setGamesHistory(List<HistoryGame> gamesHistory){
        this.gamesHistory = new ArrayList<>();
        for(HistoryGame g : gamesHistory)
            this.gamesHistory.add(g.clone());
    }

    /**
     * Overall getter
     * @return Team overall
     */
    public int getOverall(){
        if(this.overall == 0) calcOverall();
        return this.overall;
    }

    /**
     * Method to calculate a team overall
     */
    public void calcOverall(){
        int res = 0, ac = 0, nPlayers = 0;
        if(this.players != null){
            for(Player p : this.players.values()){
                ac += p.getOverall();
                nPlayers++;
            }
            if(nPlayers != 0) res = (int) (ac / nPlayers);
        }
        this.overall = res;
    }

    /**
     * Method to get team as a String
     * @return Team as a string
     */
    public String toString(){
        StringBuilder sb = new StringBuilder("Team: ")
                .append(name).append("\n")
                .append("Players: ").append(players.toString()).append("\n")
                .append("Overall: ").append(overall);
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
        this.players.put(p.getNumber(), p.clone());
        this.calcOverall();
    }

    /**
     * Method to see what numbers a team currently has
     * @return Used numbers
     */
    public Set<Integer> usedNumbers(){
       return new HashSet<>(this.players.keySet());
    }

    /**
     * Method to remove a player from a team given is number
     * @param number Player number to remove
     */
    public void removePlayer(int number){
        this.players.remove(number);
        this.calcOverall();
    }

    /**
     * Method to add one game to team's history
     * @param g Game to add
     */
    public void addGameToHistory(Game g){
        HistoryGame h = new HistoryGame(g);
        this.gamesHistory.add(h);
    }

    /**
     * Method to add an already formatted game to team's history
     * @param h History Game to add
     */
    public void addHistoryGame(HistoryGame h){
        this.gamesHistory.add(h.clone());
    }
}
