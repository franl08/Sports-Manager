package Model;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Game {
    private String homeTeam;
    private String awayTeam;
    private Set<Integer> homePlayers;
    private Set<Integer> awayPlayers;
    private Map<Integer, Integer> homeSubs;
    private Map<Integer, Integer> awaySubs;
    private int homeGoals;
    private int awayGoals;
    private int timer;
    private int homeOverall;
    private int awayOverall;
    private String meteorology;
    private LocalDate ld;

    public Game(){
        this.homeTeam = "n/a";
        this.awayTeam = "n/a";
        this.homePlayers = new HashSet<Integer>();
        this.awayPlayers = new HashSet<Integer>();
        this.homeGoals = 0;
        this.awayGoals = 0;
        this.homeSubs = new HashMap<Integer, Integer>();
        this.awaySubs = new HashMap<Integer, Integer>();
        this.timer = 0;
        this.homeOverall = 0;
        this.awayOverall = 0;
        this.meteorology = "Sun";
        this.ld = LocalDate.now();
    }

    public Game(String homeTeam, String awayTeam){
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homePlayers = new HashSet<Integer>();
        this.awayPlayers = new HashSet<Integer>();
        this.homeGoals = 0;
        this.awayGoals = 0;
        this.homeSubs = new HashMap<Integer, Integer>();
        this.awaySubs = new HashMap<Integer, Integer>();
        this.timer = 0;
        this.homeOverall = 0;
        this.awayOverall = 0;
        this.meteorology = "Sun";
        this.ld = LocalDate.now();
    }

    public Game(String homeTeam, String awayTeam, Set<Integer> homePlayers, Set<Integer> awayPlayers){
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.setHomePlayers(homePlayers);
        this.setAwayPlayers(awayPlayers);
        this.homeGoals = 0;
        this.awayGoals = 0;
        this.homeSubs = new HashMap<Integer, Integer>();
        this.awaySubs = new HashMap<Integer, Integer>();
        this.timer = 0;
        this.meteorology = "Sun";
        this.ld = LocalDate.now();
    }

    public Game(String homeTeam, String awayTeam, Set<Integer> homePlayers, Set<Integer> awayPlayers, HashMap<Integer, Integer> homeSubs, HashMap<Integer, Integer> awaySubs){
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.setHomePlayers(homePlayers);
        this.setAwayPlayers(awayPlayers);
        this.homeGoals = 0;
        this.awayGoals = 0;
        this.setHomeSubs(homeSubs);
        this.setAwaySubs(awaySubs);
        this.timer = 0;
        this.meteorology = "Sun";
        this.ld = LocalDate.now();
    }

    public Game(String homeTeam, String awayTeam, Set<Integer> homePlayers, Set<Integer> awayPlayers, HashMap<Integer, Integer> homeSubs, HashMap<Integer, Integer> awaySubs, LocalDate ld){
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.setHomePlayers(homePlayers);
        this.setAwayPlayers(awayPlayers);
        this.homeGoals = 0;
        this.awayGoals = 0;
        this.setHomeSubs(homeSubs);
        this.setAwaySubs(awaySubs);
        this.timer = 0;
        this.meteorology = "Sun";
        this.ld = ld;
    }

    public Game(String homeTeam, String awayTeam, Set<Integer> homePlayers, Set<Integer> awayPlayers, HashMap<Integer, Integer> homeSubs, HashMap<Integer, Integer> awaySubs, String meteorology){
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.setHomePlayers(homePlayers);
        this.setAwayPlayers(awayPlayers);
        this.homeGoals = 0;
        this.awayGoals = 0;
        this.setHomeSubs(homeSubs);
        this.setAwaySubs(awaySubs);
        this.timer = 0;
        this.meteorology = meteorology;
        this.ld = LocalDate.now();
    }

    public Game(String homeTeam, String awayTeam, Set<Integer> homePlayers, Set<Integer> awayPlayers, HashMap<Integer, Integer> homeSubs, HashMap<Integer, Integer> awaySubs, String meteorology, LocalDate ld){
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.setHomePlayers(homePlayers);
        this.setAwayPlayers(awayPlayers);
        this.homeGoals = 0;
        this.awayGoals = 0;
        this.setHomeSubs(homeSubs);
        this.setAwaySubs(awaySubs);
        this.timer = 0;
        this.meteorology = meteorology;
        this.ld = ld;
    }

    public Game(String homeTeam, String awayTeam, Set<Integer> homePlayers, Set<Integer> awayPlayers, Map<Integer, Integer> homeSubs, Map<Integer, Integer> awaySubs, int homeGoals, int awayGoals, int timer, int homeOverall, int awayOverall, String meteorology, LocalDate ld) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.setHomePlayers(homePlayers);
        this.setAwayPlayers(awayPlayers);
        this.setHomeSubs(homeSubs);
        this.setAwaySubs(awaySubs);
        this.homeGoals = homeGoals;
        this.awayGoals = awayGoals;
        this.timer = timer;
        this.meteorology = meteorology;
        this.ld = ld;
    }

    public Game(Game g){
        this.homeTeam = g.getHomeTeam();
        this.awayTeam = g.getAwayTeam();
        this.setHomePlayers(g.getHomePlayers());
        this.setAwayPlayers(g.getAwayPlayers());
        this.setHomeSubs(g.getHomeSubs());
        this.setAwaySubs(g.getAwaySubs());
        this.homeGoals = g.getHomeGoals();
        this.awayGoals = g.getAwayGoals();
        this.homeOverall = g.getHomeOverall();
        this.awayOverall = g.getAwayOverall();
        this.timer = g.getTimer();
        this.meteorology = g.getMeteorology();
        this.ld = g.getLd();
    }

    public Game clone(){
        return new Game(this);
    }

    public Set<Integer> getHomePlayers(){
        return new HashSet<>(this.homePlayers);
    }

    public void setHomePlayers(Set<Integer> homePlayers){
        this.homePlayers.addAll(homePlayers);
    }

    public Set<Integer> getAwayPlayers(){
        return new HashSet<>(this.awayPlayers);
    }

    public void setAwayPlayers(Set<Integer> awayPlayers){
        this.awayPlayers.addAll(awayPlayers);
    }

    public String getHomeTeam() {
        return this.homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return this.awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public Map<Integer, Integer> getHomeSubs() {
        return new HashMap<>(homeSubs);
    }

    public void setHomeSubs(Map<Integer, Integer> homeSubs) {
        this.homeSubs = homeSubs;
    }

    public Map<Integer, Integer> getAwaySubs() {
        return new HashMap<>(awaySubs);
    }

    public void setAwaySubs(Map<Integer, Integer> awaySubs) {
        this.awaySubs = awaySubs;
    }

    public int getHomeGoals() {
        return this.homeGoals;
    }

    public void setHomeGoals(int homeGoals) {
        this.homeGoals = homeGoals;
    }

    public int getAwayGoals() {
        return this.awayGoals;
    }

    public void setAwayGoals(int awayGoals) {
        this.awayGoals = awayGoals;
    }

    public int getTimer() {
        return this.timer;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }

    public int getHomeOverall() {
        return this.homeOverall;
    }

    public void setHomeOverall(int homeOverall) {
        this.homeOverall = homeOverall;
    }

    public int getAwayOverall() {
        return this.awayOverall;
    }

    public void setAwayOverall(int awayOverall) {
        this.awayOverall = awayOverall;
    }

    public String getMeteorology() {
        return this.meteorology;
    }

    public void setMeteorology(String meteorology) {
        this.meteorology = meteorology;
    }

    public LocalDate getLd() {
        return this.ld;
    }

    public void setLd(LocalDate ld) {
        this.ld = ld;
    }

    public void advanceTime(int time){
        if(this.timer + time < 90) this.timer += time;
        else this.timer = 90;
    }

    public void addHomeGoal(){
        this.homeGoals++;
    }

    public void addAwayGoal(){
        this.awayGoals++;
    }

    public void executeHomeSubstitution(int numIn) throws InvalidPlayerException{
        if(!this.homeSubs.containsKey(numIn)) throw new InvalidPlayerException("Player with number " + numIn + " isn't in the bench");
        else if(!this.homePlayers.contains(this.homeSubs.get(numIn))) throw new InvalidPlayerException("Player with number " + this.homeSubs.get(numIn) + " isn't playing");
        this.homePlayers.remove(this.homeSubs.get(numIn));
        this.homePlayers.add(numIn);
        this.homeSubs.remove(numIn);
    }

    public void executeAwaySubstitution(int numIn) throws InvalidPlayerException{
        if(!this.awaySubs.containsKey(numIn)) throw new InvalidPlayerException("Player with number " + numIn + " isn't in the bench");
        else if(!this.awayPlayers.contains(this.awaySubs.get(numIn))) throw new InvalidPlayerException("Player with number " + this.homeSubs.get(numIn) + " isn't playing");
        this.awayPlayers.remove(this.awaySubs.get(numIn));
        this.awayPlayers.add(numIn);
        this.awaySubs.remove(numIn);
    }

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

    public boolean equals(Object o){
        if(this == o) return true;
        else if(o == null || this.getClass() != o.getClass()) return false;
        Game g = (Game) o;
        return(this.homeTeam.equals(g.getHomeTeam()) && this.awayTeam.equals(g.getAwayTeam()) && this.ld.equals(g.getLd()) && this.homePlayers.equals(g.getHomePlayers())
                && this.awayPlayers.equals(g.getAwayPlayers()) && this.homeSubs.equals(g.getHomeSubs()) && this.awaySubs.equals(g.getAwaySubs()) && this.homeGoals == g.getHomeGoals()
                && this.awayGoals == g.getAwayGoals() && this.meteorology.equals(g.getMeteorology()));
    }
}
