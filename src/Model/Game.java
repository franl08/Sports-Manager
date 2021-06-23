package Model;

import View.View;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Game class
 */
public class Game implements Serializable {
    /**
     * Home Team
     */
    private Team homeTeam;
    /**
     * Away Team
     */
    private Team awayTeam;
    /**
     * Home lineup
     */
    private Set<Integer> homePlayers;
    /**
     * Away lineup
     */
    private Set<Integer> awayPlayers;
    /**
     * Home substitutions
     */
    private Map<Integer, Integer> homeSubs;
    /**
     * Away substitutions
     */
    private Map<Integer, Integer> awaySubs;
    /**
     * Home goals
     */
    private int homeGoals;
    /**
     * Away goals
     */
    private int awayGoals;
    /**
     * Game timer
     */
    private int timer;
    /**
     * Home defensive overall
     */
    private int homeDefenseOverall;
    /**
     * Away defensive overall
     */
    private int awayDefenseOverall;
    /**
     * Home attacking overall
     */
    private int homeAttackingOverall;
    /**
     * Away attacking overall
     */
    private int awayAttackingOverall;
    /**
     * Home controlling overall
     */
    private int homeControllingOverall;
    /**
     * Away controlling overall
     */
    private int awayControllingOverall;
    /**
     * Game Meteorology
     */
    private Meteorology meteorology;
    /**
     * Game date
     */
    private LocalDate ld;
    /**
     * Number of executed substitutions by the home team
     */
    private int nHomeSubs;
    /**
     * Number of executed substitutions by the away team
     */
    private int nAwaySubs;

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
        this.nAwaySubs = 0;
        this.nHomeSubs = 0;
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
     * Constructor with teams and lineups
     * @param homeTeam Home team
     * @param awayTeam Away team
     * @param homePlayers Home lineup
     * @param awayPlayers Away lineup
     */
    public Game(Team homeTeam, Team awayTeam, Set<Integer> homePlayers, Set<Integer> awayPlayers){
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.setHomePlayers(homePlayers);
        this.setAwayPlayers(awayPlayers);
        this.homeGoals = 0;
        this.awayGoals = 0;
        this.homeSubs = new HashMap<>();
        this.awaySubs = new HashMap<>();
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
        this.nHomeSubs = 0;
        this.nAwaySubs = 0;
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
        this.homeGoals = homeGoals;
        this.awayGoals = awayGoals;
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
        this.nHomeSubs = homeSubs.size();
        this.nAwaySubs = awaySubs.size();
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
        this.nHomeSubs = g.getnHomeSubs();
        this.nAwaySubs = g.getnAwaySubs();
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
        this.homePlayers = new HashSet<>(homePlayers);
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
        this.awayPlayers = new HashSet<>(awayPlayers);
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
        this.homeSubs = new HashMap<>(homeSubs);
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
        this.awaySubs = new HashMap<>(awaySubs);
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
     * Number of home substitutions getter
     * @return Number of executed substitutions by the home team
     */
    public int getnHomeSubs() {
        return this.nHomeSubs;
    }

    /**
     * Number of home substitutions setter
     * @param nHomeSubs Number of substitutions to set
     */
    public void setnHomeSubs(int nHomeSubs) {
        this.nHomeSubs = nHomeSubs;
    }

    /**
     * Number of away substitutions getter
     * @return Number of executed substitutions by the away team
     */
    public int getnAwaySubs() {
        return this.nAwaySubs;
    }

    /**
     * Number of away substitutions setter
     * @param nAwaySubs Number of substitutions to set
     */
    public void setnAwaySubs(int nAwaySubs) {
        this.nAwaySubs = nAwaySubs;
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
     * @param numOut Number of the player to be taken
     * @return String telling the substitution
     * @throws InvalidPlayerException Exception to control if the player to enter is in the bench and if the player to get out is playing
     * @throws NumberOfMaximumSubsException Exception to control number of substitutions
     */
    public String executeHomeSubstitution(int numIn, int numOut) throws InvalidPlayerException, NumberOfMaximumSubsException{
        if(this.nHomeSubs >= 3) throw new NumberOfMaximumSubsException("Number of maximum substitutions for the home team already reached");
        if(this.homePlayers.contains(numIn)) throw new InvalidPlayerException("Player with number " + numIn + " is playing");
        else if(!this.homePlayers.contains(numOut)) throw new InvalidPlayerException("Player with number " + numOut + " isn't playing");
        StringBuilder sb = new StringBuilder("Substitution on ").append(this.homeTeam.getName()).append(": ")
                .append(this.homeTeam.getPlayers().get(numOut).getName()).append(" will be replaced by ")
                .append(this.homeTeam.getPlayers().get(numIn).getName());
        this.homePlayers.add(numIn);
        this.homePlayers.remove(numOut);
        this.homeSubs.put(numOut, numIn);
        this.nHomeSubs++;
        this.calcAttackingOverall(this.homeTeam, this.homePlayers);
        this.calcDefenseOverall(this.homeTeam, this.homePlayers);
        return sb.toString();
    }

    /**
     * Method to execute a substitution for home team
     * @param numIn Number of the player to enter
     * @param numOut Number of the player to be taken
     * @return String telling the substitution
     * @throws InvalidPlayerException Exception to control if the player to enter is in the bench and if the player to get out is playing
     * @throws NumberOfMaximumSubsException Exception to control number of substitutions
     */
    public String executeAwaySubstitution(int numIn, int numOut) throws InvalidPlayerException, NumberOfMaximumSubsException{
        if(this.nAwaySubs >= 3) throw new NumberOfMaximumSubsException("Number of maximum substitutions for the home team already reached");
        if(this.awayPlayers.contains(numIn)) throw new InvalidPlayerException("Player with number " + numIn + " is playing");
        else if(!this.awayPlayers.contains(numOut)) throw new InvalidPlayerException("Player with number " + numOut + " isn't playing");
        StringBuilder sb = new StringBuilder("Substitution on ").append(this.awayTeam.getName()).append(": ")
                .append(this.awayTeam.getPlayers().get(numOut).getName()).append(" will be replaced by ")
                .append(this.awayTeam.getPlayers().get(numIn).getName());
        this.awayPlayers.add(numIn);
        this.awayPlayers.remove(numOut);
        this.awaySubs.put(numOut, numIn);
        this.nAwaySubs++;
        this.calcAttackingOverall(this.awayTeam, this.awayPlayers);
        this.calcDefenseOverall(this.awayTeam, this.awayPlayers);
        return sb.toString();
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
                Player p = team.getPlayers().get(n);
                if(p.getPosition() != p.getCurPosition()){
                    FieldPlayer fp = (FieldPlayer) p;
                    DF d = new DF(fp);
                    acDef += d.calcOverall();
                }
                else acDef += team.getPlayers().get(n).getOverall();
                nDefs++;
            }
            else if(team.getPlayers().get(n).getCurPosition().equals(Position.MIDFIELDER) || team.getPlayers().get(n).getCurPosition().equals(Position.WINGER)){
                Player p = team.getPlayers().get(n);
                if(p.getPosition() != p.getCurPosition()){
                    FieldPlayer fp = (FieldPlayer) p;
                    MD m = new MD(fp);
                    acMd += m.calcOverall();
                }
                else acMd += team.getPlayers().get(n).getOverall();
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
                Player p = team.getPlayers().get(n);
                if(p.getPosition() != p.getCurPosition()){
                    FieldPlayer fp = (FieldPlayer) p;
                    FW f = new FW(fp);
                    acAtt += f.calcOverall();
                }
                else acAtt += team.getPlayers().get(n).getOverall();
                nAtt++;
            }
            else if(team.getPlayers().get(n).getCurPosition().equals(Position.MIDFIELDER) || team.getPlayers().get(n).getCurPosition().equals(Position.WINGER)){
                Player p = team.getPlayers().get(n);
                if(p.getPosition() != p.getCurPosition()){
                    FieldPlayer fp = (FieldPlayer) p;
                    MD m = new MD(fp);
                    acMd += m.calcOverall();
                }
                else acMd += team.getPlayers().get(n).getOverall();
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
                Player p = team.getPlayers().get(n);
                if(p.getPosition() != p.getCurPosition()){
                    FieldPlayer fp = (FieldPlayer) p;
                    MD m = new MD(fp);
                    acCont += m.calcOverall();
                }
                else acCont += team.getPlayers().get(n).getOverall();
                nCont++;
            }
            else if(team.getPlayers().get(n).getCurPosition().equals(Position.FORWARD) || team.getPlayers().get(n).getCurPosition().equals(Position.DEFENDER)){
                Player p = team.getPlayers().get(n);
                if(p.getPosition() != p.getCurPosition()){
                    FieldPlayer fp = (FieldPlayer) p;
                    if (p.getCurPosition() == Position.FORWARD) {
                        FW f = new FW(fp);
                        acAD += f.calcOverall();
                    }
                    DF d = new DF(fp);
                    acAD += d.calcOverall();
                }
                else acAD += team.getPlayers().get(n).getOverall();
                nAD++;
            }
        }
        avCont = acCont / nCont;
        avAD = acAD / nAD;

        return (int) (avCont * 0.75 + avAD * 0.25);
    }

