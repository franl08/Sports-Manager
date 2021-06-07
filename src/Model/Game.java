package Model;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Game {
    private Team homeTeam;
    private Team awayTeam;
    private Set<Integer> homePlayers;
    private Set<Integer> awayPlayers;
    private Map<Integer, Integer> homeSubs;
    private Map<Integer, Integer> awaySubs;
    private int homeGoals;
    private int awayGoals;
    private int timer;
    private int homeDefenseOverall;
    private int awayDefenseOverall;
    private int homeAttackingOverall;
    private int awayAttackingOverall;
    private int homeControllingOverall;
    private int awayControllingOverall;
    private Meteorology meteorology;
    private LocalDate ld;

    /**
     * Empty Constructor
     */
    public Game(){
        this.homeTeam = new Team();
        this.awayTeam = new Team();
        this.homePlayers = new HashSet<>();
        this.awayPlayers = new HashSet<>();
        this.homeGoals = 0;
        this.awayGoals = 0;
        this.homeSubs = new HashMap<>();
        this.awaySubs = new HashMap<>();
        this.timer = 0;
        this.homeDefenseOverall = 0;
        this.awayDefenseOverall = 0;
        this.homeAttackingOverall = 0;
        this.awayAttackingOverall = 0;
        this.homeControllingOverall = 0;
        this.awayControllingOverall = 0;
        setRandomMeteorology();
        this.ld = LocalDate.now();
    }


    /**
     * Constructor with teams, players, and substitutions
     * @param homeTeam Home team
     * @param awayTeam Away team
     * @param homePlayers Home lineup
     * @param awayPlayers Away lineup
     * @param homeSubs Home substitutions
     * @param awaySubs Away substitutions
     */
    public Game(Team homeTeam, Team awayTeam, Set<Integer> homePlayers, Set<Integer> awayPlayers, HashMap<Integer, Integer> homeSubs, HashMap<Integer, Integer> awaySubs){
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.setHomePlayers(homePlayers);
        this.setAwayPlayers(awayPlayers);
        this.homeGoals = 0;
        this.awayGoals = 0;
        this.setHomeSubs(homeSubs);
        this.setAwaySubs(awaySubs);
        try{
            this.homeDefenseOverall = calcDefenseOverall(homeTeam, homePlayers);
        }
        catch (InvalidPlayerException i){
            this.homeDefenseOverall = 0;
        }
        try{
            this.homeAttackingOverall = calcAttackingOverall(homeTeam, homePlayers);
        }
        catch (InvalidPlayerException i){
            this.homeAttackingOverall = 0;
        }
        try{
            this.awayDefenseOverall = calcDefenseOverall(homeTeam, homePlayers);
        }
        catch (InvalidPlayerException i){
            this.awayDefenseOverall = 0;
        }
        try{
            this.awayAttackingOverall = calcAttackingOverall(homeTeam, homePlayers);
        }
        catch (InvalidPlayerException i){
            this.awayAttackingOverall = 0;
        }
        try{
            this.homeControllingOverall = calcControllingOverall(homeTeam, homePlayers);
        }
        catch (InvalidPlayerException i){
            this.homeControllingOverall = 0;
        }
        try{
            this.awayControllingOverall = calcControllingOverall(awayTeam, awayPlayers);
        }
        catch (InvalidPlayerException i){
            this.awayControllingOverall = 0;
        }
        this.timer = 0;
        setRandomMeteorology();
        this.ld = LocalDate.now();
    }

    /**
     * Constructor for logs
     * @param homeTeam Home Team
     * @param awayTeam Away Team
     * @param homeGoals Home Team goals
     * @param awayGoals Away Team goals
     * @param ld Date of the game
     * @param homePlayers Home Team players
     * @param homeSubs Home Team substitutions
     * @param awayPlayers Away Team players
     * @param awaySubs Away Team substitutions
     */
    public Game(Team homeTeam, Team awayTeam, int homeGoals, int awayGoals, LocalDate ld, Set<Integer> homePlayers,  Map<Integer, Integer> homeSubs, Set<Integer> awayPlayers, Map<Integer, Integer> awaySubs){
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.setHomePlayers(homePlayers);
        this.setAwayPlayers(awayPlayers);
        this.homeGoals = 0;
        this.awayGoals = 0;
        this.setHomeSubs(homeSubs);
        this.setAwaySubs(awaySubs);
        try{
            this.homeDefenseOverall = calcDefenseOverall(homeTeam, homePlayers);
        }
        catch (InvalidPlayerException i){
            this.homeDefenseOverall = 0;
        }
        try{
            this.homeAttackingOverall = calcAttackingOverall(homeTeam, homePlayers);
        }
        catch (InvalidPlayerException i){
            this.homeAttackingOverall = 0;
        }
        try{
            this.awayDefenseOverall = calcDefenseOverall(homeTeam, homePlayers);
        }
        catch (InvalidPlayerException i){
            this.awayDefenseOverall = 0;
        }
        try{
            this.awayAttackingOverall = calcAttackingOverall(homeTeam, homePlayers);
        }
        catch (InvalidPlayerException i){
            this.awayAttackingOverall = 0;
        }
        try{
            this.homeControllingOverall = calcControllingOverall(homeTeam, homePlayers);
        }
        catch (InvalidPlayerException i){
            this.homeControllingOverall = 0;
        }
        try{
            this.awayControllingOverall = calcControllingOverall(awayTeam, awayPlayers);
        }
        catch (InvalidPlayerException i){
            this.awayControllingOverall = 0;
        }
        this.timer = 90;
        this.homeGoals = 0;
        this.awayGoals = 0;
        setRandomMeteorology();
        this.ld = ld;
    }

    /**
     * Constructor with teams, players, substitutions, goals, timer, meteorology and game date
     * @param homeTeam Home team
     * @param awayTeam Away team
     * @param homePlayers Home lineup
     * @param awayPlayers Away lineup
     * @param homeSubs Home substitutions
     * @param awaySubs Away substitutions
     * @param homeGoals Home goals
     * @param awayGoals Away goals
     * @param timer Current game time
     * @param meteorology Meteorology
     * @param ld Game date
     */
    public Game(Team homeTeam, Team awayTeam, Set<Integer> homePlayers, Set<Integer> awayPlayers, Map<Integer, Integer> homeSubs, Map<Integer, Integer> awaySubs, int homeGoals, int awayGoals, int timer, Meteorology meteorology, LocalDate ld) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.setHomePlayers(homePlayers);
        this.setAwayPlayers(awayPlayers);
        this.setHomeSubs(homeSubs);
        this.setAwaySubs(awaySubs);
        try{
            this.homeDefenseOverall = calcDefenseOverall(homeTeam, homePlayers);
        }
        catch (InvalidPlayerException i){
            this.homeDefenseOverall = 0;
        }
        try{
            this.homeAttackingOverall = calcAttackingOverall(homeTeam, homePlayers);
        }
        catch (InvalidPlayerException i){
            this.homeAttackingOverall = 0;
        }
        try{
            this.awayDefenseOverall = calcDefenseOverall(homeTeam, homePlayers);
        }
        catch (InvalidPlayerException i){
            this.awayDefenseOverall = 0;
        }
        try{
            this.awayAttackingOverall = calcAttackingOverall(homeTeam, homePlayers);
        }
        catch (InvalidPlayerException i){
            this.awayAttackingOverall = 0;
        }
        try{
            this.homeControllingOverall = calcControllingOverall(homeTeam, homePlayers);
        }
        catch (InvalidPlayerException i){
            this.homeControllingOverall = 0;
        }
        try{
            this.awayControllingOverall = calcControllingOverall(awayTeam, awayPlayers);
        }
        catch (InvalidPlayerException i){
            this.awayControllingOverall = 0;
        }
        this.homeGoals = homeGoals;
        this.awayGoals = awayGoals;
        this.timer = timer;
        this.meteorology = meteorology;
        this.ld = ld;
    }

    /**
     * Copy constructor
     * @param g Game to copy
     */
    public Game(Game g){
        this.homeTeam = g.getHomeTeam();
        this.awayTeam = g.getAwayTeam();
        this.setHomePlayers(g.getHomePlayers());
        this.setAwayPlayers(g.getAwayPlayers());
        this.setHomeSubs(g.getHomeSubs());
        this.setAwaySubs(g.getAwaySubs());
        this.homeGoals = g.getHomeGoals();
        this.awayGoals = g.getAwayGoals();
        this.homeDefenseOverall = g.getHomeDefenseOverall();
        this.homeAttackingOverall = g.getHomeAttackingOverall();
        this.awayDefenseOverall = g.getAwayDefenseOverall();
        this.awayAttackingOverall = g.getAwayAttackingOverall();
        this.homeControllingOverall = g.getHomeControllingOverall();
        this.awayControllingOverall = g.getAwayControllingOverall();
        this.timer = g.getTimer();
        this.meteorology = g.getMeteorology();
        this.ld = g.getLd();
    }

    /**
     * Game cloner
     * @return a game cloner
     */
    public Game clone(){
        return new Game(this);
    }

    /**
     * Getter of homePlayers numbers
     * @return Set of home players numbers
     */
    public Set<Integer> getHomePlayers(){
        return new HashSet<>(this.homePlayers);
    }

    /**
     * Setter of homePlayers numbers
     * @param homePlayers Set of numbers
     */
    public void setHomePlayers(Set<Integer> homePlayers){
        this.homePlayers.addAll(homePlayers);
    }

    /**
     * Getter of awayPlayers numbers
     * @return Set of away players numbers
     */
    public Set<Integer> getAwayPlayers(){
        return new HashSet<>(this.awayPlayers);
    }

    /**
     * Setter of awayPlayers numbers
     * @param awayPlayers Set of numbers
     */
    public void setAwayPlayers(Set<Integer> awayPlayers){
        this.awayPlayers.addAll(awayPlayers);
    }

    /**
     * Getter of home team
     * @return Clone of home team
     */
    public Team getHomeTeam() {
        return this.homeTeam.clone();
    }

    /**
     * Setter of home team
     * @param homeTeam Team to set
     */
    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    /**
     * Getter of away team
     * @return Clone of away team
     */
    public Team getAwayTeam() {
        return this.awayTeam.clone();
    }

    /**
     * Setter of away team
     * @param awayTeam Team to set
     */
    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    /**
     * Getter of homeSubstitutions
     * @return Map of substitutions
     */
    public Map<Integer, Integer> getHomeSubs() {
        return new HashMap<>(homeSubs);
    }

    /**
     * Setter of homeSubstitutions
     * @param homeSubs Map to set
     */
    public void setHomeSubs(Map<Integer, Integer> homeSubs) {
        this.homeSubs = homeSubs;
    }

    /**
     * Getter of awaySubstitutions
     * @return Map of substitutions
     */
    public Map<Integer, Integer> getAwaySubs() {
        return new HashMap<>(awaySubs);
    }

    /**
     * Setter of awaySubstitutions
     * @param awaySubs Map to set
     */
    public void setAwaySubs(Map<Integer, Integer> awaySubs) {
        this.awaySubs = awaySubs;
    }

    /**
     * Getter of goals scored by the home team
     * @return Goals scored by the home team
     */
    public int getHomeGoals() {
        return this.homeGoals;
    }

    /**
     * Setter of goals scored by the home team
     * @param homeGoals Goals to set
     */
    public void setHomeGoals(int homeGoals) {
        this.homeGoals = homeGoals;
    }

    /**
     * Getter of goals scored by the away team
     * @return Goals scored by the away team
     */
    public int getAwayGoals() {
        return this.awayGoals;
    }

    /**
     * Setter of goals scored by the away team
     * @param awayGoals Goals to set
     */
    public void setAwayGoals(int awayGoals) {
        this.awayGoals = awayGoals;
    }

    /**
     * Getter of current game time
     * @return Current game time
     */
    public int getTimer() {
        return this.timer;
    }

    /**
     * Setter of current game time
     * @param timer Time to set
     */
    public void setTimer(int timer) {
        this.timer = timer;
    }

    /**
     * Getter of game meteorology
     * @return Game meteorology
     */
    public Meteorology getMeteorology() {
        return this.meteorology;
    }

    /**
     * Setter of game meteorology
     * @param meteorology Meteorology to set
     */
    public void setMeteorology(Meteorology meteorology) {
        this.meteorology = meteorology;
    }

    /**
     * Getter of game date
     * @return Game date
     */
    public LocalDate getLd() {
        return this.ld;
    }

    /**
     * Setter of game date
     * @param ld Date to set
     */
    public void setLd(LocalDate ld) {
        this.ld = ld;
    }

    /**
     * Setter of home team defense overall
     * @param homeDefenseOverall Overall to set
     */
    public void setHomeDefenseOverall(int homeDefenseOverall){
        this.homeDefenseOverall = homeDefenseOverall;
    }

    /**
     * Getter of home team defense overall
     * @return Home team defense overall
     */
    public int getHomeDefenseOverall(){
        return this.homeDefenseOverall;
    }

    /**
     * Setter of away team defense overall
     * @param awayDefenseOverall Overall to set
     */
    public void setAwayDefenseOverall(int awayDefenseOverall){
        this.awayDefenseOverall = awayDefenseOverall;
    }

    /**
     * Getter of away team defense overall
     * @return Away team defense overall
     */
    public int getAwayDefenseOverall(){
        return this.awayDefenseOverall;
    }

    /**
     * Setter of home team attacking overall
     * @param homeAttackingOverall Overall to set
     */
    public void setHomeAttackingOverall(int homeAttackingOverall){
        this.homeAttackingOverall = homeAttackingOverall;
    }

    /**
     * Getter of home team attacking overall
     * @return Home team attacking overall
     */
    public int getHomeAttackingOverall(){
        return this.homeAttackingOverall;
    }

    /**
     * Setter of away team attacking overall
     * @param awayAttackingOverall Overall to set
     */
    public void setAwayAttackingOverall(int awayAttackingOverall){
        this.awayAttackingOverall = awayAttackingOverall;
    }

    /**
     * Getter of away team attacking overall
     * @return Away team attacking overall
     */
    public int getAwayAttackingOverall(){
        return this.awayAttackingOverall;
    }

    /**
     * Setter of home team controlling overall
     * @param homeControllingOverall Overall to set
     */
    public void setHomeControllingOverall(int homeControllingOverall){
        this.homeControllingOverall = homeControllingOverall;
    }

    /**
     * Getter of home team controlling overall
     * @return Home team controlling overall
     */
    public int getHomeControllingOverall(){
        return this.homeControllingOverall;
    }

    /**
     * Setter of away team controlling overall
     * @param awayControllingOverall Away team controlling overall
     */
    public void setAwayControllingOverall(int awayControllingOverall){
        this.awayControllingOverall = awayControllingOverall;
    }

    /**
     * Getter of away team controlling overall
     * @return Away team controlling overall
     */
    public int getAwayControllingOverall(){
        return this.awayControllingOverall;
    }

    /**
     * Method to advance timer
     * @param time Time to add to timer
     * @param max Max time of the game
     */
    public void advanceTime(int time, int max){
        if(this.timer + time < max) this.timer += time;
        else this.timer = max;
    }

    /**
     * Method to increment home team goals
     */
    public void addHomeGoal(){
        this.homeGoals++;
    }

    /**
     * Method to increment away team goals
     */
    public void addAwayGoal(){
        this.awayGoals++;
    }

    /**
     * Method to execute a substitution for home team
     * @param numIn Number of the player to enter
     * @throws InvalidPlayerException Exception to control if the player to enter is in the bench and if the player to get out is playing
     */
    public void executeHomeSubstitution(int numIn) throws InvalidPlayerException{
        if(!this.homeSubs.containsKey(numIn)) throw new InvalidPlayerException("Player with number " + numIn + " isn't in the bench");
        else if(!this.homePlayers.contains(this.homeSubs.get(numIn))) throw new InvalidPlayerException("Player with number " + this.homeSubs.get(numIn) + " isn't playing");
        this.homePlayers.remove(this.homeSubs.get(numIn));
        this.homePlayers.add(numIn);
        this.homeSubs.remove(numIn);
        this.calcAttackingOverall(this.homeTeam, this.homePlayers);
        this.calcDefenseOverall(this.homeTeam, this.homePlayers);
    }

    /**
     * Method to execute a substitution for away team
     * @param numIn Number of the player to enter
     * @throws InvalidPlayerException Exception to control if the player to enter is in the bench and if the player to get out is playing
     */
    public void executeAwaySubstitution(int numIn) throws InvalidPlayerException{
        if(!this.awaySubs.containsKey(numIn)) throw new InvalidPlayerException("Player with number " + numIn + " isn't in the bench");
        else if(!this.awayPlayers.contains(this.awaySubs.get(numIn))) throw new InvalidPlayerException("Player with number " + this.homeSubs.get(numIn) + " isn't playing");
        this.awayPlayers.remove(this.awaySubs.get(numIn));
        this.awayPlayers.add(numIn);
        this.awaySubs.remove(numIn);
        this.calcAttackingOverall(this.awayTeam, this.awayPlayers);
        this.calcDefenseOverall(this.awayTeam, this.awayPlayers);
    }

    /**
     * Method to calculate defense capacity of Team team
     * @param team Team to calculate defense capacity
     * @param playersNums Current lineup of team
     * @return Defense overall of the lineup
     * @throws InvalidPlayerException Exception to check if players really exists in team
     */
    public int calcDefenseOverall(Team team, Set<Integer> playersNums) throws InvalidPlayerException{
        int acDef = 0, nDefs = 0, acMd = 0, nMds = 0, avDf, avMd;
        for(Integer n : playersNums){
            if(!team.getPlayers().containsKey(n)) throw new InvalidPlayerException("There isn't a player with number " + n + " playing for " + team.getName());
            if(team.getPlayers().get(n).getCurPosition().equals(Position.GOALKEEPER) || team.getPlayers().get(n).getCurPosition().equals(Position.DEFENDER)){
                acDef += team.getPlayers().get(n).getOverall();
                nDefs++;
            }
            else if(team.getPlayers().get(n).getCurPosition().equals(Position.MIDFIELDER) || team.getPlayers().get(n).getCurPosition().equals(Position.WINGER)){
                acMd += team.getPlayers().get(n).getOverall();
                nMds++;
            }
        }

        avDf = acDef / nDefs;
        avMd = acMd / nMds;

        return (int) (avDf * 0.75 + avMd * 0.25);
    }

    /**
     * Method to calculate attacking capacity of Team team
     * @param team Team to calculate attacking capacity
     * @param playerNums Current lineup of team
     * @return Attacking overall of the lineup
     * @throws InvalidPlayerException Exception to check if players really exists in team
     */
    public int calcAttackingOverall(Team team, Set<Integer> playerNums) throws InvalidPlayerException{
        int acAtt = 0, nAtt = 0, acMd = 0, nMds = 0, avAtt, avMd;
        for(Integer n : playerNums){
            if(!team.getPlayers().containsKey(n)) throw new InvalidPlayerException("There isn't a player with number " + n + " playing for " + team.getName());
            if(team.getPlayers().get(n).getCurPosition().equals(Position.FORWARD)){
                acAtt += team.getPlayers().get(n).getOverall();
                nAtt++;
            }
            else if(team.getPlayers().get(n).getCurPosition().equals(Position.MIDFIELDER) || team.getPlayers().get(n).getCurPosition().equals(Position.WINGER)){
                acMd += team.getPlayers().get(n).getOverall();
                nMds++;
            }
        }

        avAtt = acAtt / nAtt;
        avMd = acMd / nMds;

        return (int) (avAtt * 0.75 + avMd * 0.25);
    }

    /**
     * Method to calculate controlling capacity of Team team
     * @param team Team to calculate controlling capacity
     * @param playerNums Current lineup of team
     * @return Controlling overall of the lineup
     * @throws InvalidPlayerException Exception to check if players really exists in team
     */
    public int calcControllingOverall(Team team, Set<Integer> playerNums) throws InvalidPlayerException{
        int acCont = 0, nCont = 0, acAD = 0, nAD = 0, avCont, avAD;
        for(Integer n : playerNums){
            if(!team.getPlayers().containsKey(n)) throw new InvalidPlayerException("There isn't a player with number " + n + " playing for " + team.getName());
            if(team.getPlayers().get(n).getCurPosition().equals(Position.MIDFIELDER) || team.getPlayers().get(n).getCurPosition().equals(Position.WINGER)){
                acCont += team.getPlayers().get(n).getOverall();
                nCont++;
            }
            else if(team.getPlayers().get(n).getCurPosition().equals(Position.FORWARD) || team.getPlayers().get(n).getCurPosition().equals(Position.DEFENDER)){
                acAD += team.getPlayers().get(n).getOverall();
                nAD++;
            }
        }
        avCont = acCont / nCont;
        avAD = acAD / nAD;

        return (int) (avCont * 0.75 + avAD * 0.25);
    }

    /**
     * Method to advance a part in a game and execute actions
     * @param parts Number of parts that the game is divided in
     * @param gameTime Maximum time of the game
     */
    public void advancePartInGame(int parts, int gameTime){
        int timeToAdv = (int) (gameTime / parts), numberOfActions = 1;
        advanceTime(timeToAdv, gameTime);
        if(this.timer != gameTime) {
            if (timeToAdv > 10) {
                numberOfActions = utils.getRandNum(timeToAdv / 10);
            }
            for (int i = 0; i < numberOfActions; i++) {
                if (utils.randPossession(this.homeControllingOverall, this.awayControllingOverall)) {
                    if (utils.randGoal(this.homeAttackingOverall, this.awayDefenseOverall)) addHomeGoal();
                } else if (utils.randGoal(this.awayAttackingOverall, this.homeDefenseOverall)) addAwayGoal();
            }
        }
    }

    public void setRandomMeteorology(){
        int bingo = utils.getRandNum(5);
        switch (bingo) {
            case 1 -> this.meteorology = Meteorology.RAIN;
            case 2 -> this.meteorology = Meteorology.FOGGY;
            case 3 -> this.meteorology = Meteorology.WINDY;
            case 4 -> this.meteorology = Meteorology.SNOWY;
            default -> this.meteorology = Meteorology.SUN;
        }
    }

    /**
     * Method to get Game in a String
     * @return String of a Game
     */
    public String toString(){
        StringBuilder sb = new StringBuilder("Game:{\n")
                .append("Date: ").append(ld).append(" ").append("(").append(meteorology).append(")\n")
                .append(homeTeam).append(" ").append(homeGoals).append(" vs ").append(awayGoals).append(" ").append(awayTeam).append("\n")
                .append("Home Players:\n")
                .append(homePlayers.toString()).append("\n")
                .append("Away Players:\n")
                .append(awayPlayers.toString()).append("\n");
        return sb.toString();
    }

    /**
     * Method to check if an object is equal to a certain game
     * @param o Object to compare
     * @return true if the object is equal to the game, false otherwise
     */
    public boolean equals(Object o){
        if(this == o) return true;
        else if(o == null || this.getClass() != o.getClass()) return false;
        Game g = (Game) o;
        return(this.homeTeam.equals(g.getHomeTeam()) && this.awayTeam.equals(g.getAwayTeam()) && this.ld.equals(g.getLd()) && this.homePlayers.equals(g.getHomePlayers())
                && this.awayPlayers.equals(g.getAwayPlayers()) && this.homeSubs.equals(g.getHomeSubs()) && this.awaySubs.equals(g.getAwaySubs()) && this.homeGoals == g.getHomeGoals()
                && this.awayGoals == g.getAwayGoals() && this.meteorology.equals(g.getMeteorology()));
    }
}
