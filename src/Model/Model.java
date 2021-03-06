package Model;

import java.io.*;
import java.util.*;

/**
 * Model Class
 */
public class Model implements Serializable{
    /**
     * Database teams
     */
    private Map<String, Team> teams;
    /**
     * Database players
     */
    private Map<String, Player> players;
    /**
     * Database games
     */
    private List<Game> games;

    /**
     * Empty Model constructor
     */
    public Model(){
        this.teams = new HashMap<>();
        this.players = new HashMap<>();
        this.games = new ArrayList<>();
    }

    /**
     * Constructor with teams, players and games
     * @param teams Model teams
     * @param players Model players
     * @param games Model games
     */
    public Model(Map<String, Team> teams, Map<String, Player> players, List<Game> games) {
        this.setTeams(teams);
        this.setPlayers(players);
        this.setGames(games);
    }

    /**
     * Copy Constructor
     * @param m Model to copy
     */
    public Model(Model m){
        this.setTeams(m.getTeams());
        this.setPlayers(m.getPlayers());
        this.setGames(m.getGames());
    }

    /**
     * Teams getter
     * @return Map of model's teams
     */
    public Map<String, Team> getTeams() {
        Map<String, Team> ans = new HashMap<>();
        for(Team t : this.teams.values())
            ans.put(t.getName(), t.clone());
        return ans;
    }

    /**
     * Teams setter
     * @param teams Teams to set
     */
    public void setTeams(Map<String, Team> teams) {
        this.teams = new HashMap<>();
        for(Team t : teams.values()) {
            this.teams.put(t.getName(), t.clone());
        }
    }

    /**
     * Players getter
     * @return Map of players
     */
    public Map<String, Player> getPlayers() {
        Map<String, Player> ans = new HashMap<>();
        this.players.forEach((k,v) -> ans.put(k, v.clone()));
        return ans;
    }

    /**
     * Players setter
     * @param players Players to set
     */
    public void setPlayers(Map<String, Player> players) {
        this.players = new HashMap<>();
        players.forEach((k,v) -> this.players.put(k, v.clone()));
    }

    /**
     * Games getter
     * @return List of Games
     */
    public List<Game> getGames() {
        List<Game> ans = new ArrayList<>();
        for(Game g : this.games) ans.add(g.clone());
        return ans;
    }

    /**
     * Games setter
     * @param games Games to Set
     */
    public void setGames(List<Game> games) {
        this.games = new ArrayList<>();
        for(Game g : games) this.games.add(g.clone());
    }

    /**
     * Method to remove a team from database
     * @param name Name of the team to remove
     */
    public void removeTeam(String name){
        this.teams.remove(name);
        for(Player p : this.players.values())
            if(p.getCurrentTeamName().equals(name))
                this.players.remove(p.getName());
    }


    /**
     * Method to remove a player from a team
     * @param pName Player's to remove name
     * @param t Player's to remove team
     * @throws InvalidPlayerException Exception to prevent cases of an nonexistent player / remove a player from a team for which he doesn't play
     */
    public void removePlayerFromTeam(String pName, Team t) throws InvalidPlayerException{
        Player p = this.players.get(pName);
        if(!this.players.containsKey(pName)) throw new InvalidPlayerException(pName + " doesn't exist on database");
        else if(!this.teams.get(t.getName()).getPlayers().containsKey(p.getNumber())) throw new InvalidPlayerException(pName + " doesn't play on " + t.getName());
        else t.removePlayer(this.players.get(pName).getNumber());
    }

    /**
     * Method to remove a player from a team given his number
     * @param pName Player's to remove name
     * @param t Player's to remove team
     * @param number Player's number
     * @throws InvalidPlayerException Exception to prevent cases of an nonexistent player / remove a player from a team for which he doesn't play
     */
    public void removePlayerFromTeam(String pName, Team t, int number) throws InvalidPlayerException{
        if(!this.players.containsKey(pName)) throw new InvalidPlayerException(pName + " doesn't exist on database");
        else if(!this.teams.get(t.getName()).getPlayers().containsKey(number)) throw new InvalidPlayerException(pName + " doesn't play on " + t.getName());
        else t.removePlayer(number);
    }

    /**
     * Method to add a player to a team
     * @param pName Player's to add name
     * @param t Player's new team
     * @throws InvalidPlayerException Exception to prevent cases of an nonexistent player
     * @throws NumberAlreadyExistsInTeamException Exception to prevent repeated numbers
     */
    public void addPlayerToTeam(String pName, Team t) throws InvalidPlayerException, NumberAlreadyExistsInTeamException {
        Player p = this.players.get(pName);
        if(!this.players.containsKey(pName)) throw new InvalidPlayerException(pName + " doesn't exist on database");
        else t.addPlayer(p);
    }

