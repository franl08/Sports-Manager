package Model;

import java.util.*;

public abstract class Player {
    private String id;
    private String name;
    private int number;
    private Team currentTeam;
    private int overall;
    private List<Team> historic;

    public Player(){
        this.id = "n/a";
        this.name = "n/a";
        this.number = -1;
        this.currentTeam = null;
        this.overall = 0;
        this.historic = null;
    }

    public Player(String id, String name, Team currentTeam, List<Team> historic) {
        this.id = id;
        this.name = name;
        this.number = -1;
        this.setCurrentTeam(currentTeam);
        this.overall = 0;
        this.setHistoric(historic);
    }

    public Player(String id, String name, int number, Team currentTeam, List<Team> historic) {
        this.id = id;
        this.name = name;
        this.setNumber(number);
        this.setCurrentTeam(currentTeam);
        this.overall = 0;
        this.setHistoric(historic);
    }

    public Player(String id, String name, Team currentTeam) {
        this.id = id;
        this.name = name;
        this.number = -1;
        this.setCurrentTeam(currentTeam);
        this.overall = 0;
        this.historic = new ArrayList<Team>();
    }

    public Player(String id, String name, int number, Team currentTeam) {
        this.id = id;
        this.name = name;
        this.setNumber(number);
        this.setCurrentTeam(currentTeam);
        this.overall = 0;
        this.historic = new ArrayList<Team>();
    }

    public Player(Player p){
        this.id = p.getId();
        this.name = p.getName();
        this.number = p.getNumber();
        this.currentTeam = p.getCurrentTeam();
        this.overall = p.getOverall();
        this.setHistoric(p.getHistoric());
    }

    public abstract Player clone();

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

    public Team getCurrentTeam() {
        return this.currentTeam.clone();
    }

    public void setCurrentTeam(Team currentTeam) {
        int histSize = this.historic.size();
        this.currentTeam = currentTeam.clone();
        if(!this.historic.get(histSize - 1).equals(currentTeam)) this.historic.add(currentTeam.clone());
    }

    public List<Team> getHistoric() {
        List<Team> ans = new ArrayList<Team>();
        for(Team t : this.historic)
            ans.add(t.clone());
        return ans;
    }

    public void setHistoric(List<Team> historic) {
        for(Team t : historic)
            this.historic.add(t.clone());
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
                .append(name).append(" | ").append(currentTeam.getName()).append(" | ")
                .append("Teams Historic: ").append(historic.toString())
                .append("Overall: ").append(overall);
        return sb.toString();
    }

    public boolean equals(Object o){
        if(this == o) return true;
        else if(o == null || o.getClass() != this.getClass()) return false;
        Player p = (Player) o;
        return (this.id.equals(p.getId()));
    }

    public void changeTeam(Team t){
        this.setCurrentTeam(t.clone());
    }

}
