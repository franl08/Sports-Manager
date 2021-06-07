package Model;

import java.io.*;
import java.util.*;

public class Model {
    private Map<String, Team> teams;
    private Map<String, Player> players;
    private List<Game> games;

    public Model(){
        this.teams = new HashMap<>();
        this.players = new HashMap<>();
        this.games = new ArrayList<>();
    }

    public Model(Map<String, Team> teams, Map<String, Player> players, List<Game> games) {
        this.setTeams(teams);
        this.setPlayers(players);
        this.setGames(games);
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
        this.players.forEach((k,v) -> ans.put(k, v.clone()));
        return ans;
    }

    public void setPlayers(Map<String, Player> players) {
        this.players = new HashMap<>();
        players.forEach((k,v) -> this.players.put(k, v.clone()));
    }

    public List<Game> getGames() {
        List<Game> ans = new ArrayList<>();
        for(Game g : this.games) ans.add(g.clone());
        return ans;
    }

    public void setGames(List<Game> games) {
        this.games = new ArrayList<>();
        for(Game g : games) this.games.add(g.clone());
    }

    public void removeTeam(String name){
        this.teams.remove(name);
        for(Player p : this.players.values())
            if(p.getCurrentTeamName().equals(name))
                this.players.remove(p.getName());
    }


    public void removePlayerFromTeam(String pName, Team t) throws InvalidPlayerException{
        Player p = this.players.get(pName);
        if(!this.players.containsKey(pName)) throw new InvalidPlayerException(pName + " doesn't exist on database");
        else if(!this.teams.get(t.getName()).getPlayers().containsKey(p.getNumber())) throw new InvalidPlayerException(pName + " doesn't play on " + t.getName());
        else t.getPlayers().remove(p.getNumber());
    }

    public void addPlayerToTeam(String pName, Team t) throws InvalidPlayerException{
        Player p = this.players.get(pName);
        if(!this.players.containsKey(pName)) throw new InvalidPlayerException(pName + " doesn't exist on database");
        else t.getPlayers().put(this.players.get(pName).getNumber(), this.players.get(pName));
    }

    public void removePlayer(String name){
        for(Team t : this.teams.values()){
            try{
                removePlayerFromTeam(name, t);
            }
            catch (InvalidPlayerException i){
                i.printStackTrace();
            }
        }
        this.players.remove(name);
    }

    public void transferPlayer(String pID, String tName, String newTeamName, int newNumber){
        Player p = this.players.get(pID);
        p.setNumber(newNumber);
        Team t = this.teams.get(tName);
        Team nt = this.teams.get(newTeamName);
        try{
            removePlayerFromTeam(pID, t);
            addPlayerToTeam(pID, nt);
            p.changeTeam(newTeamName);
        }
        catch (InvalidPlayerException i){
            i.printStackTrace();
        }
    }

    public void addPlayer(Player p) throws PlayerAlreadyExistsException, InvalidTeamException{
        if(this.players.containsValue(p)) throw new PlayerAlreadyExistsException(p.getName() + " already exists in database");
        else if(!(this.teams.containsKey(p.getCurrentTeamName()))) throw new InvalidTeamException("Team " + p.getCurrentTeamName() + " doesn't exist on database");
        else {
            this.players.put(p.getName(), p);
            Team t = this.teams.get(p.getCurrentTeamName());
            try{
                t.addPlayer(p);
            }
            catch(NumberAlreadyExistsInTeamException i){
                i.printStackTrace();
            }
        }
    }

    public void addTeam(Team t) throws TeamAlreadyExistsException, PlayerAlreadyExistsException{
        int flag = 1;
        if(this.teams.containsValue(t)) throw new TeamAlreadyExistsException("Team " + t.getName() + " already exists in database");
        else {
            for(Player p : t.getPlayers().values()){
                if(this.players.containsValue(p)) throw new PlayerAlreadyExistsException(p.getName() + " already exists in database");
            }
            System.out.println(t);
            this.teams.put(t.getName(), t.clone());
        }
    }

    public Player getPlayerWithName(String name){
        return this.players.get(name).clone();
    }

    public boolean containsPlayerInTeam(String teamName, int playerNum){
        return this.teams.get(teamName).getPlayers().containsKey(playerNum);
    }

    public Team getTeamWithName(String name){
        return this.teams.get(name).clone();
    }

    public String[] getPlayersAsStringArray()
    {
        String[] result = new String[this.players.values().size() * 5];

        int i = 0;

        for(Player p : this.players.values())
        {
            result[i++] = p.getName();
            result[i++] = Integer.toString(p.getNumber());
            result[i++] = p.getCurrentTeamName();
            result[i++] = Integer.toString(p.getOverall());
            result[i++] = p.getPosition().toString();
        }

        return result;
    }

    public String[] getTeamsAsStringArray()
    {
        String[] result = new String[this.teams.values().size()];

        int i = 0;

        for(Team t : this.teams.values())
        {
            result[i++] = t.getName();
        }

        return result;
    }

    public String[] getPlayersTeamAsStringArray(String teamName)
    {
        String[] result = new String[getTeamWithName(teamName).getPlayers().values().size() * 5];

        int i = 0;

        for(Player p : getTeamWithName(teamName).getPlayers().values())
        {
            result[i++] = p.getName();
            result[i++] = Integer.toString(p.getNumber());
            result[i++] = Integer.toString(p.getOverall());
            result[i++] = p.getPosition().toString();
        }

        return result;
    }

    public String[] getHistoryTeamAsStringArray(String teamName)
    {
        String[] result = new String[getTeamWithName(teamName).getGamesHistory().size() * 4];

        int i = 0;

        for(Game g : getTeamWithName(teamName).getGamesHistory())
        {
            result[i++] = g.getLd().toString();
            result[i++] = g.getHomeTeam().getName();
            result[i++] = g.getAwayTeam().getName();
            result[i++] = Integer.toString(g.getHomeGoals());
            result[i++] = Integer.toString(g.getAwayGoals());
        }

        return result;
    }

    /**
     * Function that updates a certain player's attribute to a new value.
     * @param playerName
     * @param attribute
     * @param newValue
     */
    public void updatePlayer(String playerName , int attribute, int newValue) throws InvalidAttributeException, PlayerAlreadyExistsException, InvalidTeamException
    {
        Player p = getPlayerWithName(playerName);

        p.updateAttribute(attribute,newValue);

        removePlayer(playerName);
        addPlayer(p);
    }

    public Set<Integer> availableNumbersInTeam(String teamName){
        Set<Integer> numbers = this.teams.get(teamName).usedNumbers();
        Set<Integer> ans = new HashSet<>();
        for(int i = 1; i <= 99; i++)
            if(!numbers.contains(i)) ans.add(i);
        return ans;
    }

    public String[] availableNumbersAsString(String teamName){
        Set<Integer> availableNums = availableNumbersInTeam(teamName);

        String[] result = new String[availableNums.size()];

        int i = 0;

        for(Integer x : availableNums)
        {
            result[i++] = String.valueOf(x);
        }

        return result;
    }

    public void saveObject(String objectPath) throws IOException {
        FileOutputStream fos = new FileOutputStream(objectPath);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);
        oos.flush();
        oos.close();
    }

    public Model readObject (String filename) throws IOException, ClassNotFoundException{
        ObjectInputStream file = new ObjectInputStream((new FileInputStream(filename)));
        Model t = (Model) file.readObject();
        file.close();
        return t;
    }
}