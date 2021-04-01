package Model;

import java.util.Set;

// Goalkeeper
public class GK extends Player{
    private int elasticity;
    private int overall;

    public GK(String name, int number, Team currentTeam, Set<Team> teamsHistory, Position pos, int pace, int endurance, int skill, int impulsion, int heading, int finishing, int passing, int tackling, int positioning, int elasticity) {
        super(name, number, currentTeam, teamsHistory, pos, pace, endurance, skill, impulsion, heading, finishing, passing, tackling, positioning);
        this.elasticity = elasticity;
        this.setOverall();
    }

    public GK(String name, int number, Team currentTeam, Position pos, int pace, int endurance, int skill, int impulsion, int heading, int finishing, int passing, int tackling, int positioning, int elasticity, int overall) {
        super(name, number, currentTeam, pos, pace, endurance, skill, impulsion, heading, finishing, passing, tackling, positioning);
        this.elasticity = elasticity;
        this.setOverall();
    }

    public GK(String name, int number, Team currentTeam, Set<Team> teamsHistory, Position pos, int pace, int endurance, int skill, int impulsion, int heading, int finishing, int passing, int tackling, int positioning) {
        super(name, number, currentTeam, teamsHistory, pos, pace, endurance, skill, impulsion, heading, finishing, passing, tackling, positioning);
        this.setElasticity(0);
        this.setOverall();
    }

    public GK(String name, int number, Team currentTeam, Position pos, int pace, int endurance, int skill, int impulsion, int heading, int finishing, int passing, int tackling, int positioning) {
        super(name, number, currentTeam, pos, pace, endurance, skill, impulsion, heading, finishing, passing, tackling, positioning);
        this.setElasticity(0);
        this.setOverall();
    }

    // Isto preserva o encapsulamento?
    public GK(GK g){
        super(g.getId(), g.getName(), g.getNumber(), g.getCurrentTeam(), g.getTeamsHistory(), g.getPos(), g.getPace(), g.getEndurance(), g.getSkill(), g.getImpulsion(), g.getHeading(), g.getFinishing(), g.getPassing(), g.getTackling(), g.getPositioning());
        this.elasticity = g.getElasticity();
        this.overall = g.getOverall();
    }

    public GK clone(){
        return new GK(this);
    }

    public int getElasticity() {
        return this.elasticity;
    }

    public void setElasticity(int elasticity) {
        this.elasticity = elasticity;
    }

    public int getOverall(){
        return this.overall;
    }

    public void setOverall() {
        this.overall = calOverall(this.getElasticity());
    }

}
