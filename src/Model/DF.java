package Model;

import java.util.List;
import java.util.Set;

// Defender
public class DF extends Player{
    private int overall;

    public DF(String name, int number, Team currentTeam, Position pos, int pace, int endurance, int skill, int impulsion, int heading, int finishing, int passing, int tackling, int positioning) {
        super(name, number, currentTeam, pos, pace, endurance, skill, impulsion, heading, finishing, passing, tackling, positioning);
        this.setOverall();
    }

    public DF(String name, int number, Team currentTeam, Set<Team> teamsHistory, Position pos, int pace, int endurance, int skill, int impulsion, int heading, int finishing, int passing, int tackling, int positioning) {
        super(name, number, currentTeam, teamsHistory, pos, pace, endurance, skill, impulsion, heading, finishing, passing, tackling, positioning);
        this.setOverall();
    }

    public DF(DF d){
        super(d.getId(), d.getName(), d.getNumber(), d.getCurrentTeam(), d.getTeamsHistory(), d.getPos(), d.getPace(), d.getEndurance(), d.getSkill(), d.getImpulsion(), d.getHeading(), d.getFinishing(), d.getPassing(), d.getTackling(), d.getPositioning());
        this.overall = d.getOverall();
    }

    public DF clone(){
        return new DF(this);
    }

    public int getOverall(){
        return this.overall;
    }

    public void setOverall() {
        this.overall = calOverall(Position.DF);
    }
}