    /**
     * Method to remove a player from database
     * @param name Name of the player to remove
     */
    public void removePlayer(String name){
        for(Team t : this.teams.values()){
            if(t.getPlayers().containsKey(this.players.get(name).getNumber()))
                try{
                    removePlayerFromTeam(name, t);
                }
                catch (InvalidPlayerException i){
                    i.printStackTrace();
                }
        }
        this.players.remove(name);
    }

    /**
     * Method to transfer a player from one team to another
     * @param pName Name of the player
     * @param tName Old player's team name
     * @param newTeamName New player's team name
     * @param newNumber New player's number
     */
    public void transferPlayer(String pName, String tName, String newTeamName, int newNumber){
        Player p = this.players.get(pName);
        int oldNumber = p.getNumber();
        p.setNumber(newNumber);
        Team t = this.teams.get(tName);
        Team nt = this.teams.get(newTeamName);
        try{
            removePlayerFromTeam(pName, t, oldNumber);
            addPlayerToTeam(pName, nt);
            p.changeTeam(newTeamName);
        }
        catch (InvalidPlayerException | NumberAlreadyExistsInTeamException i){
            i.printStackTrace();
        }
    }

    /**
     * Method to add a player to database
     * @param p Player to add
     * @throws PlayerAlreadyExistsException Exception to prevent players with the same name in database
     * @throws InvalidTeamException Exception to prevent players from an unknown team to database
     */
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

    /**
     * Method to add a team to database
     * @param t Team to add
     * @throws TeamAlreadyExistsException Exception to prevent teams with the same name in database
     * @throws PlayerAlreadyExistsException Exception to prevent players from other teams to be added on other team
     */
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

    /**
     * Method to get a player given his name
     * @param name Player's name
     * @return Player
     */
    public Player getPlayerWithName(String name){
        return this.players.get(name).clone();
    }

    /**
     * Method to check if a player is in a team
     * @param teamName Name of the team to check
     * @param playerNum Number of the player to check
     * @param p Player to check
     * @return True in case of the player plays to the team, false in the other case
     */
    public boolean containsPlayerInTeam(String teamName, int playerNum, Player p){
        if(!this.teams.get(teamName).getPlayers().containsKey(playerNum)) return false;
        else return this.teams.get(teamName).getPlayers().get(playerNum).equals(p);
    }

    /**
     * Method to get a team given its name
     * @param name Team's name
     * @return The team
     */
    public Team getTeamWithName(String name){
        return this.teams.get(name).clone();
    }

