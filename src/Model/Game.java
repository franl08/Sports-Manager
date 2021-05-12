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
    private String meteorology;
    private LocalDate ld;

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
        this.meteorology = "Sun";
        this.ld = LocalDate.now();
    }

    public Game(Team homeTeam, Team awayTeam){
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
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
        this.meteorology = "Sun";
        this.ld = LocalDate.now();
    }

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
        this.meteorology = "Sun";
        this.ld = LocalDate.now();
    }

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
        this.timer = 0;
        this.meteorology = "Sun";
        this.ld = LocalDate.now();
    }

    public Game(Team homeTeam, Team awayTeam, Set<Integer> homePlayers, Set<Integer> awayPlayers, HashMap<Integer, Integer> homeSubs, HashMap<Integer, Integer> awaySubs, LocalDate ld){
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
        this.timer = 0;
        this.meteorology = "Sun";
        this.ld = ld;
    }

    public Game(Team homeTeam, Team awayTeam, Set<Integer> homePlayers, Set<Integer> awayPlayers, HashMap<Integer, Integer> homeSubs, HashMap<Integer, Integer> awaySubs, String meteorology){
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
        this.timer = 0;
        this.meteorology = meteorology;
        this.ld = LocalDate.now();
    }

    public Game(Team homeTeam, Team awayTeam, Set<Integer> homePlayers, Set<Integer> awayPlayers, HashMap<Integer, Integer> homeSubs, HashMap<Integer, Integer> awaySubs, String meteorology, LocalDate ld){
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
        this.timer = 0;
        this.meteorology = meteorology;
        this.ld = ld;
    }

    public Game(Team homeTeam, Team awayTeam, Set<Integer> homePlayers, Set<Integer> awayPlayers, Map<Integer, Integer> homeSubs, Map<Integer, Integer> awaySubs, int homeGoals, int awayGoals, int timer, int homeOverall, int awayOverall, String meteorology, LocalDate ld) {
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

    public Team getHomeTeam() {
        return this.homeTeam.clone();
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team getAwayTeam() {
        return this.awayTeam.clone();
    }

    public void setAwayTeam(Team awayTeam) {
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

    public void setHomeDefenseOverall(int homeDefenseOverall){
        this.homeDefenseOverall = homeDefenseOverall;
    }

    public int getHomeDefenseOverall(){
        return this.homeDefenseOverall;
    }

    public void setAwayDefenseOverall(int awayDefenseOverall){
        this.awayDefenseOverall = awayDefenseOverall;
    }

    public int getAwayDefenseOverall(){
        return this.awayDefenseOverall;
    }

    public void setHomeAttackingOverall(int homeAttackingOverall){
        this.homeAttackingOverall = homeAttackingOverall;
    }

    public int getHomeAttackingOverall(){
        return this.homeAttackingOverall;
    }

    public void setAwayAttackingOverall(int awayAttackingOverall){
        this.awayAttackingOverall = awayAttackingOverall;
    }

    public int getAwayAttackingOverall(){
        return this.awayAttackingOverall;
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
        this.calcAttackingOverall(this.homeTeam, this.homePlayers);
        this.calcDefenseOverall(this.homeTeam, this.homePlayers);
    }

    public void executeAwaySubstitution(Team t, int numIn) throws InvalidPlayerException{
        if(!this.awaySubs.containsKey(numIn)) throw new InvalidPlayerException("Player with number " + numIn + " isn't in the bench");
        else if(!this.awayPlayers.contains(this.awaySubs.get(numIn))) throw new InvalidPlayerException("Player with number " + this.homeSubs.get(numIn) + " isn't playing");
        this.awayPlayers.remove(this.awaySubs.get(numIn));
        this.awayPlayers.add(numIn);
        this.awaySubs.remove(numIn);
        this.calcAttackingOverall(this.awayTeam, this.awayPlayers);
        this.calcDefenseOverall(this.awayTeam, this.awayPlayers);
    }

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