    /**
     * Method to get one string simulating a goal in the game
     * @param team Team's with possession name
     * @return String with the goal
     */
    public String getStringGoal(String team){
        StringBuilder ans = new StringBuilder();
        int bingo = utils.getRandNum(5) + 1;
        switch(bingo){
            case 1 -> ans.append("GOAAAAAAL! What a mistake by the opposite team! It was too easy for them...  ").append(team).append(" add one goal to the result.\n");
            case 2 -> ans.append("GOAAAAAAL! What a long shot, the goalkeeper couldn't see it! Pure moment of inspiration by them, it's a goal for ").append(team).append("\n");
            case 3 -> ans.append("GOAAAAAAL! Fantastic individual play, no one couldn't stop this player. Magician! And with this we have one goal to ").append(team).append("\n");
            case 4 -> ans.append("GOAAAAAAL! This is how we play! Beautiful play by the team, tiki-taka style. I bet all of them touched the ball! Goal for ").append(team).append("\n");
            case 5 -> ans.append("GOAAAAAAL! Fantastic shot, but I guess the goalkeeper should have done a better job... Goal for ").append(team).append("\n");
        }
        return ans.toString();
    }

    /**
     * Method to get one string simulating one action in the game
     * @param team Team's with possession name
     * @return String with the action
     */
    public String getStringNoGoal(String team){
        StringBuilder ans = new StringBuilder();
        int bingo = utils.getRandNum(5) + 1;
        switch(bingo){
            case 1 -> ans.append("Oh no... What a miss by them! This should be illegal on this sport. ").append(team).append(" had the ball but lost a great opportunity.\n");
            case 2 -> ans.append("What a tackle! And they say: Nothing will pass this wall! ").append(team).append(" had the ball but couldn't make anything against their defense.\n");
            case 3 -> ans.append("Too much, only too much. Tried to do everything alone. Lost it! Of course... The next time, pass the ball!! ").append(team).append(" had the ball but lost it.\n");
            case 4 -> ans.append("So close!! What a nice shot, but the lucky wasn't with them! ").append(team).append(" almost scored, but they will take only the almost.\n");
            case 5 -> ans.append("And what a keeper we have here! The crowd was already screaming goal! Nothing will enter there if he has more of this to offer!").append(team).append(" almost scored, but the opposite keeper says no to them.\n");
        }
        return ans.toString();
    }

