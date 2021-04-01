package Model;

import java.util.HashSet;
import java.util.Set;

//TODO equals(), toString(), correct setters/getters;

public class Player {
    private int id;
    private String name;
    private int number;
    private Team currentTeam;
    private Set<Team> teamsHistory;
    private Position pos;
    private int pace;
    private int endurance;
    private int skill;
    private int impulsion;
    private int heading;
    private int finishing;
    private int passing;
    private int tackling;
    private int positioning;

    public Player(int id, String name, int number, Team currentTeam, Set<Team> teamsHistory, Position pos, int pace, int endurance, int skill, int impulsion, int heading, int finishing, int passing, int tackling, int positioning) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.currentTeam = currentTeam;
        this.teamsHistory = teamsHistory;
        this.pos = pos;
        this.pace = pace;
        this.endurance = endurance;
        this.skill = skill;
        this.impulsion = impulsion;
        this.heading = heading;
        this.finishing = finishing;
        this.passing = passing;
        this.tackling = tackling;
        this.positioning = positioning;
    }

    public Player(String name, int number, Team currentTeam, Set<Team> teamsHistory, Position pos, int pace, int endurance, int skill, int impulsion, int heading, int finishing, int passing, int tackling, int positioning) {
        this.setId(); // TODO HASHCODE
        this.name = name;
        this.number = number;
        this.currentTeam = currentTeam;
        this.teamsHistory = teamsHistory;
        this.pos = pos;
        this.pace = pace;
        this.endurance = endurance;
        this.skill = skill;
        this.impulsion = impulsion;
        this.heading = heading;
        this.finishing = finishing;
        this.passing = passing;
        this.tackling = tackling;
        this.positioning = positioning;
    }

    public Player(String name, int number, Team currentTeam, Position pos, int pace, int endurance, int skill, int impulsion, int heading, int finishing, int passing, int tackling, int positioning) {
        this.setId(); // TODO HASHCODE
        this.name = name;
        this.number = number;
        this.currentTeam = currentTeam;
        this.teamsHistory = new HashSet<Team>();
        this.teamsHistory.add(currentTeam);
        this.pos = pos;
        this.pace = pace;
        this.endurance = endurance;
        this.skill = skill;
        this.impulsion = impulsion;
        this.heading = heading;
        this.finishing = finishing;
        this.passing = passing;
        this.tackling = tackling;
        this.positioning = positioning;
    }

    public Player(Player p){
        this.id = p.getId();
        this.name = p.getName();
        this.number = p.getNumber();
        this.currentTeam = p.getCurrentTeam();
        this.teamsHistory = p.getTeamsHistory();
        this.pos = p.getPos();
        this.pace = p.getPace();
        this.endurance = p.getEndurance();
        this.skill = p.getSkill();
        this.impulsion = p.getImpulsion();
        this.heading = p.getHeading();
        this.finishing = p.getFinishing();
        this.passing = p.getPassing();
        this.tackling = p.getTackling();
        this.positioning = p.getPositioning();
    }

    public Player clone(){
        return new Player(this);
    }

    public int getId() {
        return this.id;
    }

    public void setId() {
        this.id = hashCode(); //TODO HASHCODE
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Team getCurrentTeam() {
        return this.currentTeam;
    }

    public void setCurrentTeam(Team currentTeam) {
        this.currentTeam = new Team(currentTeam.clone());
    }

    public Set<Team> getTeamsHistory() {
        return this.teamsHistory;
    }

    public void setTeamsHistory(Set<Team> teamsHistory) {
        this.teamsHistory = new HashSet<>();
        for (Team t : teamsHistory) this.teamsHistory.add(t.clone());
    }

    public Position getPos() {
        return this.pos;
    }

    public void setPos(Position pos) {
        this.pos = pos;
    }

    public int getPace() {
        return this.pace;
    }

    public void setPace(int pace) {
        this.pace = pace;
    }

    public int getEndurance() {
        return this.endurance;
    }

    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }

    public int getSkill() {
        return this.skill;
    }

    public void setSkill(int skill) {
        this.skill = skill;
    }

    public int getImpulsion() {
        return this.impulsion;
    }

    public void setImpulsion(int impulsion) {
        this.impulsion = impulsion;
    }

    public int getHeading() {
        return this.heading;
    }

    public void setHeading(int heading) {
        this.heading = heading;
    }

    public int getFinishing() {
        return this.finishing;
    }

    public void setFinishing(int finishing) {
        this.finishing = finishing;
    }

    public int getPassing() {
        return this.passing;
    }

    public void setPassing(int passing) {
        this.passing = passing;
    }

    public int getTackling() {
        return this.tackling;
    }

    public void setTackling(int tackling) {
        this.tackling = tackling;
    }

    public int getPositioning() {
        return this.positioning;
    }

    public void setPositioning(int positioning) {
        this.positioning = positioning;
    }

    public int calOverall(Position pos) {
        int ov = 0;
        if (pos.equals(Position.AT)) {
            ov = (int) (((this.pace * 15) + (this.endurance * 10) + (this.skill * 10) + (this.impulsion * 10) + (this.heading * 10) + (this.finishing * 25) + (this.passing * 10) + (this.tackling * 3) + (positioning * 7)) / 100);
        } else if (pos.equals(Position.WA)) {
            ov = (int) (((this.pace * 25) + (this.endurance * 15) + (this.skill * 15) + (this.impulsion * 5) + (this.heading * 5) + (this.finishing * 10) + (this.passing * 15) + (this.tackling * 3) + (this.positioning * 7)) / 100);
        } else if (pos.equals(Position.MD)) {
            ov = (int) (((this.pace * 10) + (this.endurance * 12) + (this.skill * 11) + (this.impulsion * 3) + (this.heading * 5) + (this.finishing * 9) + (this.passing * 25) + (this.tackling * 10) + (this.positioning * 15)) / 100);
        } else if (pos.equals(Position.DF)) {
            ov = (int) (((this.pace * 8) + (this.endurance * 10) + (this.skill * 7) + (this.impulsion * 15) + (this.heading * 10) + (this.finishing * 3) + (this.passing * 12) + (this.tackling * 25) + (this.positioning * 10)) / 100);
        } else if (pos.equals(Position.WB)) {
            ov = (int) (((this.pace * 20) + (this.endurance * 10) + (this.skill * 10) + (this.impulsion * 7) + (this.heading * 5) + (this.finishing * 3) + (this.passing * 15) + (this.tackling * 20) + (this.positioning * 10)) / 100);
        }
        return ov;
    }

    public int calOverall(int elasticity) {
        return (int) ((this.pace + (this.endurance * 5) + this.skill + (this.impulsion * 15) + this.heading + this.finishing + (this.passing * 5) + (this.tackling * 5) + (this.positioning * 10) + (elasticity * 65)) / 100);
    }


}
