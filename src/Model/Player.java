package Model;

import java.util.*;

public abstract class Player {
    private String id;
    private String name;
    private int number;
    private String currentTeamName;
    private int overall;
    private List<String> historic;
    private Position position;

    /**
     * Empty constructor
     */
    public Player(){
        this.id = "n/a";
        this.name = "n/a";
        this.number = -1;
        this.currentTeamName = null;
        this.overall = 0;
        this.historic = new ArrayList<>();
        this.position = null;
    }

    /**
     * Constructor with player ID, name, current team name, historic and position
     * @param id Player ID
     * @param name Player Name
     * @param currentTeamName Player current team name
     * @param historic Player historic
     * @param position Player position
     */
    public Player(String id, String name, String currentTeamName, List<String> historic, Position position) {
        this.id = id;
        this.name = name;
        this.number = -1;
        this.overall = 0;
        this.setHistoric(historic);
        this.setCurrentTeamName(currentTeamName);
        this.position = position;
    }

    /**
     * Constructor with player ID, name, number, current team name, historic and position
     * @param id Player ID
     * @param name Player name
     * @param number Player number
     * @param currentTeamName Player current team name
     * @param historic Player historic
     * @param position Player position
     */
    public Player(String id, String name, int number, String currentTeamName, List<String> historic, Position position) {
        this.id = id;
        this.name = name;
        this.setNumber(number);
        this.overall = 0;
        this.setHistoric(historic);
        this.setCurrentTeamName(currentTeamName);
        this.position = position;
    }

    /**
     * Constructor with player ID, name, current team name and position
     * @param id Player ID
     * @param name Player name
     * @param currentTeamName Player current team name
     * @param position Player position
     */
    public Player(String id, String name, String currentTeamName, Position position) {
        this.id = id;
        this.name = name;
        this.number = -1;
        this.overall = 0;
        this.historic = new ArrayList<>();
        this.setCurrentTeamName(currentTeamName);
        this.position = position;
    }

    /**
     * Constructor with player ID, name, number, current team name and position
     * @param id Player ID
     * @param name Player name
     * @param number Player number
     * @param currentTeamName Player current team name
     * @param position Player position
     */
    public Player(String id, String name, int number, String currentTeamName, Position position) {
        this.id = id;
        this.name = name;
        this.setNumber(number);
        this.setCurrentTeamName(currentTeamName);
        this.overall = 0;
        this.historic = new ArrayList<>();
        this.position = position;
    }

    /**
     * Copy constructor
     * @param p Player to copy
     */
    public Player(Player p){
        this.id = p.getId();
        this.name = p.getName();
        this.number = p.getNumber();
        this.setHistoric(p.getHistoric());
        this.setCurrentTeamName(p.getCurrentTeamName());
        this.overall = p.getOverall();
    }

    /**
     * Cloning abstract method
     * @return Cloned player
     */
    public abstract Player clone();

    /**
     * Player position getter
     * @return Player position
     */
    public Position getPosition(){
        return this.position;
    };

    /**
     * Player position setter
     * @param position Position to set
     */
    public void setPosition(Position position){
        this.position = position;
    }

    /**
     * Current position abstract getter
     * @return Current position
     */
    public abstract Position getCurPosition();

    /**
     * ID getter
     * @return Player ID
     */
    public String getId() {
        return this.id;
    }

    /**
     * ID setter
     * @param id ID to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Name getter
     * @return Player name
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
     * Team name getter
     * @return Player team name
     */
    public String getCurrentTeamName() {
        return this.currentTeamName;
    }

    /**
     * Team name setter
     * @param currentTeamName Team name to set
     */
    public void setCurrentTeamName(String currentTeamName) {
        if(this.historic.size() > 0) {
            if (!this.historic.get(this.historic.size() - 1).equals(currentTeamName)) {
                this.historic.add(currentTeamName);
            }
        }
        else this.historic.add(currentTeamName);
        this.currentTeamName = currentTeamName;
    }

    /**
     * Historic getter
     * @return Player historic
     */
    public List<String> getHistoric() {
        return new ArrayList<>(this.historic);
    }

    /**
     * Historic setter
     * @param historic Historic to set
     */
    public void setHistoric(List<String> historic) {
        this.historic = new ArrayList<>();
        if(historic != null) this.historic.addAll(historic);
    }

    /**
     * Number getter
     * @return Player number
     */
    public int getNumber(){
        return this.number;
    }

    /**
     * Number setter
     * @param number Number to set
     */
    public void setNumber(int number){
        if(number < 1) this.number = 1;
        else this.number = Math.min(number, 99);
    }

    /**
     * Overall getter
     * @return Player overall
     */
    public int getOverall(){
        return this.overall;
    }

    /**
     * Overall setter
     * @param overall Overall to set
     */
    public void setOverall(int overall){
        this.overall = overall;
    }

    /**
     * Method to get Player as a String
     * @return Player as a String
     */
    public String toString(){
        StringBuilder sb = new StringBuilder("Player: ")
                .append(name).append(" | ").append(currentTeamName).append(" | ")
                .append("Teams Historic: ").append(historic.toString())
                .append(" | Overall: ").append(overall);
        return sb.toString();
    }

    /**
     * Method to check if an object is equal to a player
     * @param o Object to compare
     * @return True if object is equal to player, false otherwise
     */
    public boolean equals(Object o){
        if(this == o) return true;
        else if(o == null || o.getClass() != this.getClass()) return false;
        Player p = (Player) o;
        return (this.id.equals(p.getId()));
    }

    /**
     * Method to change player team
     * @param newTeam New team name
     */
    public void changeTeam(String newTeam){
        this.setCurrentTeamName(newTeam);
    }


}
