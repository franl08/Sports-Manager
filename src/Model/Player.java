package Model;

import java.io.Serializable;
import java.util.*;

/**
 * Player abstract class
 */
public abstract class Player implements Serializable {
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
        this.name = "n/a";
        this.number = -1;
        this.currentTeamName = null;
        this.overall = 0;
        this.historic = new ArrayList<>();
        this.position = null;
    }

    /**
     * Constructor with player name, number, current team name, historic and position
     * @param name Player name
     * @param number Player number
     * @param currentTeamName Player current team name
     * @param historic Player historic
     * @param position Player position
     */
    public Player(String name, int number, String currentTeamName, List<String> historic, Position position) {
        this.name = name;
        this.setNumber(number);
        this.overall = 0;
        this.setHistoric(historic);
        this.setCurrentTeamName(currentTeamName);
        this.position = position;
    }

    /**
     * Constructor with player name, number, current team name and position
     * @param name Player name
     * @param number Player number
     * @param currentTeamName Player current team name
     * @param position Player position
     */
    public Player(String name, int number, String currentTeamName, Position position) {
        this.name = name;
        this.setNumber(number);
        this.setCurrentTeamName(currentTeamName);
        this.overall = 0;
        this.historic = new ArrayList<>();
        this.position = position;
    }

    /**
     * Constructor with player name, number and position
     * @param name Player name
     * @param number Player number
     * @param position Player position
     */
    public Player(String name, int number, Position position){
        this.name = name;
        this.setNumber(number);
        this.currentTeamName = "n/a";
        this.overall = 0;
        this.historic = new ArrayList<>();
        this.position = position;
    }

    /**
     * Copy constructor
     * @param p Player to copy
     */
    public Player(Player p){
        this.name = p.getName();
        this.number = p.getNumber();
        this.setHistoric(p.getHistoric());
        this.setCurrentTeamName(p.getCurrentTeamName());
        this.overall = p.getOverall();
        this.position = p.getPosition();
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
        if(this.historic != null) {
            if(this.historic.size() > 0) {
                if (!this.historic.get(this.historic.size() - 1).equals(currentTeamName)) {
                    this.historic.add(currentTeamName);
                }
            }
            else{
                if(this.currentTeamName != null) this.historic.add(this.currentTeamName);
                this.historic.add(currentTeamName);
            }
        }
        else
        {
            this.historic = new ArrayList<>();
            this.historic.add(currentTeamName);
        }
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
        if(number < 0) this.number = 0;
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
        return (this.name.equals(p.getName()) && this.number == p.getNumber() && this.currentTeamName.equals(p.getCurrentTeamName()));
    }

    /**
     * Method to change player team
     * @param newTeam New team name
     */
    public void changeTeam(String newTeam){
        this.setCurrentTeamName(newTeam);
    }


    /**
     * Method to change a player's attribute
     * @param attribute Attribute signature
     * @param newValue New value
     * @throws InvalidAttributeException Exception to prevent invalid attributes
     */
    public abstract void updateAttribute(int attribute, int newValue) throws InvalidAttributeException;
}
