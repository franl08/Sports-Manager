package Model;

import java.util.List;
import java.util.Set;

// Wing Back
public class WB extends Player {
    private int overall;

    public WB(String name, int number, Team currentTeam, Position pos, int pace, int endurance, int skill, int impulsion, int heading, int finishing, int passing, int tackling, int positioning) {
        super(name, number, currentTeam, pos, pace, endurance, skill, impulsion, heading, finishing, passing, tackling, positioning);
        this.setOverall();
    }

    public WB(String name, int number, Team currentTeam, Set<Team> teamsHistory, Position pos, int pace, int endurance, int skill, int impulsion, int heading, int finishing, int passing, int tackling, int positioning) {
        super(name, number, currentTeam, teamsHistory, pos, pace, endurance, skill, impulsion, heading, finishing, passing, tackling, positioning);
        this.setOverall();
    }

    public WB(WB w){
        super(w.getId(), w.getName(), w.getNumber(), w.getCurrentTeam(), w.getTeamsHistory(), w.getPos(), w.getPace(), w.getEndurance(), w.getSkill(), w.getImpulsion(), w.getHeading(), w.getFinishing(), w.getPassing(), w.getTackling(), w.getPositioning());
        this.overall = w.getOverall();
    }

    public WB clone(){
        return new WB(this);
    }

    public int getOverall() {
        return this.overall;
    }

    public void setOverall() {
        this.overall = calOverall(Position.WB);
    }
}

