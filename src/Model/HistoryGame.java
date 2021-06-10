package Model;

import java.time.LocalDate;

public class HistoryGame {
    /**
     * Home team name
     */
    private String homeTeam;
    /**
     * Away team name
     */
    private String awayTeam;
    /**
     * Home goals
     */
    private int homeGoals;
    /**
     * Away goals
     */
    private int awayGoals;
    /**
     * Game date
     */
    private LocalDate gameDate;

    /**
     * Constructor with a full game
     * @param g Game to format
     */
    public HistoryGame(Game g){
        this.homeTeam = g.getHomeTeam().getName();
        this.awayTeam = g.getAwayTeam().getName();
        this.homeGoals = g.getHomeGoals();
        this.awayGoals = g.getAwayGoals();
        this.gameDate = g.getLd();
    }

    /**
     * Parametrized constructor
     * @param homeTeam Home team name
     * @param awayTeam Away team name
     * @param homeGoals Home goals
     * @param awayGoals Away goals
     * @param gameDate Game date
     */
    public HistoryGame(String homeTeam, String awayTeam, int homeGoals, int awayGoals, LocalDate gameDate) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeGoals = homeGoals;
        this.awayGoals = awayGoals;
        this.gameDate = gameDate;
    }

    /**
     * Copy constructor
     * @param g Game to copy
     */
    public HistoryGame(HistoryGame g){
        this.homeTeam = g.getHomeTeam();
        this.awayTeam = g.getAwayTeam();
        this.homeGoals = g.getHomeGoals();
        this.awayGoals = g.getAwayGoals();
        this.gameDate = g.getGameDate();
    }

    /**
     * Cloning method
     * @return HistoryGame clone
     */
    public HistoryGame clone(){
        return new HistoryGame(this);
    }

    /**
     * Home team name getter
     * @return Home team name
     */
    public String getHomeTeam() {
        return this.homeTeam;
    }

    /**
     * Home team name setter
     * @param homeTeam Name to set
     */
    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    /**
     * Away team name getter
     * @return Away team name
     */
    public String getAwayTeam() {
        return this.awayTeam;
    }

    /**
     * Away team name setter
     * @param awayTeam Name to set
     */
    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    /**
     * Number of home goals getter
     * @return Number of home goals
     */
    public int getHomeGoals() {
        return this.homeGoals;
    }

    /**
     * Home goals setter
     * @param homeGoals Home goals to set
     */
    public void setHomeGoals(int homeGoals) {
        this.homeGoals = homeGoals;
    }

    /**
     * Number of away goals getter
     * @return Number of away goals
     */
    public int getAwayGoals() {
        return this.awayGoals;
    }

    /**
     * Away goals setter
     * @param awayGoals Away goals to set
     */
    public void setAwayGoals(int awayGoals) {
        this.awayGoals = awayGoals;
    }

    /**
     * Game's date getter
     * @return Game's date
     */
    public LocalDate getGameDate() {
        return this.gameDate;
    }

    /**
     * Game's date setter
     * @param gameDate Date to set
     */
    public void setGameDate(LocalDate gameDate) {
        this.gameDate = gameDate;
    }


}
