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

    public Player(){
        this.id = "n/a";
        this.name = "n/a";
        this.number = -1;
        this.currentTeamName = null;
        this.overall = 0;
        this.historic = new ArrayList<>();
        this.position = null;
    }

    public Player(String id, String name, String currentTeamName, List<String> historic, Position position) {
        this.id = id;
        this.name = name;
        this.number = -1;
        this.overall = 0;
        this.setHistoric(historic);
        this.setCurrentTeamName(currentTeamName);
        this.position = position;
    }

    public Player(String id, String name, int number, String currentTeamName, List<String> historic, Position position) {
        this.id = id;
        this.name = name;
        this.setNumber(number);
        this.overall = 0;
        this.setHistoric(historic);
        this.setCurrentTeamName(currentTeamName);
        this.position = position;
    }

    public Player(String id, String name, String currentTeamName, Position position) {
        this.id = id;
        this.name = name;
        this.number = -1;
        this.overall = 0;
        this.historic = new ArrayList<>();
        this.setCurrentTeamName(currentTeamName);
        this.position = position;
    }

    public Player(String id, String name, int number, String currentTeamName, Position position) {
        this.id = id;
        this.name = name;
        this.setNumber(number);
        this.setCurrentTeamName(currentTeamName);
        this.overall = 0;
        this.historic = new ArrayList<>();
        this.position = position;
    }

    public Player(Player p){
        this.id = p.getId();
        this.name = p.getName();
        this.number = p.getNumber();
        this.setHistoric(p.getHistoric());
        this.setCurrentTeamName(p.getCurrentTeamName());
        this.overall = p.getOverall();
    }

    public abstract Player clone();

    public Position getPosition(){
        return this.position;
    };

    public void setPosition(Position position){
        this.position = position;
    }

    public abstract Position getCurPosition();

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrentTeamName() {
        return this.currentTeamName;
    }

    public void setCurrentTeamName(String currentTeamName) {
        if(this.historic.size() > 0) {
            if (!this.historic.get(this.historic.size() - 1).equals(currentTeamName)) {
                this.historic.add(currentTeamName);
            }
        }
        else this.historic.add(currentTeamName);
        this.currentTeamName = currentTeamName;
    }

    public List<String> getHistoric() {
        return new ArrayList<>(this.historic);
    }

    public void setHistoric(List<String> historic) {
        this.historic = new ArrayList<>();
        if(historic != null) this.historic.addAll(historic);
    }

    public int getNumber(){
        return this.number;
    }

    public void setNumber(int number){
        if(number < 1) this.number = 1;
        else this.number = Math.min(number, 99);
    }

    public int getOverall(){
        return this.overall;
    }

    public void setOverall(int overall){
        this.overall = overall;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder("Player: ")
                .append(name).append(" | ").append(currentTeamName).append(" | ")
                .append("Teams Historic: ").append(historic.toString())
                .append(" | Overall: ").append(overall);
        return sb.toString();
    }

    public boolean equals(Object o){
        if(this == o) return true;
        else if(o == null || o.getClass() != this.getClass()) return false;
        Player p = (Player) o;
        return (this.id.equals(p.getId()));
    }

    public void changeTeam(String newTeam){
        this.setCurrentTeamName(newTeam);
    }


}