    /**
     * Method to advance a part in a game and execute actions
     * @param parts Number of parts that the game is divided in
     * @param gameTime Maximum time of the game
     * @return String with the occurrences of the simulated part
     */
    public String advancePartInGame(int parts, int gameTime){
        StringBuilder ocs = new StringBuilder();
        String hT = this.homeTeam.getName();
        String aT = this.awayTeam.getName();
        int timeToAdv = (int) (gameTime / parts), numberOfActions = 1;
        advanceTime(timeToAdv, gameTime);
        this.timer--;
        if(this.timer++ != gameTime) {
            if (timeToAdv > 10) {
                numberOfActions = utils.getRandNum(timeToAdv) + 1;
            }
            for (int i = 0; i < numberOfActions; i++) {
                if (utils.randPossession(this.homeControllingOverall, this.awayControllingOverall)) {
                    if (utils.randGoal(this.homeAttackingOverall, this.awayDefenseOverall)) {
                        addHomeGoal();
                        ocs.append(getStringGoal(hT));
                    }
                    else ocs.append(getStringNoGoal(hT));
                }
                else if (utils.randGoal(this.awayAttackingOverall, this.homeDefenseOverall)){
                    addAwayGoal();
                    ocs.append(getStringGoal(aT));
                }
                else ocs.append(getStringNoGoal(aT));
            }
        }
        return ocs.toString();
    }