    /**
     * Method to get Players as an array of strings
     * @return Players as an array of strings
     */
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
            result[i++] = p.getCurPosition().toString();
        }

        return result;
    }

    /**
     * Method to get Teams as an array of strings
     * @return Teams as an array of strings
     */
    public String[] getTeamsAsStringArray()
    {
        String[] result = new String[this.teams.values().size() * 2];

        int i = 0;

        for(Team t : this.teams.values())
        {
            result[i++] = t.getName();
            result[i++] = String.valueOf(t.getOverall());
        }

        return result;
    }

    /**
     * Method to get Players of a team given its name as an array of strings
     * @param teamName Team's name
     * @return Players of the team as an array of strings
     */
    public String[] getPlayersTeamAsStringArray(String teamName)
    {
        String[] result = new String[getTeamWithName(teamName).getPlayers().values().size() * 4];

        int i = 0;

        for(Player p : getTeamWithName(teamName).getPlayers().values())
        {
            result[i++] = p.getName();
            result[i++] = Integer.toString(p.getNumber());
            result[i++] = Integer.toString(p.getOverall());
            result[i++] = p.getCurPosition().toString();
        }

        return result;
    }

    /**
     * Method to get games history of a team given its name as an array of string
     * @param teamName Team's name
     * @return Games history of a team as an array of strings
     */
    public String[] getHistoryTeamAsStringArray(String teamName)
    {
        String[] result = new String[getTeamWithName(teamName).getGamesHistory().size() * 5];

        int i = 0;

        for(HistoryGame g : getTeamWithName(teamName).getGamesHistory())
        {
            result[i++] = g.getGameDate().toString();
            result[i++] = g.getHomeTeam();
            result[i++] = g.getAwayTeam();
            result[i++] = Integer.toString(g.getHomeGoals());
            result[i++] = Integer.toString(g.getAwayGoals());
        }

        return result;
    }

    /**
     * Method to get player's history given his name as an array of strings
     * @param playerName Player's name
     * @return Player's history as an array of strings
     */
    public String[] getPlayerHistoryAsStringArray(String playerName)
    {
        String[] result = new String[getPlayerWithName(playerName).getHistoric().size()];

        int i = 0;

        for(String t : getPlayerWithName(playerName).getHistoric())
        {
            result[i++] = t;
        }

        return result;
    }

    /**
     * Method that updates a certain player's attribute to a new value.
     * @param playerName Player's name
     * @param attribute Code of the player's attribute to update
     * @param newValue New value for the attribute
     * @throws InvalidAttributeException Exception to prevent invalid attributes
     * @throws PlayerAlreadyExistsException Exception to prevent repeated players
     * @throws InvalidTeamException Exception to prevent invalid teams
     */
    public void updatePlayer(String playerName , int attribute, int newValue) throws InvalidAttributeException, PlayerAlreadyExistsException, InvalidTeamException
    {
        Player p = getPlayerWithName(playerName);

        p.updateAttribute(attribute,newValue);

        removePlayer(playerName);
        addPlayer(p);
    }

    /**
     * Method to get unused numbers of a team given its name
     * @param teamName Team's name
     * @return Set of available number on the team
     */
    public Set<Integer> availableNumbersInTeam(String teamName){
        Set<Integer> numbers = this.teams.get(teamName).usedNumbers();
        Set<Integer> ans = new HashSet<>();
        for(int i = 0; i <= 99; i++)
            if(!numbers.contains(i)) ans.add(i);
        return ans;
    }

    /**
     * Method to get available number of a team given its name in an array of strings
     * @param teamName Team's name
     * @return Available numbers of the team as an array of strings
     */
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

    /**
     * Method to get players numbers from a set of players
     * @param players Set of players
     * @return Set of number from the given players
     */
    public Set<Integer> getPlayersNum(Set<Player> players)
    {
        HashSet<Integer> players_num = new HashSet<>();

        for(Player p : players)
        {
            players_num.add(p.getNumber());
        }

        return players_num;
    }

    /**
     * Method to get a set of a team goalkeepers
     * @param team_name Team's to check name
     * @return Set of a team goalkeepers
     */
    public Set<Player> getTeamGK(String team_name)
    {
        HashSet<Player> result = new HashSet<>();
        Team team = getTeamWithName(team_name);

        for(Player p : team.getPlayers().values())
        {
            if(p.getCurPosition().equals(Position.GOALKEEPER)) result.add(p.clone());
        }

        return result;
    }

    /**
     * Method to get a team goalkeepers as an array of strings
     * @param team_name Team's to check name
     * @return Team goalkeepers as an array of strings
     */
    public String[] getTeamGKAsStringArray(String team_name)
    {
        Set<Player> GKList = getTeamGK(team_name);

        String[] result = new String[GKList.size() * 4];

        int i = 0;

        for(Player x : GKList)
        {
            result[i++] = x.getName();
            result[i++] = String.valueOf(x.getNumber());
            result[i++] = String.valueOf(x.getOverall());
            result[i++] = x.getCurPosition().toString();
        }

        return result;
    }

    /**
     * Method to get a set of a team wingers
     * @param team_name Team's to check name
     * @return Set of a team wingers
     */
    public Set<Player> getTeamWG(String team_name)
    {
        HashSet<Player> result = new HashSet<>();
        Team team = getTeamWithName(team_name);

        for(Player p : team.getPlayers().values())
        {
            if(p.getCurPosition().equals(Position.WINGER)) result.add(p.clone());
        }

        return result;
    }

    /**
     * Method to get a team wingers as an array of strings
     * @param team_name Team's to check name
     * @return Team wingers as an array of strings
     */
    public String[] getTeamWGAsStringArray(String team_name)
    {
        Set<Player> WGList = getTeamWG(team_name);

        String[] result = new String[WGList.size() * 4];

        int i = 0;

        for(Player x : WGList)
        {
            result[i++] = x.getName();
            result[i++] = String.valueOf(x.getNumber());
            result[i++] = String.valueOf(x.getOverall());
            result[i++] = x.getCurPosition().toString();
        }

        return result;
    }

    /**
     * Method to get a set of a team defenders, midfielders and forwards
     * @param team_name Team's to check name
     * @return Set of a team defenders, midfielders and forwards
     */
    public Set<Player> getTeamExchangeable(String team_name)
    {
        HashSet<Player> result = new HashSet<>();
        Team team = getTeamWithName(team_name);

        for(Player p : team.getPlayers().values())
        {
            if(!p.getCurPosition().equals(Position.WINGER) && !p.getCurPosition().equals(Position.GOALKEEPER)) result.add(p.clone());
        }

        return result;
    }

    /**
     * Method to get a team defenders, midfielders and forwards as an array of strings
     * @param team_name Team's to check name
     * @return Team defenders, midfielders and forwards as an array of strings
     */
    public String[] getTeamExchangeableAsStringArray(String team_name)
    {
        Set<Player> ExchangeableList = getTeamExchangeable(team_name);

        String[] result = new String[ExchangeableList.size() * 4];

        int i = 0;

        for(Player x : ExchangeableList)
        {
            result[i++] = x.getName();
            result[i++] = String.valueOf(x.getNumber());
            result[i++] = String.valueOf(x.getOverall());
            result[i++] = x.getCurPosition().toString();
        }

        return result;
    }

    /**
     * Method to get a set of a team non playing goalkeepers
     * @param team_name Team's to check name
     * @param players Set of numbers of playing players
     * @return Set of a team non playing goalkeepers
     */
    public Set<Player> getTeamGK(String team_name, Set<Integer> players){
        Set<Player> ans = new HashSet<>();
        Team t = this.teams.get(team_name);
        for(Player p : t.getPlayers().values())
            if(players.contains(p.getNumber()) && p.getCurPosition().equals(Position.GOALKEEPER)) ans.add(p.clone());
        return ans;
    }

    /**
     * Method to get a team non playing goalkeepers as an array of strings
     * @param team_name Team's to check name
     * @param players Set of numbers of playing players
     * @return Team non playing goalkeepers as an array of strings
     */
    public String[] getTeamGKAsStringArray(String team_name, Set<Integer> players){
        Set<Player> GoalkeepersList = getTeamGK(team_name, getNonPlayingPlayers(team_name, players));
        String[] result = new String[GoalkeepersList.size() * 4];

        int i = 0;
        for(Player x : GoalkeepersList)
        {
            result[i++] = x.getName();
            result[i++] = String.valueOf(x.getNumber());
            result[i++] = String.valueOf(x.getOverall());
            result[i++] = x.getCurPosition().toString();
        }

        return result;
    }

    /**
     * Method to get a set of a team non playing wingers
     * @param team_name Team's to check name
     * @param players Set of numbers of playing players
     * @return Set of a team non playing wingers
     */
    public Set<Player> getTeamWG(String team_name, Set<Integer> players){
        Set<Player> ans = new HashSet<>();
        Team t = this.teams.get(team_name);
        for(Player p : t.getPlayers().values())
            if(players.contains(p.getNumber()) && p.getCurPosition().equals(Position.WINGER)) ans.add(p.clone());
        return ans;
    }

    /**
     * Method to get a team non playing wingers as an array of strings
     * @param players Set of numbers of playing players
     * @param team_name Name of the team
     * @return Team non playing wingers as an array of strings
     */
    public String[] getTeamWGAsStringArray(String team_name, Set<Integer> players){
        Set<Player> WingersList = getTeamWG(team_name, getNonPlayingPlayers(team_name, players));
        String[] result = new String[WingersList.size() * 4];

        int i = 0;
        for(Player x : WingersList)
        {
            result[i++] = x.getName();
            result[i++] = String.valueOf(x.getNumber());
            result[i++] = String.valueOf(x.getOverall());
            result[i++] = x.getCurPosition().toString();
        }

        return result;
    }

    /**
     * Method to get a set of a team non playing defenders, midfielders and forwards
     * @param team_name Team's to check name
     * @param players Set of numbers of playing players
     * @return Set of a team non playing defenders, midfielders and forwards
     */
    public Set<Player> getTeamExchangeable(String team_name, Set<Integer> players){
        Set<Player> ans = new HashSet<>();
        Team t = this.teams.get(team_name);
        for(Player p : t.getPlayers().values())
            if(players.contains(p.getNumber()) && !p.getCurPosition().equals(Position.WINGER) && !p.getCurPosition().equals(Position.GOALKEEPER)) ans.add(p.clone());
        return ans;
    }

    /**
     * Method to get a team non playing defenders, midfielders and forwards as an array of strings
     * @param team_name Team's to check name
     * @param players Set of numbers of playing players
     * @return Team non playing defenders, midfielders and forwards as an array of strings
     */
    public String[] getTeamExchangeableAsStringArray(String team_name, Set<Integer> players){
        Set<Player> ExchangeableList = getTeamExchangeable(team_name, getNonPlayingPlayers(team_name, players));
        String[] result = new String[ExchangeableList.size() * 4];

        int i = 0;
        for(Player x : ExchangeableList)
        {
            result[i++] = x.getName();
            result[i++] = String.valueOf(x.getNumber());
            result[i++] = String.valueOf(x.getOverall());
            result[i++] = x.getCurPosition().toString();
        }

        return result;
    }

    /**
     * Method to get non playing players of a team
     * @param team Team's to check name
     * @param playingPlayers Set of numbers of the playing player
     * @return Set of number of non playing players
     */
    public Set<Integer> getNonPlayingPlayers(String team, Set<Integer> playingPlayers){
        Team t = this.teams.get(team);
        Set<Integer> ans = new HashSet<>();
        for(Integer i : t.getPlayers().keySet())
            if(!playingPlayers.contains(i)) ans.add(i);
        return ans;
    }

    /**
     * Method to get a team playing players as a string array
     * @param team_name Team's to check name
     * @param players Set with the numbers of playing players
     * @return Playing players in an array of strings
     */
    public String[] getTeamPlayingPlayersAsStringArray(String team_name, Set<Integer> players){
        Set<Player> PlayerList = getPlayingPlayers(team_name, players);
        String[] result = new String[PlayerList.size() * 4];

        int i = 0;
        for(Player x : PlayerList)
        {
            result[i++] = x.getName();
            result[i++] = String.valueOf(x.getNumber());
            result[i++] = String.valueOf(x.getOverall());
            result[i++] = x.getCurPosition().toString();
        }

        return result;
    }

    /**
     * Method to get a set of the Players who are currently playing in a game
     * @param team Team's to check name
     * @param playingPlayers Set of numbers of the playing players
     * @return Set of players playing
     */
    public Set<Player> getPlayingPlayers(String team, Set<Integer> playingPlayers){
        Team t = this.teams.get(team);
        Set<Player> ans = new HashSet<>();
        for(Integer i : t.getPlayers().keySet())
            if(playingPlayers.contains(i)) ans.add(t.getPlayers().get(i).clone());
        return ans;
    }

    /**
     * Method to set a player position for a game
     * @param team Name of the team of player
     * @param nPlayer Number of the player
     * @param posCode Code to represent position
     */
    public void setPlayerPositionForGame(String team, int nPlayer, int posCode){
        Player p = this.teams.get(team).getPlayers().get(nPlayer);
        switch (posCode) {
            case 0 : p.setPosition(Position.GOALKEEPER);
            case 1 : p.setPosition(Position.DEFENDER);
            case 2 : p.setPosition(Position.WINGER);
            case 3 : p.setPosition(Position.MIDFIELDER);
            case 4 : p.setPosition(Position.FORWARD);
        }
    }

    /**
     * Method to update team's game history from two teams who had disputed a game
     * @param hT Home Team name
     * @param aT Away Team name
     * @param g Game
     */
    public void updateTeamsHistory(String hT, String aT, Game g){
        HistoryGame hg = new HistoryGame(g);
        this.teams.get(hT).addHistoryGame(hg);
        this.teams.get(aT).addHistoryGame(hg);
    }

    /**
     * Method to reset model
     */
    public void resetModel(){
        this.teams = new HashMap<>();
        this.players = new HashMap<>();
        this.games = new ArrayList<>();
    }

    /**
     * Method to set a model given another model
     * @param m Model to set
     */
    public void setModel(Model m){
        resetModel();
        this.players = m.getPlayers();
        this.teams = m.getTeams();
        this.games = m.getGames();
    }

    /**
     * Method to save current object state
     * @param fileName Name to give the name to the file to save
     * @throws IOException Exception of I/O
     */
    public void saveObject(String fileName) throws IOException {
        String filePath = "saves/" + fileName +".sm";
        File save = new File(filePath);
        if(!save.exists()) save.createNewFile();
        FileOutputStream fos = new FileOutputStream(save);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);
        oos.flush();
        oos.close();
    }

    /**
     * Method to read an object file
     * @param fileName Path to the file to read
     * @return A new Model
     * @throws IOException Exception of I/O
     * @throws ClassNotFoundException Exception of a class not found
     */
    public Model readObject (String fileName) throws IOException, ClassNotFoundException{
        String filePath = "saves/" + fileName;
        ObjectInputStream file = new ObjectInputStream((new FileInputStream(filePath)));
        Model t = (Model) file.readObject();
        file.close();
        return t;
    }
}