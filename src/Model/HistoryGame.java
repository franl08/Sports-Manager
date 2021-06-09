package Model;

import java.time.LocalDate;

public class HistoryGame {
    private String homeTeam;
    private String awayTeam;
    private int homeGoals;
    private int awayGoals;
    private LocalDate gameDate;

    public HistoryGame(Game g){
        this.homeTeam = g.getHomeTeam().getName();
        this.awayTeam = g.getAwayTeam().getName();
        this.homeGoals = g.getHomeGoals();
        this.awayGoals = g.getAwayGoals();
        this.gameDate = g.getLd();
    }

    public HistoryGame(String homeTeam, String awayTeam, int homeGoals, int awayGoals, LocalDate gameDate) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeGoals = homeGoals;
        this.awayGoals = awayGoals;
        this.gameDate = gameDate;
    }

    public HistoryGame(HistoryGame g){
        this.homeTeam = g.getHomeTeam();
        this.awayTeam = g.getAwayTeam();
        this.homeGoals = g.getHomeGoals();
        this.awayGoals = g.getAwayGoals();
        this.gameDate = g.getGameDate();
    }

    public HistoryGame clone(){
        return new HistoryGame(this);
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

    public LocalDate getGameDate() {
        return this.gameDate;
    }

    public void setGameDate(LocalDate gameDate) {
        this.gameDate = gameDate;
    }


}