    /**
     * Method to get a message after a part being simulated
     * @return String with the message
     */
    public String partGameMessage(){
        StringBuilder ocs = new StringBuilder("Current result at minute ").append(this.timer).append(": ")
                .append(this.homeTeam.getName()).append(" ").append(this.homeGoals)
                .append(" vs ")
                .append(this.awayGoals).append(" ").append(this.awayTeam.getName()).append(" \n");
        return ocs.toString();
    }

    /**
     * Method to get a final game message
     * @return String with final game message
     */
    public String finalGameMessage(){
       StringBuilder ocs = new StringBuilder("That's it! End of the game and the final result is: ")
                .append(this.homeTeam.getName()).append(" ").append(this.homeGoals)
                .append(" vs ")
                .append(this.awayGoals).append(" ").append(this.awayTeam.getName()).append(" \n");
       return ocs.toString();
}

    /**
     * Method to get a random meteorology for the game
     */
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
     * Method to get a String telling the conditions at the begin of a game
     * @return String telling the conditions at the begin of a game
     */
    public String getInitialGameConditions(){
        StringBuilder sb = new StringBuilder("Hello everybody and welcome to a great day of football! And the game for today is:\n")
                .append(homeTeam.getName()).append(" vs ").append(awayTeam.getName()).append("\n");
        switch(this.meteorology){
            case SUN -> sb.append("We have a magnificent day of sun to a great day of sport.\n");
            case FOGGY -> sb.append("The day is completely cloudy and players will have difficulty seeing the ball.\n");
            case WINDY -> sb.append("Control the ball will be one challenge on this weather conditions. The wing will be a great opponent today.\n");
            case SNOWY -> sb.append("And we see snow! The pitch is white, the players are ready and it's very very cold! Let it start, we need to heat up!\n");
            case RAIN -> sb.append("A lot of rain today will make it harder to us all...\n");
        }
        return sb.toString();
    }

    /**
     * Method to get Game in a String
     * @return String of a Game
     */
    public String toString(){
        StringBuilder sb = new StringBuilder("Game:{\n")
                .append("Date: ").append(ld).append(" ").append("(").append(meteorology).append(")\n")
                .append(homeTeam.getName()).append(" ").append(homeGoals).append(" vs ").append(awayGoals).append(" ").append(awayTeam.getName()).append("\n")
                .append("Home Players:\n")
                .append(homePlayers.toString()).append("\n")
                .append("Away Players:\n")
                .append(awayPlayers.toString()).append("\n")
                .append("}");
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
