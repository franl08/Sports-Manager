package Model;

import java.util.List;
import java.util.Set;

// Attacker
public class AT extends Player{
    private int overall;

    public AT(String name, int number, Team currentTeam, Position pos, int pace, int endurance, int skill, int impulsion, int heading, int finishing, int passing, int tackling, int positioning) {
        super(name, number, currentTeam, pos, pace, endurance, skill, impulsion, heading, finishing, passing, tackling, positioning);
        this.setOverall();
    }

    public AT(String name, int number, Team currentTeam, Set<Team> teamsHistory, Position pos, int pace, int endurance, int skill, int impulsion, int heading, int finishing, int passing, int tackling, int positioning) {
        super(name, number, currentTeam, teamsHistory, pos, pace, endurance, skill, impulsion, heading, finishing, passing, tackling, positioning);
        this.setOverall();
    }

    public AT(AT a){
        super(a.getId(), a.getName(), a.getNumber(), a.getCurrentTeam(), a.getTeamsHistory(), a.getPos(), a.getPace(), a.getEndurance(), a.getSkill(), a.getImpulsion(), a.getHeading(), a.getFinishing(), a.getPassing(), a.getTackling(), a.getPositioning());
        this.overall = a.getOverall();
    }

    public AT clone(){
        return new AT(this);
    }

    public int getOverall(){
        return this.overall;
    }

    public void setOverall() {
        this.overall = calOverall(Position.AT);
    }
}
